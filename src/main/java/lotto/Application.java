package lotto;

import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String ReadpurchaseAmount = Console.readLine();
        int purchaseAmount = Integer.parseInt(ReadpurchaseAmount);

        final int LOTTO_PRICE = 1000;
        int lottoCount = purchaseAmount / LOTTO_PRICE;

        System.out.printf("%d개를 구매했습니다.", lottoCount);

        // TODO: 프로그램 구현
    }
}
