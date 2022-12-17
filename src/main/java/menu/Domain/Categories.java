package menu.Domain;

import java.util.ArrayList;
import java.util.List;

public class Categories {
    private static List<String> categories = new ArrayList<>();

    public static void addCategory(String category) {
        categories.add(category);
    }

    public static List<String> getCategories() {
        return categories;
    }

}
