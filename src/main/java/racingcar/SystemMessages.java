package racingcar;

public enum SystemMessages {

    INPUT_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRIAL_NUMBER_MESSAGE("시도할 횟수는 몇 회인가요?"),
    CAR_POSITION_COUNT("-"),
    RESULT_MESSAGE("실행 결과");

    private final String MESSAGE;

    SystemMessages(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String print() {
        return MESSAGE;
    }

}
