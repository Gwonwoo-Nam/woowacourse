package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    final static String NUMBER_RANGE_REGEX = "^[3-9]{1}$|^[1]{1}[0-9]{1}$|^[2]{1}[0]{1}$";
    final static String MOVING_REGEX = "^[UD]$";
    final static String GAME_COMMAND_REGEX = "^[RQ]$";
    final static String NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 3~20 범위의 숫자를 입력해주세요.";
    final static String MOVING_ERROR_MESSAGE = "[ERROR] U 혹은 D를 입력해주세요.";
    final static String GAME_COMMAND_ERROR_MESSAGE = "[ERROR] R 혹은 Q를 입력해주세요.";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                String input = Console.readLine();
                validate(input, NUMBER_RANGE_REGEX, NUMBER_RANGE_ERROR_MESSAGE);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }




    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                String input = Console.readLine();
                validate(input, MOVING_REGEX, MOVING_ERROR_MESSAGE);
                return input ;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                String input = Console.readLine();
                validate(input, GAME_COMMAND_REGEX, GAME_COMMAND_ERROR_MESSAGE);
                return input ;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validate(String input, String regex, String errorMessage) {
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
