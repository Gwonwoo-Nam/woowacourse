package subway.Controller;

import subway.InfoMessages;
import subway.InputRegex;
import subway.View.InputView;



public class MainController {

    public static void run() {
        MapInitializer.initializeStations();
        MapInitializer.initializeLines();

        runMainFeature();
    }

    public static void runMainFeature() {
        InfoMessages.MAIN.println();
        final String mainFeature = InputView.readFeature(InputRegex.MAIN.getRegex());

        if (mainFeature.equals("1")) {
            StationManager.run();
            runMainFeature();
        }
        if (mainFeature.equals("2")) {
            LineManager.run();
            runMainFeature();
        }
        if (mainFeature.equals("3")) {
            SectionManager.run();
            runMainFeature();
        }
        if (mainFeature.equals("4")) {
            MapPrinter.draw();
            runMainFeature();
        }
    }








}
