package subway.Controller;

import subway.InfoMessages;
import subway.InputRegex;
import subway.RequestMessages;
import subway.View.InputView;
import subway.View.OutputView;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayController {

    public static void run() {
        initializeStations();
        initializeLines();

        runMainFeature();
    }


    private static void initializeStations() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
    }

    private static void initializeLines() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));

        LineRepository.addStations("2호선", "교대역", "역삼역");
        LineRepository.addStations("3호선", "교대역", "매봉역");
        LineRepository.addStations("신분당선", "강남역", "양재시민의숲역");
    }


    public static void runMainFeature() {
        InfoMessages.MAIN.println();
        final String mainFeature = InputView.readFeature(InputRegex.MAIN.getRegex());

        if (mainFeature.equals("1")) {
            runStationManagement();
            runMainFeature();
        }
        if (mainFeature.equals("2")) {
            runLineManagement();
            runMainFeature();
        }
        if (mainFeature.equals("3")) {
            runSectionManagement();
            runMainFeature();
        }
        if (mainFeature.equals("4")) {
            runMapPrinter();
            runMainFeature();
        }
    }

    private static void runStationManagement() {
        final String featureSelection;
        InfoMessages.STATION_MANAGEMENT.println();
        featureSelection = InputView.readFeature(InputRegex.STATION_MANAGEMENT.getRegex());

        if (featureSelection.equals("1")) {
            registerStation();
            runStationManagement();
            return;
        }
        if (featureSelection.equals("2")) {
            deleteStation();
            runStationManagement();
            return;
        }
        if (featureSelection.equals("3")) {
            lookupStation();
            runStationManagement();
        }
    }


    public static void registerStation() {
        String stationName = InputView.readRegistrationStation();
        StationRepository.addStation(new Station(stationName));
        InfoMessages.STATION_REGISTRATION.println();
    }

    public static void deleteStation() {
        String stationName = InputView.read(RequestMessages.DELETION_STATION.getMessage());
        if (StationRepository.deleteStation(stationName)) {
            InfoMessages.STATION_DELETION.println();
            return;
        }
        InfoMessages.ERROR_STATION_DELETION.println();
        deleteStation();
    }

    public static void lookupStation() {
        OutputView.lookupStation(StationRepository.stations());
    }

    private static void runLineManagement() {
        final String featureSelection;
        InfoMessages.LINE_MANAGEMENT.println();
        featureSelection = InputView.readFeature(InputRegex.LINE_MANAGEMENT.getRegex());

        if (featureSelection.equals("1")) {
            registerLine();
            runLineManagement();
            return;
        }
        if (featureSelection.equals("2")) {
            deleteLine();
            runLineManagement();
            return;
        }
        if (featureSelection.equals("3")) {
            lookupLine();
            runLineManagement();
        }
    }

    public static void registerLine() {
        String lineName = InputView.readRegistrationLine();

        String upstreamEndpoint = InputView.read(RequestMessages.UPSTREAM_ENDPOINT.getMessage());
        String downstreamEndpoint = InputView.read(RequestMessages.DOWNSTREAM_ENDPOINT.getMessage());
        addStationIfNotExist(upstreamEndpoint);
        addStationIfNotExist(downstreamEndpoint);

        LineRepository.addLine(new Line(lineName));
        LineRepository.addStations(lineName, upstreamEndpoint, downstreamEndpoint);
        InfoMessages.LINE_REGISTRATION.println();
    }

    private static void addStationIfNotExist(String endpoint) {
        if (!InputView.validateContains(endpoint)) {
            StationRepository.addStation(new Station(endpoint));
        }
    }

    public static void deleteLine() {
        String lineName = InputView.read(RequestMessages.DELETION_LINE.getMessage());
        if (LineRepository.deleteLineByName(lineName)) {
            InfoMessages.LINE_DELETION.println();
            return;
        }
        InfoMessages.ERROR_LINE_DELETION.println();
        deleteLine();
    }

    public static void lookupLine() {
        OutputView.lookupLine(LineRepository.lines());
    }
    private static void runSectionManagement() {
        final String featureSelection;
        InfoMessages.SECTION_MANAGEMENT.println();
        featureSelection = InputView.readFeature(InputRegex.SECTION_MANAGEMENT.getRegex());

        if (featureSelection.equals("1")) {
            registerSection();
            runSectionManagement();
            return;
        }
        if (featureSelection.equals("2")) {
            deleteSection();
            runSectionManagement();
        }
    }

    private static void registerSection() {

        String lineName = InputView.readRegistrationLine();
        String stationName = InputView.readRegistrationStation();
        String order = InputView.read(RequestMessages.SECTION_REGISTRATION_ORDER.getMessage());
        try {
            InputView.validateRegex(order, InputRegex.ORDER_NAME.getRegex());
        } catch (IllegalArgumentException e) {
            registerSection();
            return ;
        }
        LineRepository.getLineByName(lineName).getStations().add(Integer.parseInt(order),stationName);
    }

    public static void deleteSection() {
        String lineName = InputView.read(RequestMessages.DELETION_LINE.getMessage());
        String stationName = InputView.read("역이름을 입력하세요.");


        LineRepository.deleteSectionByName(lineName, stationName);
    }

    public static void runMapPrinter() {

        for (Line line : LineRepository.lines()) {
            System.out.println(InfoMessages.INFO.getMessage() + line.getName());
            InfoMessages.INFO_SEPERATOR.println();
            for (String stationName : line.getStations()) {
                System.out.println(InfoMessages.INFO.getMessage() + stationName);
            }
            System.out.println();
        }
    }


}
