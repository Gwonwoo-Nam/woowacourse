package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum LineInitializer {

    SECOND_LINE("2호선", Arrays.asList("교대역", "강남역", "역삼역")),

    THIRD_LINE("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역")),

    NEW_LINE("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));

    private String lineName;
    private List<String> stationNames = new ArrayList<>();


    LineInitializer(String line, List<String> stations) {
        this.lineName = line;
        this.stationNames = stations;
    }
    public List<String> getStations() {
        return stationNames;
    }

    public String getLineName() {
        return lineName;
    }
}

