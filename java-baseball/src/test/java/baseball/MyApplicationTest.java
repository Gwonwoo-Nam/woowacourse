package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)

class MyApplicationTest extends NsTest {

    @Test
    void 게임_종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void Simple_Test1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "145", "798", "154", "2");
                    assertThat(output()).contains("1스트라이크", "2볼 1스트라이크", "낫싱", "3스트라이크", "게임 종료");
                },
                1, 5, 4
        );
    }
    @Test
    void Simple_Test2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "789", "135", "123", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Nested
    class Exception_Test {
        @Test
        void only_number() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("12A"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
        @Test
        void has_same_number() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("121"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void more_than_3_digits() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Please Enter 3 digits.")
            );
        }

        @Test
        void enter_space() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(" "))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
