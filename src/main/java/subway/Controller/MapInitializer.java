package subway.Controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class MapInitializer {

    public static void initializeStations() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
    }

    public static void initializeLines() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));

        LineRepository.addStations("2호선", "교대역", "역삼역");
        LineRepository.addStations("3호선", "교대역", "매봉역");
        LineRepository.addStations("신분당선", "강남역", "양재시민의숲역");
    }

}
