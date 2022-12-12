package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class InputView {

    private static final String INPUT_TRIAL_NUMBER_REGEX = "^[1-9][0-9]*$";
    private static final String INPUT_CAR_NAME_REGEX = "^.+$";
    private static final String INPUT_CAR_NAME_LENGTH_REGEX = "^([^,]){1,5}$";
    private static final String INPUT_TRIAL_NUMBER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양수 정수여야 한다.";
    private static final String INPUT_CAR_NAME_ERROR_MESSAGE = "[ERROR] 쉼표로 구분된 차량을 입력해주세요.";
    private static final String INPUT_CAR_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 차량 이름은 1자 이상 5자 이하만 가능합니다.";
    private static final String INPUT_CAR_NAME_SIZE_ERROR_MESSAGE = "[ERROR] 차량 이름은 2개 이상 입력해주세요.";
    private static final String INPUT_CAR_NAME_REPETITION_ERROR_MESSAGE = "[ERROR] 차량 이름 간 중복이 없어야 합니다.";

    public List<String> readCarList() {
        List<String> carNameList = null;
        while (true) {
            try {
                carNameList = readCarInput();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return carNameList;
    }

    public int readTrialNumber() {
        String trialInput;
        while (true) {
            try {
                trialInput = readTrialInput();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return Integer.parseInt(trialInput);
    }

    private List<String> readCarInput() {
        String input = Console.readLine();
        validateRegex(input, INPUT_CAR_NAME_REGEX, INPUT_CAR_NAME_ERROR_MESSAGE);

        List<String> carNameList = new ArrayList<>(Arrays.asList(input.split(",")));
        validateSize(carNameList);
        for (String carName : carNameList) {
            validateRegex(carName, INPUT_CAR_NAME_LENGTH_REGEX,
                INPUT_CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
        validateRepetition(carNameList);
        return carNameList;
    }

    private void validateSize(List<String> carNameList) {
        if (carNameList.size() < 2) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateRepetition(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        if (carNameSet.size() != carNameList.size()) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_REPETITION_ERROR_MESSAGE);
        }
    }

    private String readTrialInput() {
        String input = Console.readLine();
        validateRegex(input, INPUT_TRIAL_NUMBER_REGEX, INPUT_TRIAL_NUMBER_ERROR_MESSAGE);

        return input;
    }


    private void validateRegex(String input, String regex, String errorMessage) {
        if (input.matches(regex) == false) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
