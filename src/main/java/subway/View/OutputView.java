package subway.View;

import java.util.List;
import subway.InfoMessages;
import subway.domain.Line;
import subway.domain.Station;

public class OutputView {

    public static void lookupStation (List<Station> stations) {
        InfoMessages.STATION_LIST.println();
        for (Station station : stations) {
            System.out.println(InfoMessages.INFO.getMessage() + station.getName());
        }
    }

    public static void lookupLine (List<Line> lines) {
        InfoMessages.LINE_LIST.println();
        for (Line line : lines) {
            System.out.println(InfoMessages.INFO.getMessage() + line.getName());
        }
    }

}
