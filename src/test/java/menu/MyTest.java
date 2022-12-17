package menu;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import menu.Domain.Coach;

public class MyTest {
    @DisplayName("Coach 클래스 기능 Test")
    @Nested
    class CoachTest {
        @DisplayName("Coach 메뉴 추가 테스트")
        @Test
        void addMenuTest() {
            Coach coach = new Coach("test");
            String unfavoredMenu = "우동";
            coach.addMenu(unfavoredMenu);
            assertThat(coach.getMenus().get(0)).isEqualTo("우동");
        }

    }
}
