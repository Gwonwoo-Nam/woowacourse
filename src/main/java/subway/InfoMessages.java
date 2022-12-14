package subway;

public enum InfoMessages {
    MAIN("## 메인 화면\n"
        + "1. 역 관리\n"
        + "2. 노선 관리\n"
        + "3. 구간 관리\n"
        + "4. 지하철 노선도 출력\n"
        + "Q. 종료"),
    STATION_MANAGEMENT("1. 역 등록\n"
        + "2. 역 삭제\n"
        + "3. 역 조회\n"
        + "B. 돌아가기\n"),
    LINE_MANAGEMENT("## 노선 관리 화면\n"
        + "1. 노선 등록\n"
        + "2. 노선 삭제\n"
        + "3. 노선 조회\n"
        + "B. 돌아가기"),
    SECTION_MANAGEMENT("## 구간 관리 화면\n"
        + "1. 구간 등록\n"
        + "2. 구간 삭제\n"
        + "B. 돌아가기"),

    STATION_REGISTRATION("[INFO] 지하철 노선이 등록되었습니다."),
    STATION_DELETION("[INFO] 지하철 노선이 삭제되었습니다."),
    SECTION_REGISTRATION("[INFO] 구간이 등록되었습니다."),
    SECTION_DELETION("[INFO] 구간이 삭제되었습니다.");




    private String Message;
    InfoMessages(String Message) {
        this.Message = Message;
    }

    public String getMessage() {
        return Message;
    }

}
