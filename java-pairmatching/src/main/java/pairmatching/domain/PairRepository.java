package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import pairmatching.view.InfoMessages;

public class PairRepository {

    private static List<Pair> pairList = new ArrayList<>();

    public static void validateMatching() {
        for (int i = 0; i < pairList.size() - 1; i++) {
            for (int j = i + 1; j <pairList.size(); j++) {
                if (pairList.get(i).equalsPair(pairList.get(j)) == true) {
                    throw new IllegalArgumentException(InfoMessages.ERROR_MATCHING_ERROR.getMessage());
                }
            }
        }
    }


    public static void match(String level, Mission mission, Course course) {
        List<String> crewList = CrewRepository.getCrewList();

        if (crewList.size() % 2 == 0) {
            matchIfEven(level, mission, course);
        }
        if (crewList.size() % 2 == 1) {
            matchIfOdd(level, mission, course);
        }


    }

    public static void removeIf(Course course, String level, Mission mission) {
        for (Iterator<Pair> iterator = pairList.iterator(); iterator.hasNext();) {
            Pair pair = iterator.next();
            if (pair.getLevel().equals(level) &&
                pair.getMission().getName().equals(mission.getName()) &&
                pair.getCourse().getName().equals(course)) {
                iterator.remove();
            }
        }
    }

    private static void matchIfEven(String level, Mission mission, Course course) {
        int index = 0;
        List<String> crewList = CrewRepository.getCrewList();
        while (index <= crewList.size() - 2) { //예외처리, 사이즈가 2보다 작을 때.
            pairList.add(
                new Pair(Arrays.asList(crewList.get(index), crewList.get(index + 1)), level,
                    mission, course));
            index = index + 2;
        }

    }

    private static void matchIfOdd(String level, Mission mission, Course course) {
        int index = 0 ;
        List<String> crewList = CrewRepository.getCrewList();
        while (index < crewList.size() - 3) { //예외처리, 사이즈가 3보다 작을 때.
            pairList.add(
                new Pair(Arrays.asList(crewList.get(index), crewList.get(index + 1)), level,
                    mission, course));
            index = index + 2;
        }
        pairList.add(new Pair(Arrays.asList(
            crewList.get(index), crewList.get(index + 1), crewList.get(index + 2)), level,
            mission,course));
    }

    public static void clear() {
        pairList.clear();
    }

    public static List<Pair> getPairList() {
        return pairList;
    }

}
