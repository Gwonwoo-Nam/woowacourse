package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    public void initialize() {
        for (LineInitializer initializer : LineInitializer.values()) {
            Line line = new Line(initializer.getLineName())
            for (String stationName : initializer.getStations()) {
                line.addStation(stationName);
            }
            addLine(line);
        }
    }
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }


    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }
}
