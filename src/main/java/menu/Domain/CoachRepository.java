package menu.Domain;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {

    private static List<Coach> coachList = new ArrayList<>();

    public static void addCoaches(List<String> coaches) {
        for (String coachName : coaches)
            coachList.add(new Coach(coachName));
    }

    public static void addUnfavorMenuList(Coach setCoach, List<String> unfavorMenuList) {
        for (Coach coach : coachList) {
            if (coach.getName().equals(setCoach.getName())) {
                coach.addUnfavorMenus(unfavorMenuList);
            }
        }

    }

    public static List<Coach> getCoachList() {
        return coachList;
    }

}
