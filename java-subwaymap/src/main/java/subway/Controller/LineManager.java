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
import subway.domain.Validator;

public class LineManager {

    public static void run() {
        final String featureSelection;
        InfoMessages.LINE_MANAGEMENT.println();
        featureSelection = InputView.readFeature(InputRegex.LINE_MANAGEMENT.getRegex());

        if (featureSelection.equals("1")) {
            registerLine();
            run();
            return;
        }
        if (featureSelection.equals("2")) {
            deleteLine();
            run();
            return;
        }
        if (featureSelection.equals("3")) {
            lookupLine();
            run();
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
        if (!Validator.isContaining(endpoint)) {
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
}
