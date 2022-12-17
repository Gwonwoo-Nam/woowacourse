package menu.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.Domain.Categories;
import menu.Domain.Category;
import menu.Domain.Coach;
import menu.Domain.CoachRepository;
import menu.Domain.MenuRepository;

public class RecommendationController {
    public static void run() {
        runCategoryRecommendation();
        runMenuRecommendation();
    }

    private static void runCategoryRecommendation() {
        for (int i = 0; i < 5; i++) {
            String category = Category.get(Randoms.pickNumberInRange(1, 5));
            Categories.addCategory(category);
        }
        if (!Categories.validateCategory()) {
            Categories.clear();
            runCategoryRecommendation();
        }
    }

    private static void runMenuRecommendation() {
        for (String category : Categories.getCategories()) { //요일
            recommendMenu(category);
        }
        if (!validateMenus()) {
            runMenuRecommendation();
        }
    }

    private static void recommendMenu(String category) {
        for (Coach coach : CoachRepository.getCoachList()) {//코치 반복
            String randomMenu = Randoms.shuffle(MenuRepository.getMenuListByCategory(category)).get(0);
            coach.addMenu(randomMenu);
        }
    }

    private static boolean validateMenus() {
        for (Coach coach : CoachRepository.getCoachList()) {//코치 반복
            if (coach.hasUnfavoredMenu() || coach.hasSameMenu()) {
                //System.out.println("싫어하는것 포함");
                return false;
            }
        }
        return true;
    }
}
