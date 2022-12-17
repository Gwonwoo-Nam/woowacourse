package subway.View;

public enum Regex {

    MAIN_MENU("^[1Q]$"),
    PATH_MENU("^[12B]$");

    private String message;

    Regex(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
