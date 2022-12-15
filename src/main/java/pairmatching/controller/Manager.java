package pairmatching.controller;

import java.io.IOException;
import pairmatching.view.InfoMessages;
import pairmatching.view.InputRegex;
import pairmatching.view.InputView;

public class Manager {


    public static void run() throws IOException {
        chooseFeature();

    }

    private static void chooseFeature() throws IOException {
        InfoMessages.CHOOSE_FEATURE.println(); //예외 1
        String feature = InputView.readLine();
        try {
            Validator.matchRegex(feature, InputRegex.FEATURE_REGEX.getMessage(), InfoMessages.ERROR_FEATURE.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        if (feature.equals("1")) {
            InfoMessages.INFORMATION.println();
            PairMatching.chooseOptions();
        }
        if (feature.equals("2")) {
            InfoMessages.INFORMATION.println();
            PairLookup.lookup();
        }
        if (feature.equals("3")) {
            PairReset.reset();
        }
        if (feature.equals("Q")) {
            return ;
        }
        chooseFeature();
    }


}
