package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.lang.IllegalArgumentException;

import static java.lang.Boolean.TRUE;

public class Input {


    public void readPurchaseAmount() {
        final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
        final String PURCHASE_MESSAGE = "개를 구매했습니다.";
        final int LOTTO_PRICE = 1000;
        System.out.println(INPUT_AMOUNT_MESSAGE);
        String purchaseInput = Console.readLine();

        int purchaseAmount = Integer.parseInt(purchaseInput);
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        System.out.println(lottoCount + PURCHASE_MESSAGE);
    }

    public List<Integer> readWinningNumbers() {
        final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String winningInput = Console.readLine();
        validateWinningInput(winningInput);

        String[] winningInputSplit = winningInput.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningInputSplit) {
            validateEachNumber(number);
            winningNumbers.add(Integer.valueOf(number));
        }
        return winningNumbers;
    }

    public void validateWinningInput(String winningNumberInput) {
        final int INPUT_LENGTH = 6;
        final String INPUT_PATTERN = "[0-9]*,".repeat(INPUT_LENGTH - 1)+"[0-9]";
        if (!winningNumberInput.matches(INPUT_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 입력 형식에 맞게 숫자를 입력해주세요.");
        }
    }
    public void validateEachNumber(String number) {
        if (Integer.valueOf(number) > 45 || Integer.valueOf(number) < 1) {
            throw new IllegalArgumentException("[ERROR] 1~45 범위 내의 숫자를 입력해주세요.");
        }
    }
}
