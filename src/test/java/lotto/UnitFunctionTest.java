package lotto;

import lotto.domain.LottoNumberGenerator;
import lotto.domain.WinningCounter;
import lotto.UI.LottoManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UnitFunctionTest {
    @DisplayName("로또 구입 금액을 입력 받는다.")
    @Test
    void readPurchaseAmountTest() {
        assertSimpleTest(
                () -> {
                    LottoManager lottoManager = new LottoManager();
                    System.setIn(new ByteArrayInputStream("8000".getBytes()));
                    OutputStream out = new ByteArrayOutputStream();
                    System.setOut(new PrintStream(out));
                    lottoManager.readPurchaseAmount();

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
                    LottoManager lottoManager = new LottoManager();
                    System.setIn(new ByteArrayInputStream(actualInput.getBytes()));
                    lottoManager.readWinningNumbers();
                    assertThat(lottoManager.getWinningNumbers())
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
                    LottoManager lottoManager = new LottoManager();
                    System.setIn(new ByteArrayInputStream(actualInput.getBytes()));
                    lottoManager.readBonusNumber();

                    assertThat(lottoManager.getWinningNumbers())
                            .contains(42
                            );
                }
        );
    }

    @DisplayName("구매 로또 번호를 오름차순으로 정렬한다.")
    @Test
    void sortAscendingTest() {
        assertSimpleTest(() -> {
                    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
                    assertThat(lottoNumberGenerator.sortAscending(Arrays.asList(3, 2, 1, 5, 6, 4)))
                            .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6)
                            );
                }
        );
    }

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

    @Nested
    @DisplayName("예외 사항")
    class ExceptionCaseTest {
        @DisplayName("로또 구입 금액의 입력 pattern을 검증한다.")
        @Test
        void validatePurchaseInputTest() {
            LottoManager lottoManager = new LottoManager();
            System.setIn(new ByteArrayInputStream("72,000".getBytes()));
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            assertThatThrownBy(() -> lottoManager.readPurchaseAmount())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }

        @DisplayName("로또 구입 금액이 1000원 단위인지 확인한다.")
        @Test
        void validatePurchaseUnitTest() {
            LottoManager lottoManager = new LottoManager();
            System.setIn(new ByteArrayInputStream("72321".getBytes()));
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            assertThatThrownBy(() -> lottoManager.readPurchaseAmount())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }


        @DisplayName("로또 당첨 번호의 입력 pattern을 검증한다.")
        @Test
        void validateWinningInputTest() {
            LottoManager lottoManager = new LottoManager();
            System.setIn(new ByteArrayInputStream("1,2,3,4,5,6,".getBytes()));
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            assertThatThrownBy(() -> lottoManager.readWinningNumbers())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }

        @DisplayName("로또 당첨 번호의 숫자 범위를 검증한다.")
        @Test
        void validateEachNumberTest() {
            LottoManager lottoManager = new LottoManager();
            System.setIn(new ByteArrayInputStream("46,2,3,4,5,6".getBytes()));
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            assertThatThrownBy(() -> lottoManager.readWinningNumbers())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }

        @DisplayName("당첨 번호 배열과 중복되는 번호인지 검증한다.")
        @Test
        void validateRepetitionTest() {
            LottoManager lottoManager = new LottoManager();
            System.setIn(new ByteArrayInputStream("1,2,1,4,5,6".getBytes()));
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            assertThatThrownBy(() -> lottoManager.readWinningNumbers())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }
}

