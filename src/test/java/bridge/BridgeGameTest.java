package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import org.junit.jupiter.api.DisplayName;
import bridge.controller.BridgeGame;
import bridge.controller.BridgeMaker;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

@DisplayName("BridgeGame 클래스")
@Nested
public class BridgeGameTest {

    @DisplayName("move 메소드는")
    @Nested
    class Describe_move {

        @DisplayName("bridge 배열과 User 입력을 비교하여")
        @Nested
        class Context_with_bridge {

            @DisplayName("정답 여부를 리턴하며 유저 입력 배열을 업데이트한다.")
            @Test
            void moveTest() {
                BridgeGame bridgeGame = new BridgeGame(List.of("UDUDD"));
                boolean checkMove;
                checkMove = bridgeGame.move(0, "U");
                assertThat(checkMove).isEqualTo(true);
            }
        }

    }
}


