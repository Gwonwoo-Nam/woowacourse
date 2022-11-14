package lotto.UI;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.lang.IllegalArgumentException;

public class LottoManager {
    private List<Integer> winningNumbers = new ArrayList<>();
    private int lottoCount = 0;
    private int purchaseAmount = 0;

    private LottoPrinter lottoPrinter = new LottoPrinter();

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
        final int LOTTO_PRICE = 1000;

        lottoPrinter.printPurchaseAmountMessage();
        String purchaseInput = Console.readLine();
        System.out.println();
        validatePurchasePattern(purchaseInput);
        purchaseAmount = Integer.parseInt(purchaseInput);
        validatePurchaseUnit(LOTTO_PRICE);
        lottoCount = purchaseAmount / LOTTO_PRICE;
        lottoPrinter.printPurchaseCompletionMessage(lottoCount);
    }

    public void readWinningNumbers() {
        final int WINNING_INPUT_LENGTH = 6;
        lottoPrinter.printGetWinningNumberMessage();
        String winningInput = Console.readLine();
        validateInputPattern(winningInput, WINNING_INPUT_LENGTH);
        String[] winningInputSplit = winningInput.split(",");
        for (String number : winningInputSplit) {
            validateNumberRange(number);
            validateRepetition(winningNumbers, Integer.valueOf(number));
            winningNumbers.add(Integer.valueOf(number));
        }
    }


    public void readBonusNumber() {
        final int BONUS_INPUT_LENGTH = 1;
        Integer bonusNumber;
        lottoPrinter.printBonusNumberMessage();
        String bonusInput = Console.readLine();
        validateInputPattern(bonusInput, BONUS_INPUT_LENGTH);
        validateNumberRange(bonusInput);
        bonusNumber = Integer.valueOf(bonusInput);
        validateRepetition(winningNumbers, bonusNumber);
        winningNumbers.add(bonusNumber);
    }

    private void validatePurchaseUnit(int LOTTO_PRICE) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(lottoPrinter.INVALID_PURCHASE_AMOUNT_ERROR);
        }
    }

    private void validatePurchasePattern(String purchaseInput) {
        final String INPUT_PATTERN = "[0-9]*";
        if (!purchaseInput.matches(INPUT_PATTERN)) {
            throw new IllegalArgumentException(lottoPrinter.INVALID_PURCHASE_PATTERN_ERROR);
        }
    }

    private void validateRepetition(List<Integer> winningNumbers, Integer number) {
        if (winningNumbers.contains(number))
            throw new IllegalArgumentException(lottoPrinter.WINNING_NUMBERS_REPETITION_ERROR);
    }


    private void validateInputPattern(String Input, int inputLength) {
        final String INPUT_PATTERN = "[0-9]*,".repeat(inputLength - 1) + "[0-9]*";
        if (!Input.matches(INPUT_PATTERN)) {
            throw new IllegalArgumentException(lottoPrinter.WINNING_NUMBERS_PATTERN_ERROR);
        }
    }

    private void validateNumberRange(String number) {
        if (Integer.valueOf(number) > 45 || Integer.valueOf(number) < 1) {
            throw new IllegalArgumentException(lottoPrinter.WINNING_NUMBER_RANGE_ERROR);
        }
    }
}
