package menu.View;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static List<String> readCoachNames() {
        InfoMessages.INPUT_COACH_NAMES.println();
        String input = Console.readLine();
        List<String> inputList = new ArrayList<>();
        for (String inputSplit : input.split(",")) {
            if (inputSplit.length() < 2 || inputSplit.length() > 4) {
                throw new IllegalArgumentException(InfoMessages.ERROR_COACH_NAME_LENGTH.getMessage());
            }
            inputList.add(inputSplit);
        }
        if (inputList.size() < 2 || inputList.size() > 5) {
            throw new IllegalArgumentException(InfoMessages.ERROR_COACH_NUMBER.getMessage());
        }
        return inputList;
    }
}
