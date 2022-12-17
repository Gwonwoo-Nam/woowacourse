package subway.View;

import java.util.List;

public class OutputView {

    public static void printResult(List<String> shortestPath, int totalTime, int totalDistance) {
        InfoMessages.RESULT.println();
        InfoMessages.SEPERATOR.println();
        InfoMessages.INFO_DISTNACE.print();
        System.out.println(totalDistance + "km");
        InfoMessages.INFO_TIME.print();
        System.out.println(totalTime + "분");
        for (String stationName : shortestPath) {
            System.out.println(InfoMessages.INFO.getMessage() + stationName);
        }
    }
}
