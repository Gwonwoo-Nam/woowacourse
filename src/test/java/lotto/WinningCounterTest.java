package lotto;

import lotto.domain.WinningCounter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningCounterTest {
    @DisplayName("구매 로또 번호가 당첨 번호에서 겹치는 횟수를 카운트한다.")
    @Test
    void countNormalWinningTest() {
        assertSimpleTest(() -> {
                    List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 5, 7, 6);
                    List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
                    WinningCounter winningCounter = new WinningCounter();
                    assertThat(winningCounter.countWinningNormal(lottoNumbers, winningNumbers))
                            .isEqualTo(5
                            );
                }
        );
    }

    @DisplayName("구매 로또 번호가 보너스 번호와 겹치는 횟수를 카운트한다.")
    @Test
    void countBonusWinningTest() {
        assertSimpleTest(() -> {
                    List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 5, 7, 6);
                    List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
                    WinningCounter winningCounter = new WinningCounter();
                    assertThat(winningCounter.countWinningBonus(lottoNumbers, winningNumbers))
                            .isEqualTo(1
                            );
                }
        );
    }
}
