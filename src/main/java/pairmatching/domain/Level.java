package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", Arrays.asList(new Mission("자동차경주"),
        new Mission("로또"), new Mission("숫자야구게임"))),
    LEVEL2("레벨2", Arrays.asList(new Mission("장바구니"), new Mission("결제"), new Mission("지하철노선도"))),
    LEVEL3("레벨3"),
    LEVEL4("레벨4", Arrays.asList(new Mission("성능개선"), new Mission("배포"))),
    LEVEL5("레벨5");

    private String name;
    private List<Mission> missions = new ArrayList<>();

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }

    Level(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    // 추가 기능 구현
}