package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.lang.IllegalArgumentException;

public class LottoManager {
    private List<Integer> winningNumbers = new ArrayList<>();
    private int lottoCount = 0;
    private int purchaseAmount = 0;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void readPurchaseAmount() {
        final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
        final String PURCHASE_MESSAGE = "개를 구매했습니다.";
        final int LOTTO_PRICE = 1000;
        System.out.println(INPUT_AMOUNT_MESSAGE);
        String purchaseInput = Console.readLine();
        System.out.println();
        validatePurchaseAmount(purchaseInput);

        purchaseAmount = Integer.parseInt(purchaseInput);
        lottoCount = purchaseAmount / LOTTO_PRICE;
        System.out.println(lottoCount + PURCHASE_MESSAGE);
    }

    public void validatePurchaseAmount(String purchaseInput) {
        final String INPUT_PATTERN = "[0-9]*";
        if (!purchaseInput.matches(INPUT_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 구매 금액에 숫자만 입력해주세요.");
        }
    }

    public void readWinningNumbers() {
        final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
        final int WINNING_INPUT_LENGTH = 6;
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String winningInput = Console.readLine();
        validateInputPattern(winningInput, WINNING_INPUT_LENGTH);

        String[] winningInputSplit = winningInput.split(",");
        for (String number : winningInputSplit) {
            validateEachNumber(number);
            validateRepetition(winningNumbers, Integer.valueOf(number));
            winningNumbers.add(Integer.valueOf(number));
        }
    }

    public void validateRepetition(List<Integer> winningNumbers, Integer number) {
        if (winningNumbers.contains(number))
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 번호를 입력해주세요.");
    }

    public void readBonusNumber() {
        final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
        final int BONUS_INPUT_LENGTH = 1;
        Integer bonusNumber;
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusInput = Console.readLine();
        validateInputPattern(bonusInput, BONUS_INPUT_LENGTH);
        validateEachNumber(bonusInput);
        bonusNumber = Integer.valueOf(bonusInput);
        validateRepetition(winningNumbers, bonusNumber);
        winningNumbers.add(bonusNumber);
    }

    public void validateInputPattern(String Input, int inputLength) {
        final String INPUT_PATTERN = "[0-9]*,".repeat(inputLength - 1) + "[0-9]*";
        if (!Input.matches(INPUT_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 입력 형식에 맞게 숫자를 입력해주세요.");
        }
    }

    public void validateEachNumber(String number) {
        if (Integer.valueOf(number) > 45 || Integer.valueOf(number) < 1) {
            throw new IllegalArgumentException("[ERROR] 1~45 범위 내의 숫자를 입력해주세요.");
        }
    }
}
