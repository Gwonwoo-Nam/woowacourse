package pairmatching.view;

public enum InputRegex {
    FEATURE_REGEX("^[123Q]$");


    private final String message;
    InputRegex(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
