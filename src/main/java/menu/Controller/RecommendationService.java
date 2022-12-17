package menu.Controller;

import menu.Domain.Coach;
import menu.Domain.CoachRepository;
import menu.Domain.Menu;
import menu.Domain.MenuRepository;
import menu.View.InfoMessages;
import menu.View.InputView;

import java.util.ArrayList;
import java.util.List;

public class RecommendationService {

    public static void run() {
        MenuRepository.addMenuList();

        readCoachList();
        readUnfavorMenuList();

        /*for(Menu menu : MenuRepository.getMenuList()) {
            System.out.println(menu.getCategory());
            System.out.println(menu.getMenus());
        }*/

    }

    private static void readCoachList() {
        List<String> coachNames = new ArrayList<>();
        InfoMessages.START.println();
        try {
            coachNames = InputView.readCoachNames();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readCoachList();
            return;
        }
        CoachRepository.addCoaches(coachNames);
    }

    private static void readUnfavorMenuList() {
        List<String> unfavorMenuList = new ArrayList<>();
        for (Coach coach : CoachRepository.getCoachList()) {
            System.out.print(coach.getName());
            InfoMessages.INPUT_EXCLUDE_MENUS.println();
            try {
                unfavorMenuList = InputView.readUnfavorMenuList();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                readUnfavorMenuList();
                return;
            }
            if (!unfavorMenuList.isEmpty()) {
                CoachRepository.addUnfavorMenuList(coach, unfavorMenuList);
            }
        }
    }
}
