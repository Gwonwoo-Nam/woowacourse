package menu.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.Domain.Categories;
import menu.Domain.Category;
import menu.Domain.Coach;
import menu.Domain.CoachRepository;
import menu.Domain.MenuRepository;
import menu.View.OutputView;

public class RecommendationController {
    public static void run() {
        recommendCategory();
        for (String category : Categories.getCategories()) { //요일
            recommendMenu(category);
        }
    }

    public static void recommendCategory() {
        for (int i = 0; i<5 ; i++) {
            String category = Category.get(Randoms.pickNumberInRange(1,5));
            Categories.addCategory(category);
            //카테고리 예외처리
        }
        OutputView.printCategories();
    }

    public static void recommendMenu(String category) {
        for (Coach coach : CoachRepository.getCoachList()) {//코치 반복
            String randomMenu = Randoms.shuffle(MenuRepository.getMenuListByCategory(category)).get(0);
            coach.addMenu(randomMenu);
        }
    }
}
