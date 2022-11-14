package lotto.domain;

public class ProfitManager {
    private int totalEarning = 0;

    public void sumEarning(LottoRank lottoRank) {
        if (lottoRank.getWinningCount() != 0)
            totalEarning += lottoRank.getWinningPrice() * lottoRank.getWinningCount();
    }

    public double calculate(int purchaseAmount) {
        double totalProfit;
        totalProfit = ((double)totalEarning / (double)purchaseAmount);
        return totalProfit;
    }
}
