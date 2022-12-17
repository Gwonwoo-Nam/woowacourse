package menu.Domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> menus = new ArrayList<>();

    private List<String> unfavorMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addUnfavorMenus(List<String> menuList) {
        for (String menu : menuList) {
            unfavorMenus.add(menu);
        }
    }

    public void addMenu(String menu) {
        menus.add(menu);
    }

    public List<String> getMenus() {
        return menus;
    }
}
