package subway.View;

import java.util.Scanner;
import subway.InfoMessages;
import subway.RequestMessages;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.Validator;

public class InputView {

    public static String readFeature(String regex) {
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            RequestMessages.FEATURE.println();
            String userSelection = scanner.nextLine();
            try {
                Validator.isInRegex(userSelection, regex, InfoMessages.ERROR_FEATURE.getMessage());
                return userSelection;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }



    public static String readRegistrationStation() {
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            RequestMessages.REGISTRATION_STATION.println();
            String stationName = scanner.nextLine();
            try {
                Validator.isUnderTwoCharacters(stationName, InfoMessages.ERROR_STATION_NAME_LENGTH.getMessage());
                Validator.isWithRepetition(stationName,
                    InfoMessages.ERROR_STATION_NAME_REPETITION.getMessage());
                return stationName;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static String readRegistrationLine() {
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            RequestMessages.REGISTRATION_LINE.println();
            String name = scanner.nextLine();
            try {
                Validator.isUnderTwoCharacters(name, InfoMessages.ERROR_STATION_LINE_REPETITION.getMessage());
                Validator.isWithRepetition(name,
                    InfoMessages.ERROR_STATION_NAME_REPETITION.getMessage());

                return name;
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







}
