package pairmatching.view;

public enum InfoMessages {

    CHOOSE_FEATURE("기능을 선택하세요.\n"
        + "1. 페어 매칭\n"
        + "2. 페어 조회\n"
        + "3. 페어 초기화\n"
        + "Q. 종료"),
    INFORMATION("#############################################\n"
        + "과정: 백엔드 | 프론트엔드\n"
        + "미션:\n"
        + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
        + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
        + "  - 레벨3: \n"
        + "  - 레벨4: 성능개선 | 배포\n"
        + "  - 레벨5: \n"
        + "############################################"),
    CHOOSE_OPTIONS("과정, 레벨, 미션을 선택하세요.\n"
        + "ex) 백엔드, 레벨1, 자동차경주"),
    MATCHING_RESULT("페어 매칭 결과입니다."),
    REMATCH("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
        + "네 | 아니오"),
    INITIALIZATION("초기화 되었습니다."),

    ERROR_FEATURE("[ERROR] 유효하지 않은 기능 입력 값입니다."),
    ERROR_NON_EXIST_OPTION("[ERROR] 일치하는 값이 존재하지 않습니다."),
    ERROR_MATCHING_ERROR("[ERROR] 매칭에 실패하였습니다."),

    ERROR_NO_HISTORY("[ERROR] 매칭 이력이 없습니다."),
    ERROR_IO("[ERROR] 파일 입출력 오류"),

    DELIMITER(" : ");

    private final String message;
    InfoMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void println() {
        System.out.println(message);
    }


}
