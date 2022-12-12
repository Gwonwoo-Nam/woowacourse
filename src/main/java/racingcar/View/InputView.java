package racingcar.View;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.SystemMessages;

public class InputView {



    public static String readCarsName() {
        OutputView.askCarName();
        return Console.readLine();
    }

    public static String readTrialNumber() {
        OutputView.askTrialNumber();

        return Console.readLine();
    }



}
