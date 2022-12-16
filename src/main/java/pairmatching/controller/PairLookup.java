package pairmatching.controller;

import java.util.List;
import java.util.stream.Stream;
import pairmatching.domain.Course;
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

        Course course = Course.matchCourse(options.get(0));
        String level = options.get(1);
        Mission mission = new Mission(options.get(2));

        print(course, level, mission);
    }

    public static void print(Course course, String level, Mission mission) {

        int printCount = 0;
        for (Pair pair : PairRepository.getPairList()) {
            if (pair.getLevelMatching(level) &&
                pair.getMissionMatching(mission) &&
                pair.getCourseMatching(course)
            ) {
                String crewList = String.join(InfoMessages.DELIMITER.getMessage(), pair.getCrewNameList());
                System.out.println(crewList);
                printCount++;
            }
        }
        if (printCount == 0) {
            InfoMessages.ERROR_NO_HISTORY.println();
        }
    }

}
