package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Section {
    private List<String> points = new ArrayList<>();
    private int distance;
    private int time;

    Section(String pointFrom, String pointTo, int distance, int time) {
        this.points = Arrays.asList(pointFrom, pointTo);
        this.distance = distance;
        this.time = time;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public List<String> getPoints() {
        return points;
    }
}
