package lotto;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.LottoRank;

public class LottoPrinter {
    public void printLottoNumbers(List<Integer> lottoNumber) {
        System.out.println(lottoNumber);
    }

    public void printWinningResult(LottoRank[] lottoRank) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        for (LottoRank rank : lottoRank) {
            System.out.print(rank.getNormalCount()+"개 일치 ");
            String winningPriceFormatted = decimalFormat.format(rank.getWinningPrice());
            System.out.print("("+winningPriceFormatted+"원)");
            System.out.print(" - " + rank.getWinningCount() + "개");
            System.out.println();
        }
    }
}
