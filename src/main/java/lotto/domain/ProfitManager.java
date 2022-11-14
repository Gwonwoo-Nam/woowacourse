package lotto.domain;

public class ProfitManager {
    private int totalEarning = 0;

    public void sumEarning(LottoRank lottorank) {
        if (lottorank.getWinningCount() != 0)
            totalEarning += lottorank.getWinningPrice() * lottorank.getWinningCount();
    }

    public double calculate(int purchaseAmount) {
        double totalProfit;
        totalProfit = ((double)totalEarning / (double)purchaseAmount);
        return totalProfit;
    }
}
