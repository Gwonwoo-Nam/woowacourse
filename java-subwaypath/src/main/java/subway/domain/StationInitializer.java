package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum StationInitializer {
    STATION_LIST(Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));
    private List<String> stationNames = new ArrayList<>();

    StationInitializer(List<String> stationNames) {
        this.stationNames = stationNames;
    }
    public List<String> getStations() {
        return stationNames;
    }
}

