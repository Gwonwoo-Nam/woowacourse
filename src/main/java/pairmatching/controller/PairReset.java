package pairmatching.controller;

import pairmatching.domain.PairRepository;
import pairmatching.view.InfoMessages;

public class PairReset {

    public static void reset() {
        PairRepository.clear();
        InfoMessages.INITIALIZATION.println();
    }

}
