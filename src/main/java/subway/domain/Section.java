package subway.domain;

import java.util.HashSet;
import java.util.Set;

public class Section {
    private Set<String> points = new HashSet<>();
    private int distance;
    private int time;

    Section(String pointFrom, String pointTo, int distance, int time) {
        this.points = Set.of(pointFrom,pointTo);
        this.distance = distance;
        this.time = time;
    }

}
