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

    public static void chooseOptions() throws IOException {
        InfoMessages.CHOOSE_OPTIONS.println();
        List<String> options = InputView.readOptions();

        Course course = Course.matchCourse(options.get(0));
        String level = options.get(1);
        Mission mission = new Mission(options.get(2));
        if (catchIllegalOption(level, mission)) {
            return;
        }

        if (hasHistory(course, level, mission) == true) {
            rematch(course, level, mission);
            PairLookup.print(course, level, mission);
            return;
        }
        readCrew(course);
        match(course, level, mission);
        PairLookup.print(course, level, mission);
    }

    private static boolean catchIllegalOption(String level, Mission mission) throws IOException {
        try {
            Validator.isValid(level, mission);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            chooseOptions();
            return true;
        }
        return false;
    }

    public static boolean hasHistory(Course course, String level, Mission mission) {
        for (Pair pair : PairRepository.getPairList()) {
            if (pair.getLevelMatching(level) &&
                pair.getMissionMatching(mission) &&
                pair.getCourseMatching(course)) {
                return true;
            }
        }
        return false;
    }

    private static void rematch(Course course, String level, Mission mission) throws IOException {
        InfoMessages.REMATCH.println();
        String input = InputView.readLine();
        if (input.equals(InputView.USER_YES)) {
            PairRepository.removeIf(course, level, mission);
            match(course, level, mission);
        }
        if (input.equals(InputView.USER_NO)) {
        }
    }

    private static void match(Course course, String level, Mission mission) throws IOException {
        int rematchCounter = 0;
        while (rematchCounter < 3) {
            CrewRepository.shuffle();
            PairRepository.match(level, mission);
            try {
                PairRepository.validateMatching();
                return;
            } catch (IllegalArgumentException e) {
                PairRepository.removeIf(course, level, mission);
                rematchCounter++;
            }
        }
        InfoMessages.ERROR_MATCHING_ERROR.println();
    }

    private static void readCrew(Course courseInput) throws IOException {
        CrewRepository.clear();
        for (Course course : Course.values()) {
            if (readByCourse(courseInput, course)) {
                return;
            }
        }
        InfoMessages.ERROR_NON_EXIST_OPTION.println();
        chooseOptions();
    }

    private static boolean readByCourse(Course courseInput, Course course) throws IOException {
        String courseName = courseInput.getName();
        if (courseName.equals(course.getName())) {
            List<String> crewMembers = InputView.readFile(course.getPath());
            for (String name : crewMembers) {
                CrewRepository.add(course, name);
            }
            return true;
        }
        return false;
    }
}
