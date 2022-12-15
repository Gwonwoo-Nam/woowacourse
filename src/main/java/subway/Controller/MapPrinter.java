package subway.Controller;

import subway.InfoMessages;
import subway.domain.Line;
import subway.domain.LineRepository;

public class MapPrinter {

    public static void draw() {

        for (Line line : LineRepository.lines()) {
            System.out.println(InfoMessages.INFO.getMessage() + line.getName());
            InfoMessages.INFO_SEPERATOR.println();
            for (String stationName : line.getStations()) {
                System.out.println(InfoMessages.INFO.getMessage() + stationName);
            }
            System.out.println();
        }
    }

}
