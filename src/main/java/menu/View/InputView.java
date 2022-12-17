package menu.View;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import menu.Domain.Coach;
import menu.Domain.MenuRepository;

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

    public static List<String> readUnfavorMenuList() {
        String input = Console.readLine();
        List<String> inputList = new ArrayList<>();
        if (input.isEmpty()) {
            return inputList;
        }
        for (String inputSplit : input.split(",")) {
            inputList.add(inputSplit);
            for (String menuName : inputList) {
                if (!MenuRepository.validateMenu(menuName)) {
                    throw new IllegalArgumentException(InfoMessages.ERROR_MENU_NAME.getMessage());
                }
            }
        }
        if (inputList.size() > 2) {
            throw new IllegalArgumentException(InfoMessages.ERROR_MENU_NUMBER.getMessage());
        }
        return inputList;
    }
}
