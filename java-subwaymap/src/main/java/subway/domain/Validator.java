package subway.domain;

public class Validator {

    public static void isInRegex(String userSelection, String regex, String errorMessage) {
        if (userSelection.matches(regex) == false) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void isUnderTwoCharacters(String name, String errorMessage) {
        if (name.length() < 2) {
            throw new IllegalArgumentException(errorMessage);
        }


    }

    public static void isWithRepetition(String stationName, String errorMessage) {
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(stationName)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    public static boolean isContaining(String stationName) {
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(stationName)) {
                return true;
            }
        }
        return false;
    }

}
