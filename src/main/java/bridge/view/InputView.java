package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        final int bridgeSize;
        final String input = Console.readLine();
        validate(input);
        bridgeSize = Integer.parseInt(input);

        return bridgeSize;
    }

    private void validate(String input) {
        final String numberRangeRegex = "^[3-9]{1}$|^[1]{1}[0-9]{1}$|^[2]{1}[0]{1}$";
        if (!input.matches(numberRangeRegex)) {
            throw new IllegalArgumentException("[ERROR] 3~20 범위의 숫자를 입력해주세요.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
