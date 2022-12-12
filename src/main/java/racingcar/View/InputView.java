package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String INPUT_TRIAL_NUMBER_REGEX = "^[0-9]*$";
    private static final String INPUT_TRIAL_NUMBER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";

    public List<String> readCarName() {
        String input = Console.readLine(); // validate가 필요한지? null 인 경우.

        List<String> carNameList = new ArrayList<>(Arrays.asList(input.split(",")));

        return carNameList;
    }

    public int readTrialNumber() {
        while (true) {
            try {
                String input = Console.readLine();
                validate(input, INPUT_TRIAL_NUMBER_REGEX);
                int trialNumber = Integer.parseInt(input);

                return trialNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

        private void validate (String input, String regex){
            if (input.matches(regex) == false) {
                throw new IllegalArgumentException(INPUT_TRIAL_NUMBER_ERROR_MESSAGE);
            }
        }

    }
