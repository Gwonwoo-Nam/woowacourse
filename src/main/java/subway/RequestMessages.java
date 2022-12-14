package subway;

public enum RequestMessages {
    FEATURE("## 원하는 기능을 선택하세요."),
    REGISTRATION_STATION("## 등록할 역 이름을 입력하세요."),
    DELETION_STATION("## 삭제할 역 이름을 입력하세요."),

    REGISTRATION_LINE("## 등록할 노선 이름을 입력하세요."),
    UPSTREAM_ENDPOINT("## 등록할 노선의 상행 종점역 이름을 입력하세요."),
    DOWNSTREAM_ENDPOINT("## 등록할 노선의 하행 종점역 이름을 입력하세요."),
    DELETION_LINE("## 삭제할 노선 이름을 입력하세요."),

    SECTION_REGISTRATION_LINE("## 노선을 입력하세요."),
    SECTION_REGISTRATION_STATION("## 역이름을 입력하세요."),
    SECTION_REGISTRATION_ORDER("## 순서를 입력하세요."),
    SECTION_DELETION_LINE("## 삭제할 구간의 노선을 입력하세요."),
    SECTION_DELETION_STATION("## 삭제할 구간의 역을 입력하세요.");

    private String Message;
    RequestMessages(String Message) {
        this.Message = Message;
    }

    public String getMessage() {
        return Message;
    }
}
