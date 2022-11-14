package lotto.domain;

public enum LottoRank {
    FIRST(6,200000000), SECOND(5,30000000), THIRD(5,1500000), FOURTH(4,50000), FIFTH(3, 5000);
    private final int winningPrice;
    private final int matchNormalCount;
    private int winningCount = 0;
    LottoRank(int matchNormalCount, int winningPrice) {
        this.matchNormalCount = matchNormalCount;
        this.winningPrice = winningPrice;
    }

    public void findMatchingRank(int normalCount) {
        if (normalCount == this.matchNormalCount) {
            this.winningCount++;
        }
    }

    public boolean checkSecondPlace(int normalCount, int bonusCount) {
        if (this == SECOND && bonusCount == 1 && normalCount == this.matchNormalCount) {
            this.winningCount++;
            return true;
        }
        return false;
    }
    public int getWinningCount() {
        return winningCount;
    }
    public int getNormalCount() {
        return matchNormalCount;
    }
    public int getWinningPrice() {
        return winningPrice;
    }
}