package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.view.InputView;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayName("InputView 클래스")
@Nested
class InputViewTest {
    InputView inputView = new InputView();
    @DisplayName("readBridgeSize 메소드는")
    @Nested
    class Describe_readBridgeSize {
        @DisplayName("입력받은 Input이 적절한 경우")
        @Nested
        class Context_with_correctInput {

            @DisplayName("bridge의 크기를 입력받아 저장한다.")
            @CsvSource(value = {"3,3", "7,7", "10,10", "19,19", "20,20"})
            @ParameterizedTest
            void readBridgeSizeTest(String input, String expected) {

                System.setIn(new ByteArrayInputStream(input.getBytes()));
                assertThat(inputView.readBridgeSize()).as("입력 확인")
                        .isEqualTo(Integer.parseInt(expected));
            }
        }
        @DisplayName("입력받은 Input이 적절한 범위가 아닌 경우")
        @Nested
        class Context_with_wrongInput {

            @DisplayName("예외처리한다.")
            @ValueSource(strings = {"0", " ", "-3", "21", "3a"})
            @ParameterizedTest
            void readBridgeSizeErrorTest(String input) {
                System.setIn(new ByteArrayInputStream(input.getBytes()));
                assertThatThrownBy(() -> inputView.readBridgeSize()).as("입력 확인")
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]");
            }
        }
    }

    @DisplayName("readMoving 메소드는")
    @Nested
    class Describe_readMoving {

        @DisplayName("입력받은 Input이 U,D인 경우")
        @Nested
        class Context_with_correctInput {

            @DisplayName("읽은 값을 반환한다.")
            @CsvSource(value = {"U,U", "D,D"})
            @ParameterizedTest
            void readMovingTest(String input, String expected) {
                System.setIn(new ByteArrayInputStream(input.getBytes()));
                assertThat(inputView.readMoving()).as("입력 확인")
                        .isEqualTo(expected);
            }
        }

        @DisplayName("입력받은 Input이 적절한 범위가 아닌 경우")
        @Nested
        class Context_with_wrongInput {

            @DisplayName("예외처리한다.")
            @ValueSource(strings = {"0", " ", "u", "d", "UD", "UU"})
            @ParameterizedTest
            void readMovingErrorTest(String input) {
                System.setIn(new ByteArrayInputStream(input.getBytes()));
                assertThatThrownBy(() -> inputView.readMoving()).as("입력 확인")
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]");
            }
        }
    }

    @DisplayName("readGameCommand 메소드는")
    @Nested
    class Describe_readGameCommand {

        @DisplayName("입력받은 Input이 R,Q인 경우")
        @Nested
        class Context_with_correctInput {

            @DisplayName("입력 값을 반환한다.")
            @CsvSource(value = {"R,R", "Q,Q"})
            @ParameterizedTest
            void readGameCommandTest(String input, String expected) {
                System.setIn(new ByteArrayInputStream(input.getBytes()));
                assertThat(inputView.readGameCommand()).as("입력 확인")
                        .isEqualTo(expected);
            }
        }

        @DisplayName("입력받은 Input이 적절한 범위가 아닌 경우")
        @Nested
        class Context_with_wrongInput {

            @DisplayName("예외처리한다.")
            @ValueSource(strings = {"Q ", " R", "r", "q", "RQ", "U"})
            @ParameterizedTest
            void readGameCommandErrorTest(String input) {
                System.setIn(new ByteArrayInputStream(input.getBytes()));
                assertThatThrownBy(() -> inputView.readGameCommand()).as("입력 확인")
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]");
            }
        }
    }
}