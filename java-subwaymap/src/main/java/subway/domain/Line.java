package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<String> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getStations() {
        return stations;
    }

    public void addStations(List<String> stationsName) {
        for (String stationName : stationsName) {
            stations.add(stationName);
        }
    }


}
