package pairmatching.controller;

import java.io.IOException;
import java.util.List;
import pairmatching.domain.Course;

import pairmatching.domain.CrewRepository;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.domain.PairRepository;
import pairmatching.view.InfoMessages;
import pairmatching.view.InputView;

public class PairMatching {
    private static final String BACKEND_CREW_PATH_NAME = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_CREW_PATH_NAME = "src/main/resources/frontend-crew.md";

    public static void chooseOptions() throws IOException {
        InfoMessages.CHOOSE_OPTIONS.println();
        List<String> options = InputView.readOptions();

        String course = options.get(0);
        String level = options.get(1);
        Mission mission = new Mission(options.get(2));
        try {
            Validator.isValid(level,mission);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            chooseOptions();
            return ;
        }

        if (hasHistory(course, level, mission) == true) {
            rematch(course, level, mission);
            return ;
        }
        match(course, level, mission);
        PairLookup.print(course,level,mission);
    }
    private static void rematch(String course, String level, Mission mission) throws IOException {
        InfoMessages.REMATCH.println();
        String input = InputView.readLine();
        if (input.equals("네")) {
            PairRepository.removeIf(course, level, mission);
            match(course, level, mission);
        }
        if (input.equals("아니오")) {
        }
    }

    private static void match(String course, String level, Mission mission) throws IOException {
        CrewRepository.clear();
        readCourseMember(course);

        int rematchCounter = 0;
        while (rematchCounter < 3) {
            CrewRepository.shuffle();
            PairRepository.match(level, mission);
            try {
                PairRepository.validateMatching();
                return;
            } catch (IllegalArgumentException e) {
                PairRepository.removeIf(course,level,mission);
                System.out.println(rematchCounter + "카운터 증가");
                rematchCounter++;
            }
        }
        InfoMessages.ERROR_MATCHING_ERROR.println();
    }

    private static void readCourseMember(String course) throws IOException {
        if (course.equals(Course.BACKEND.getName())) {
            List<String> crewMembers = InputView.readFile(BACKEND_CREW_PATH_NAME);
            for (String name : crewMembers) {
                CrewRepository.add(Course.BACKEND, name);
            }
            return ;
        }
        if (course.equals(Course.FRONTEND.getName())) {
            List<String> crewMembers = InputView.readFile(FRONTEND_CREW_PATH_NAME);
            for (String name : crewMembers) {
                CrewRepository.add(Course.FRONTEND, name);
            }
            return ;
        }
        InfoMessages.ERROR_NON_EXIST_OPTION.println();
        chooseOptions();
    }

    public static boolean hasHistory(String course, String level, Mission mission) {
        for (Pair pair : PairRepository.getPairList()) {
            if (pair.getLevel().equals(level) &&
                pair.getMission().getName().equals(mission.getName()) &&
                pair.getCrewList().get(0).getCourse().getName().equals(course)) {
                return true;
            }
        }
        return false;
    }
}
