package racingcar;

public enum ErrorMessages {
    TRIAL_NUMBER_ERROR_MESSAGE("[ERROR] 시도 횟수는 양수 정수여야 한다."),
    //CAR_NAME_ERROR_MESSAGE("[ERROR] 쉼표로 구분된 차량을 입력해주세요."),
    CAR_NAME_LENGTH_ERROR_MESSAGE("[ERROR] 차량 이름은 1자 이상 5자 이하만 가능합니다."),
    CAR_NAME_SIZE_ERROR_MESSAGE("[ERROR] 차량 이름은 2개 이상 입력해주세요."),
    CAR_NAME_REPETITION_ERROR_MESSAGE("[ERROR] 차량 이름 간 중복이 없어야 합니다.");
    private final String MESSAGE;

    ErrorMessages(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String print() {
        return MESSAGE;

    }
}
