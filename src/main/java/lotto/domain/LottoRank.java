package lotto.domain;

public enum LottoRank {
    FIRST(1,200000000), SECOND(2,30000000), THIRD(3,1500000), FOURTH(4,50000), FIFTH(5, 5000);
    private final int winningPrice;
    private final int rank;
    LottoRank(int rank, int winningPrice) {
        this.rank = rank;
        this.winningPrice = winningPrice;
    }
    public int rank() {
        return rank;
    }
    public int winningPrice() {
        return winningPrice;
    }
}