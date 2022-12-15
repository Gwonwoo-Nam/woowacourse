package pairmatching.controller;

import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.domain.PairRepository;
import pairmatching.view.InfoMessages;
import pairmatching.view.InputView;

public class PairLookup {

    public static void lookup() {
        InfoMessages.CHOOSE_OPTIONS.println();
        List<String> options = InputView.readOptions();

        String course = options.get(0);
        String level = options.get(1);
        Mission mission = new Mission(options.get(2));

        print(course, level, mission);
    }

    public static void print(String course, String level, Mission mission) {

        int printCount = 0;
        for (Pair pair : PairRepository.getPairList()) {
            if (pair.getLevel().equals(level) &&
                pair.getMission().getName().equals(mission.getName()) &&
                pair.getCrewList().get(0).getCourse().getName().equals(course)) {
                String crewList = String.join(" : ", pair.getCrewNameList());
                System.out.println(crewList);
                printCount++;
            }
        }
        if (printCount == 0) {
            System.out.println("[ERROR] 매칭 이력이 없습니다.");
        }
    }

}
