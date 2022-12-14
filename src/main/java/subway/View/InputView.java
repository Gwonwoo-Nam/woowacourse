package subway.View;

import java.util.Scanner;
import subway.InfoMessages;
import subway.InputRegex;
import subway.RequestMessages;

public class InputView {

    public String readFeature() {
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            RequestMessages.FEATURE.println();
            String userSelection = scanner.nextLine();
            try {
                validate(userSelection, InputRegex.MAIN.getRegex());
                return userSelection;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void validate(String userSelection, String regex) {
        if (userSelection.matches(regex) == false) {
            throw new IllegalArgumentException(InfoMessages.ERROR_FEATURE.getMessage());
        }
    }

}
