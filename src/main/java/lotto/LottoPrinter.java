package lotto;

import java.text.DecimalFormat;
import java.util.List;

import lotto.domain.LottoRank;

public class LottoPrinter {
    public static final String UNVALID_PURCHASE_AMOUNT_ERROR = "[ERROR] 구매 금액은 1,000원 단위로 입력해주세요.";
    public static final String UNVALID_PURCHASE_PATTERN_ERROR = "[ERROR] 구매 금액에 숫자만 입력해주세요.";
    public static final String WINNING_NUMBERS_REPETITION_ERROR = "[ERROR] 중복되지 않는 번호를 입력해주세요.";
    public static final String WINNING_NUMBERS_PATTERN_ERROR = "[ERROR] 입력 형식에 맞게 숫자를 입력해주세요.";
    public static final String WINNING_NUMBER_RANGE_ERROR = "[ERROR] 1~45 범위 내의 숫자를 입력해주세요.";

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

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        throw new IllegalArgumentException(errorMessage);
    }

}
