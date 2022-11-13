package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

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
        String winningNumbersInput = Console.readLine();
        String[] winningNumbersSplit = winningNumbersInput.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningNumbersSplit) {
            winningNumbers.add(Integer.valueOf(number));
        }
        return winningNumbers;
    }
}
