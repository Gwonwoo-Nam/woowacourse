package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class runMainTest extends NsTest {

    @Test
    void 기능_실패_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "[ O | X ]",
                    "[   |   ]",
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Test
    void 기능_종료_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "Q");
            assertThat(output()).contains(
                    "[ O | X ]",
                    "[   |   ]",
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
