package subway;

public enum InputRegex {
    MAIN("^[1234Qq]$"),
    STATION_MANAGEMENT("^[123Bb]$"),
    LINE_MANAGEMENT("^[123Bb]$"),
    SECTION_MANAGEMENT("^[12Bb]$"),

    STATION_NAME("^.{2}*$"),
    ORDER_NAME("\\d*$");


    private String regex;
    InputRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
