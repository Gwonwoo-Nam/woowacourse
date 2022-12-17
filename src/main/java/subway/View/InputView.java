package subway.View;


import java.util.Scanner;


import subway.domain.Station;
import subway.domain.StationRepository;

public class InputView {
    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    private Scanner scanner;

    public String readMenu(String infoMessage, String regex) {
        System.out.println(infoMessage);
        InfoMessages.REQUEST_SELECT_OPTION.println();
        String inputMenu = scanner.nextLine();
        try {
            validate(inputMenu, regex);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readMenu(infoMessage, regex);
            return null;
        }
        return inputMenu;
    }
    public void validate(String input, String regex) {
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(InfoMessages.ERROR_ARGUMENT.getMessage());
        }
    }

    public String readStation(String infoMessage) {
        System.out.println(infoMessage);
        String input = scanner.nextLine();
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(input)) {
                return input;
            }
        }
        throw new IllegalArgumentException(InfoMessages.ERROR_ARGUMENT.getMessage());
    }

}
