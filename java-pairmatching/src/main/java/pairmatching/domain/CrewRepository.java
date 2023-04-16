package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
    private static List<String> crewList = new ArrayList<>();
    public static void add(String name) {
        crewList.add(name);
    }

    public static void shuffle() {
        crewList = Randoms.shuffle(crewList);

    }

    public static void clear() {
        crewList.clear();
    }

    public static List<String> getCrewList() {
        return crewList;
    }

}
