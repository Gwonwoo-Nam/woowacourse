package subway.View;

import java.util.Scanner;
import subway.InfoMessages;
import subway.InputRegex;
import subway.RequestMessages;
import subway.domain.Station;
import subway.domain.StationRepository;

public class InputView {

    public static String readFeature(String regex) {
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            RequestMessages.FEATURE.println();
            String userSelection = scanner.nextLine();
            try {
                validateRegex(userSelection, regex);
                return userSelection;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void validateRegex(String userSelection, String regex) {
        if (userSelection.matches(regex) == false) {
            throw new IllegalArgumentException(InfoMessages.ERROR_FEATURE.getMessage());
        }
    }

    public static String readStation() {
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            RequestMessages.DELETION_STATION.println();
            String station = scanner.nextLine();
            try {
                validateStationName(station);
                return station;
            } catch (IllegalArgumentException e) {
                InfoMessages.ERROR_STATION_NAME_LENGTH.println();
            }
        }
    }

    public static void validateStationName(String station) {
        if (station.length() < 2) {
            throw new IllegalArgumentException(InfoMessages.ERROR_STATION_NAME_LENGTH.getMessage());
        }
        if (StationRepository.stations().contains(station)) {
            throw new IllegalArgumentException(InfoMessages.ERROR_STATION_NAME_REPETITION.getMessage());
        }
    }
}
