package subway.Controller;

import java.util.ArrayList;
import java.util.List;
import subway.InfoMessages;
import subway.InputRegex;
import subway.RequestMessages;
import subway.View.InputView;
import subway.View.OutputView;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayController {

    public static void run () {
        initializeStations();

        runMainFeature();




    }

    private static void initializeStations() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
    }

    public static void runMainFeature() {
        InfoMessages.MAIN.println();
        final String mainFeature = InputView.readFeature(InputRegex.MAIN.getRegex());

        if (mainFeature.equals("1")) {
            runStationManagement();
            runMainFeature();
        }
        if (mainFeature.equals("2")) {
            runMainFeature();
        }
        if (mainFeature.equals("3")) {
            runMainFeature();
        }
        if (mainFeature.equals("4")) {
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
            return ;
        }
        if (featureSelection.equals("2")) {
            deleteStation();
            runStationManagement();
            return ;
        }
        if (featureSelection.equals("3")) {
            lookupStation();
            runStationManagement();
        }
    }



    public static void registerStation() {
        String stationName = InputView.readStation();
        StationRepository.addStation(new Station(stationName));
        InfoMessages.STATION_REGISTRATION.println();
    }

    public static void deleteStation() {
        String stationName = InputView.readStation();
        if (StationRepository.deleteStation(stationName)) {
            InfoMessages.STATION_DELETION.println();
            return ;
        }
        InfoMessages.ERROR_STATION_DELETION.println();
    }
    public static void lookupStation() {
        OutputView.lookupStation(StationRepository.stations());
    }


}
