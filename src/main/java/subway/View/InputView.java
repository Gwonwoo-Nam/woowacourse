package subway.View;

import java.util.Scanner;
import subway.InfoMessages;
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

    public static String readRegistrationStation() {
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            RequestMessages.REGISTRATION_STATION.println();
            String stationName = scanner.nextLine();
            try {
                validateName(stationName, InfoMessages.ERROR_STATION_NAME_LENGTH.getMessage());
                validateRepetition(stationName,
                    InfoMessages.ERROR_STATION_NAME_REPETITION.getMessage());
                return stationName;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String read(String message) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String name = scanner.nextLine();

        return name;
    }


    public static void validateName(String name, String errorMessage) {
        if (name.length() < 2) {
            throw new IllegalArgumentException(errorMessage);
        }


    }

    public static void validateRepetition(String stationName, String errorMessage) {
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(stationName)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    public static boolean validateContains(String stationName) {
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(stationName)) {
                return true;
            }
        }
        return false;
    }

    public static String readRegistrationLine() {
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            RequestMessages.REGISTRATION_LINE.println();
            String lineName = scanner.nextLine();
            try {
                validateName(lineName, InfoMessages.ERROR_STATION_LINE_REPETITION.getMessage());
                validateRepetition(lineName,
                    InfoMessages.ERROR_STATION_NAME_REPETITION.getMessage());

                return lineName;
            } catch (IllegalArgumentException e) {
                InfoMessages.ERROR_LINE_NAME_LENGTH.println();
            }
        }
    }


}
