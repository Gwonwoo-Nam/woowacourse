package pairmatching.controller;

import java.io.IOException;
import pairmatching.view.InfoMessages;
import pairmatching.view.InputRegex;
import pairmatching.view.InputView;

public class Manager {

    private enum menu {
        PAIR_MATCHING_OPTION("1"),
        PAIR_LOOKUP_OPTION("2"),
        PAIR_RESET_OPTION("3");
        private String option;
        menu(String option) {
            this.option = option;
        }
        @Override
        public String toString() {
            return option;
        }
    }

    public static void run() throws IOException {
        while (true) {
            InfoMessages.CHOOSE_FEATURE.println();
            String feature = InputView.readLine();
            if (catchIllegalFeature(feature)) {
                return;
            }
            runPairMatching(feature);
            runPairLookup(feature);
            runPairReset(feature);
            if (feature.equals("Q")) {
                return ;
            }
        }
    }

    private static boolean catchIllegalFeature(String feature) throws IOException {
        try {
            Validator.matchRegex(feature, InputRegex.FEATURE_REGEX.getMessage(),
                InfoMessages.ERROR_FEATURE.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
            return true;
        }
        return false;
    }

    private static void runPairMatching(String feature) throws IOException {
        if (feature.equals(menu.PAIR_MATCHING_OPTION.toString())) {
            InfoMessages.INFORMATION.println();
            PairMatching.chooseOptions();
        }
    }

    private static void runPairLookup(String feature) {
        if (feature.equals(menu.PAIR_LOOKUP_OPTION.toString())) {
            InfoMessages.INFORMATION.println();
            PairLookup.lookup();
        }
    }

    private static void runPairReset(String feature) {
        if (feature.equals(menu.PAIR_RESET_OPTION.toString())) {
            PairReset.reset();
        }
    }
}
