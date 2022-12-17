package menu.Domain;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {

    private static List<Coach> coachList = new ArrayList<>();

    public static void addCoaches(List<String> coaches) {
        for (String coachName : coaches)
        coachList.add(new Coach(coachName));
    }

    public static List<Coach> getCoachList() {
        return coachList;
    }
}
