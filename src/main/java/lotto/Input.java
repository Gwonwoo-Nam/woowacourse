package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
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


}
