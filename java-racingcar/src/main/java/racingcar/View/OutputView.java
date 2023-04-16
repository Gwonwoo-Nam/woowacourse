package racingcar.View;

import racingcar.SystemMessages;

public class OutputView {

    public static void askCarName() {
        System.out.println(SystemMessages.INPUT_CAR_NAME_MESSAGE.print());
    }
    public static void askTrialNumber() {
        System.out.println(SystemMessages.INPUT_TRIAL_NUMBER_MESSAGE.print());
    }
    public static void printResult(String name, int position) {
        printCarName(name);
        printPosition(position);
        System.out.println();
    }
    public static void printResultMessage() {
        System.out.println(SystemMessages.RESULT_MESSAGE.print());
    }


    private static void printCarName(String name) {
        System.out.print(name + " : ");
    }

    private static void printPosition(int position) {
        for (int number = 0; number < position; number++) {
            System.out.print(SystemMessages.CAR_POSITION_COUNT.print());
        }
    }

    public static void printWinner(String winners) {
        System.out.println(SystemMessages.WINNER_MESSAGE.print() + winners);
    }

}
