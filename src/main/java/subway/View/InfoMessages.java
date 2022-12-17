package subway.View;

public enum InfoMessages {
    MAIN_MENU_SELECTION("## 메인 화면\n"
            + "1. 경로 조회\n"
            + "Q. 종료"),
    REQUEST_SELECT_OPTION("## 원하는 기능을 선택하세요."),
    PATH_MENU_SELECTION("## 경로 기준\n"
            + "1. 최단 거리\n"
            + "2. 최소 시간\n"
            + "B. 돌아가기"),
    REQUEST_POINT_FROM("## 출발역을 입력하세요."),
    REQUEST_POINT_TO("## 도착역을 입력하세요."),
    RESULT("## 조회 결과"),
    SEPERATOR("[INFO] ---"),
    INFO_DISTNACE("[INFO] 총 거리: "),
    INFO_TIME("[INFO] 총 소요 시간: "),
    INFO("[INFO] "),
    ERROR_SAME_POINTS("[ERROR] 출발역과 도착역이 동일합니다."),
    ERROR_ARGUMENT("[ERROR] 입력 값이 올바르지 않습니다.");

    private String message;

    InfoMessages(String message) {
        this.message = message;
    }

    public void println() {
        System.out.println(message);
    }

    public void print() {
        System.out.print(message);
    }

    public String getMessage() {
        return message;
    }
}
