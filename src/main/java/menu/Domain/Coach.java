package menu.Domain;

import java.util.List;

public class Coach {
    private String name;
    private Menu menu;

    private List<String> unfavorMenus;

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
}
