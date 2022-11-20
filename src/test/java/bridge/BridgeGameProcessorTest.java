package bridge;

import bridge.controller.BridgeGameController;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("BridgeGameController 클래스")
@Nested
class BridgeGameProcessorTest {

    @DisplayName("decideBridgeLength 메소드는")
    @Nested
    class Describe_decideBridgeLength {
        @DisplayName("다리의 길이를 입력받는다.")
        @Test
        void decideBridgeLengthTest () {
            SoftAssertions softAssertions = new SoftAssertions();

            BridgeGameController bridgeGameController = new BridgeGameController();
            System.setIn(new ByteArrayInputStream("7".getBytes()));

            softAssertions.assertThat(bridgeGameController.decideBridgeLength()).isEqualTo(7);
            softAssertions.assertAll();
        }
    }
}
