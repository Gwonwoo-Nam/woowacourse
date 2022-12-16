package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class SectionRepository {
    public void initialize() {
        for (Section section : SectionInitializer.SECTION_LIST.getSections()) {
            addSection(section);
        }
    }

    private static List<Section> sections = new ArrayList<>();

    public static void addSection(Section section) {
        sections.add(section);
    }


}
