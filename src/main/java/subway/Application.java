package subway;

import java.util.Scanner;

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
        /*for(Station station : StationRepository.stations()) {
            System.out.println(station.getName());
        }
        for(Line line : LineRepository.lines()) {
            System.out.println(line.getName());
        }
        for(Section section : SectionRepository.sections()) {
            System.out.println(section.getTime());
            System.out.println(section.getDistance());
            System.out.println(section.getPoints());
        }*/
    }
}
