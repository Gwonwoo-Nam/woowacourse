package racingcar;

public enum Regex {

    INPUT_TRIAL_NUMBER_REGEX("^[1-9][0-9]*$"),
    INPUT_CAR_NAME_LENGTH_REGEX("^([^,]){1,5}$");

    private final String REGEX;

    Regex(String REGEX) {
        this.REGEX = REGEX;
    }

    public String print() {
        return REGEX;
    }

}
