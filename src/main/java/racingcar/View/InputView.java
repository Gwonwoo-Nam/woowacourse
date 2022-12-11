package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> readCarName() {
        String input = Console.readLine();
        validate(input);

        List<String> carNameList = new ArrayList<>(Arrays.asList(input.split(",")));

        return carNameList;
    }

    private void validate(String input) {

    }

}
