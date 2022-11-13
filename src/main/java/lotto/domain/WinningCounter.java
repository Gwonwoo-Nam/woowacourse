package lotto.domain;

import java.util.List;

public class WinningCounter {
    private int normal_count = 0;
    private int bonus_count = 0;

    public void countWinning(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        for (Integer number : lottoNumbers) {
            if (winningNumbers.subList(0,6).contains(number)) {
                normal_count++;
            }
            if (winningNumbers.get(6).equals(number)) {
                bonus_count++;
            }
        }
    }

    public int getBonus_count() {
        return bonus_count;
    }

    public int getNormal_count() {
        return normal_count;
    }
}
