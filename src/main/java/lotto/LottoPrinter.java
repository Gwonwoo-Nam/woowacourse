package lotto;

import java.text.DecimalFormat;
import java.util.List;

import lotto.domain.LottoRank;

public class LottoPrinter {
    public final String UNVALID_PURCHASE_AMOUNT_ERROR = "[ERROR] 구매 금액은 1,000원 단위로 입력해주세요.";
    public final String UNVALID_PURCHASE_PATTERN_ERROR = "[ERROR] 구매 금액에 숫자만 입력해주세요.";
    public final String WINNING_NUMBERS_REPETITION_ERROR = "[ERROR] 중복되지 않는 번호를 입력해주세요.";
    public final String WINNING_NUMBERS_PATTERN_ERROR = "[ERROR] 입력 형식에 맞게 숫자를 입력해주세요.";
    public final String WINNING_NUMBER_RANGE_ERROR = "[ERROR] 1~45 범위 내의 숫자를 입력해주세요.";

    public void printLottoNumbers(List<Integer> lottoNumber) {
        System.out.println(lottoNumber);
    }

    public void printWinningResult(LottoRank lottoRank) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");

        System.out.print(lottoRank.getNormalCount() + "개 일치");
        if (lottoRank.name() == "SECOND") {
            System.out.print(", 보너스 볼 일치");
        }
        String winningPriceFormatted = decimalFormat.format(lottoRank.getWinningPrice());
        System.out.print(" (" + winningPriceFormatted + "원)");
        System.out.print(" - " + lottoRank.getWinningCount() + "개");
        System.out.println();
    }

    public void printProfit(double totalProfit) {
        double totalProfitPercent = totalProfit * 100;
        System.out.print("총 수익률은 ");
        System.out.print(String.format("%.1f", totalProfitPercent));
        System.out.print("%입니다.");
    }

    public void printBonusNumberMessage() {
        final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printPurchaseAmountMessage() {
        final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
        System.out.println(INPUT_AMOUNT_MESSAGE);
    }
    public void printPurchaseCompletionMessage(int lottoCount) {
        final String PURCHASE_MESSAGE = "개를 구매했습니다.";
        System.out.println(lottoCount + PURCHASE_MESSAGE);
    }
    public void printGetWinningNumberMessage() {
        final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
    }

}
