package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.InfoMessages;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void addStations(String lineName, String upstreamEndpoint,
        String downstreamEndpoint) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                line.addStations(Arrays.asList(upstreamEndpoint, downstreamEndpoint));
            }
        }
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteSectionByName(String lineName, String stationName) {

        for (String station : getLineByName(lineName).getStations()) {
            if (station.equals(stationName)) {
                getLineByName(lineName).getStations().remove(stationName);
            }
        }
    }

    public static Line getLineByName(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                return line;
            }
        }
        return null;
    }


}
