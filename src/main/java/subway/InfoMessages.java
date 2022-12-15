package subway;

public enum InfoMessages {
    MAIN("## 메인 화면\n"
        + "1. 역 관리\n"
        + "2. 노선 관리\n"
        + "3. 구간 관리\n"
        + "4. 지하철 노선도 출력\n"
        + "Q. 종료\n"),
    STATION_MANAGEMENT("## 역 관리 화면\n"
        + "1. 역 등록\n"
        + "2. 역 삭제\n"
        + "3. 역 조회\n"
        + "B. 돌아가기\n"),
    LINE_MANAGEMENT("## 노선 관리 화면\n"
        + "1. 노선 등록\n"
        + "2. 노선 삭제\n"
        + "3. 노선 조회\n"
        + "B. 돌아가기\n"),
    SECTION_MANAGEMENT("## 구간 관리 화면\n"
        + "1. 구간 등록\n"
        + "2. 구간 삭제\n"
        + "B. 돌아가기\n"),

    STATION_REGISTRATION("[INFO] 지하철 노선이 등록되었습니다."),
    STATION_DELETION("[INFO] 지하철 노선이 삭제되었습니다."),
    SECTION_REGISTRATION("[INFO] 구간이 등록되었습니다."),
    SECTION_DELETION("[INFO] 구간이 삭제되었습니다."),

    INFO("[INFO] "),

    STATION_LIST("## 역 목록"),

    ERROR_FEATURE("[ERROR] 선택할 수 없는 기능입니다."),
    ERROR_STATION_NAME_LENGTH("[ERROR] 2글자 이상의 역 이름을 입력하세요."),
    ERROR_STATION_NAME_REPETITION("[ERROR] 중복되는 역 이름입니다."),
    ERROR_STATION_DELETION("[ERROR] 삭제할 역 이름이 존재하지 않습니다.");


    private String Message;

    InfoMessages(String Message) {
        this.Message = Message;
    }

    public String getMessage() {
        return Message;
    }

    public void println() {
        System.out.println(Message);
    }

}
