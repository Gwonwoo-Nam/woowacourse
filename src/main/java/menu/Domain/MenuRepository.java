package menu.Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuRepository {
    private static List<Menu> menuList = new ArrayList<>();

    public static void addMenuList() {
        for (MenuList menus : MenuList.values()) {
            menuList.add(new Menu(menus.getCategory(), menus.getMenuList()));
        }

    }

    public static List<Menu> getMenuList() {
        return menuList;
    }
}
