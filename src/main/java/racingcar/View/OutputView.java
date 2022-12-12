package racingcar.View;

public class OutputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIAL_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String CAR_POSITION_COUNT = "-";
    private static final String RESULT_MESSAGE = "실행 결과";
    public void askCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }
    public void askTrialNumber() {
        System.out.println(INPUT_TRIAL_NUMBER_MESSAGE);
    }
    public void printResult(String name, int position) {
        printCarName(name);
        printPosition(position);
        System.out.println();
    }
    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }


    private void printCarName(String name) {
        System.out.print(name + " : ");
    }

    private void printPosition(int position) {
        for (int number = 0; number < position; number++) {
            System.out.print(CAR_POSITION_COUNT);
        }
    }

}
