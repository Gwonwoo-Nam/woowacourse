package bridge;

import bridge.model.BridgeMaker;

import org.assertj.core.api.SoftAssertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayName("BridgeMaker 클래스")
@Nested
public class BridgeMakerTest {

    SoftAssertions softAssertions = new SoftAssertions();

    @DisplayName("make 메소드는")
    @Nested
    class Describe_make {

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        @DisplayName("생성할 다리의 길이를 입력 받아 임의의 다리 배열을 리턴한다.")
        @ValueSource(doubles = {0.7, 0.5, 0.2})
        @ParameterizedTest
        void createShapeTest() {
            softAssertions.assertThat(bridgeMaker.createShape(0.7)).as("다리 생성 확인")
                    .isEqualTo("U", "U", "D");
            softAssertions.assertAll();
        }
    }
}