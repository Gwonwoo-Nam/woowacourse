package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

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
                    Input input = new Input();
                    System.setIn(new ByteArrayInputStream("1,2,3,4,5,6".getBytes()));

                    assertThat(input.readWinningNumbers())
                            .containsExactly(1,2,3,4,5,6
                    );
                }
        );
    }
}