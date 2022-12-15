package pairmatching.controller;

import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.view.InfoMessages;

public class Validator {
    public static void matchRegex(String input, String regex, String errorMessage) {
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void isValid(String inputLevel, Mission inputMission) {
        Level[] levels = Level.values();
        for (Level level : levels) {
            if (level.getName().equals(inputLevel)) {
                if (isValidMission(inputMission, level)) {
                    return;
                }
            }
        }
        throw new IllegalArgumentException(InfoMessages.ERROR_NON_EXIST_OPTION.getMessage());
    }

    private static boolean isValidMission(Mission inputMission, Level level) {
        for (Mission mission : level.getMissions()) {
            if (mission.getName().equals(inputMission.getName())) {
                return true;
            }
        }
        return false;
    }

}
