package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum SectionInitializer {

    SECTION_LIST(Arrays.asList(new Section("교대역", "강남역", 2, 3),
            new Section("강남역", "역삼역", 2, 3),
            new Section("교대역", "남부터미널역", 3, 2),
            new Section("남부터미널역", "양재역", 6, 5),
            new Section("양재역", "매봉역", 1, 1),
            new Section("강남역", "양재역", 2, 8),
            new Section("양재역", "양재시민의숲역", 10, 3)));

    private List<Section> sections = new ArrayList<>();

    SectionInitializer(List<Section> sections) {
        this.sections = sections;
    }

    public List<Section> getSections() {
        return sections;
    }
}

