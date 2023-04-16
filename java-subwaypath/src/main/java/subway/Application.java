package subway;

import java.util.Scanner;

import subway.Controller.PathFinder;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        StationRepository.initialize();
        LineRepository.initialize();
        SectionRepository.initialize();

        PathFinder pathFinder = new PathFinder(scanner);
        pathFinder.mainRun();
    }
}
