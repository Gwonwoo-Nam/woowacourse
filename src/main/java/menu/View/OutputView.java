package menu.View;

import menu.Domain.Categories;

public class OutputView {

    public static void printCategories() {
        InfoMessages.WEEKEND.println();
        InfoMessages.CATEGORIES_START.print();
        System.out.print(String.join(" | ",Categories.getCategories()));
        InfoMessages.CATEGORIES_END.println();
    }
}
