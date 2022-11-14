package lotto;

import java.text.DecimalFormat;
import java.util.List;

import lotto.domain.LottoRank;

public class LottoPrinter {
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
}
