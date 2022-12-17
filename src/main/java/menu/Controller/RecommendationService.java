package menu.Controller;

import menu.Domain.Menu;
import menu.Domain.MenuRepository;

public class RecommendationService {

    public static void run() {
        MenuRepository.addMenuList();
        for(Menu menu : MenuRepository.getMenuList()) {
            System.out.println(menu.getCategory());
            System.out.println(menu.getMenus());
        }

    }
}
