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


    public static void match(String level, Mission mission) {
        List<Crew> crewList = CrewRepository.getCrewList();
        int index = 0;

        if (crewList.size() % 2 == 0) {
            matchIfEven(crewList, index, level, mission);
        }
        if (crewList.size() % 2 == 1) {
            matchIfOdd(crewList, index, level, mission);
        }


    }

    public static void removeIf(String course, String level, Mission mission) {
        for (Iterator<Pair> iterator = pairList.iterator(); iterator.hasNext();) {
            Pair pair = iterator.next();
            if (pair.getLevel().equals(level) &&
                pair.getMission().getName().equals(mission.getName()) &&
                pair.getCrewList().get(0).getCourse().getName().equals(course)) {
                iterator.remove();
            }
        }
    }

    private static void matchIfEven(List<Crew> crewList, int index, String level, Mission mission) {
        while (index < crewList.size() - 2) { //예외처리, 사이즈가 2보다 작을 때.
            pairList.add(
                new Pair(Arrays.asList(crewList.get(index), crewList.get(index + 1)), level,
                    mission));
            index = index + 2;
        }

    }

    private static void matchIfOdd(List<Crew> crewList, int index, String level, Mission mission) {
        while (index < crewList.size() - 3) { //예외처리, 사이즈가 3보다 작을 때.
            pairList.add(
                new Pair(Arrays.asList(crewList.get(index), crewList.get(index + 1)), level,
                    mission));
            index = index + 2;
        }
        pairList.add(new Pair(Arrays.asList(
            crewList.get(index), crewList.get(index + 1), crewList.get(index + 2)), level,
            mission));
    }

    public static void clear() {
        pairList.clear();
    }

    public static List<Pair> getPairList() {
        return pairList;
    }

}
