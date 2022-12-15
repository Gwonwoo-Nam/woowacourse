package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
    private static List<Crew> crewList = new ArrayList<>();
    public static void add(Course course, String name) {
        crewList.add(new Crew(course, name));
    }

    public static void shuffle() {
        crewList = Randoms.shuffle(crewList);

    }

    public static void clear() {
        crewList.clear();
    }

    public static List<Crew> getCrewList() {
        return crewList;
    }

}
