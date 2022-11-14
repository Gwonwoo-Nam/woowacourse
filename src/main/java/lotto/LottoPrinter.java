package lotto;

import java.util.List;
import lotto.domain.LottoRank;

public class LottoPrinter {
    public void printLottoNumbers(List<Integer> lottoNumber) {
        System.out.println(lottoNumber);
    }

    public void printWinningResult(LottoRank[] lottoRank) {
        for (LottoRank rank : lottoRank) {
            System.out.print(rank.getNormalCount()+"개 일치 ");
            System.out.print("("+rank.getWinningPrice()+")");
            System.out.print(" - " + rank.getWinningCount() + "개");
            System.out.println();
        }
    }
}
