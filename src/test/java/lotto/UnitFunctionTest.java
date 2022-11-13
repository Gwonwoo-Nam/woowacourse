package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UnitFunctionTest {
    @DisplayName("로또 구입 금액을 입력 받는다.")
    @Test
    void readPurchaseAmountTest() {
        assertSimpleTest(
                () -> {
                    Input input = new Input();
                    System.setIn(new ByteArrayInputStream("8000".getBytes()));
                    OutputStream out = new ByteArrayOutputStream();
                    System.setOut(new PrintStream(out));
                    input.readPurchaseAmount();

                    assertThat(out.toString()).contains(
                            "8개를 구매했습니다."
                    );
                }
        );
    }

    @DisplayName("당첨 번호를 입력 받는다.")
    @Test
    void readWinningNumbersTest() {
        assertSimpleTest(
                () -> {
                    String actualInput = "1,2,3,4,5,6";
                    Input input = new Input();
                    System.setIn(new ByteArrayInputStream(actualInput.getBytes()));
                    input.readWinningNumbers();
                    assertThat(input.getWinningNumbers())
                            .containsExactly(1, 2, 3, 4, 5, 6
                            );
                }
        );
    }

    @DisplayName("보너스 번호를 입력 받는다.")
    @Test
    void readBonusNumbersTest() {
        assertSimpleTest(
                () -> {
                    String actualInput = "42";
                    final int BONUS_INDEX = 6;
                    Input input = new Input();
                    System.setIn(new ByteArrayInputStream(actualInput.getBytes()));
                    input.readBonusNumber();

                    assertThat(input.getWinningNumbers())
                            .contains(42
                            );
                }
        );
    }

    @DisplayName("로또 구입 금액의 입력 pattern을 검증한다.")
    @Test
    void validatePurchaseInputTest() {
        String purchaseInput = "72,000";
        Input input = new Input();
        assertThatThrownBy(() -> input.validatePurchaseAmount(purchaseInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 당첨 번호의 입력 pattern을 검증한다.")
    @Test
    void validateWinningInputTest() {
        String winningInput = "1,2,3,4,5,6,";
        final int WINNING_INPUT_LENGTH = 6;
        Input input = new Input();
        assertThatThrownBy(() -> input.validateInputPattern(winningInput, WINNING_INPUT_LENGTH))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 당첨 번호의 숫자 범위를 검증한다.")
    @Test
    void validateEachNumberTest() {
        String winningNumber = "46";
        Input input = new Input();
        assertThatThrownBy(() -> input.validateEachNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    @DisplayName("당첨 번호 배열과 중복되는 번호인지 검증한다.")
    @Test
    void validateRepetitionTest() {
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        final int SAME_NUMBER = 6;
        Input input = new Input();
        assertThatThrownBy(() -> input.validateRepetition(winningNumbers, SAME_NUMBER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 당첨 번호의 입력 pattern을 검증한다.")
    @Test
    void validateBonusInputTest() {
        String winningInput = "7,";
        final int WINNING_BONUS_LENGTH = 1;
        Input input = new Input();
        assertThatThrownBy(() -> input.validateInputPattern(winningInput, WINNING_BONUS_LENGTH))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}