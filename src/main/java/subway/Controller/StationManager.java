package subway.Controller;

import subway.InfoMessages;
import subway.InputRegex;
import subway.RequestMessages;
import subway.View.InputView;
import subway.View.OutputView;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationManager {

    public static void run() {
        final String featureSelection;
        InfoMessages.STATION_MANAGEMENT.println();
        featureSelection = InputView.readFeature(InputRegex.STATION_MANAGEMENT.getRegex());

        if (featureSelection.equals("1")) {
            registerStation();
            run();
            return;
        }
        if (featureSelection.equals("2")) {
            deleteStation();
            run();
            return;
        }
        if (featureSelection.equals("3")) {
            lookupStation();
            run();
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


}
