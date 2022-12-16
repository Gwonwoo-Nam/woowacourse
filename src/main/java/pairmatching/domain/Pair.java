package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {

    private List<Crew> crewList;
    private String level;
    private Mission mission;

    public Pair(List<Crew> crewList, String level, Mission mission) {
        this.crewList = crewList;
        this.level = level;
        this.mission = mission;
    }

    public boolean equalsPair(Pair destPair) {
        int count = 0;
        List<Crew> destCrewList = destPair.getCrewList();
        for (Crew srcCrew : crewList) {
            for (Crew destCrew : destCrewList) {
                if (srcCrew.getName().equals(destCrew.getName())) {
                    count++;
                }
            }
        }
        if (crewList.size() == destCrewList.size() && count == crewList.size()) {
            return true;
        }
        return false;
    }

    public List<String> getCrewNameList() {
        List<String> crewString = new ArrayList<>();
        for (Crew crew : crewList) {
            crewString.add(crew.getName());
        }

        return crewString;
    }

    public List<Crew> getCrewList() {

        return crewList;
    }

    public Mission getMission() {
        return mission;
    }

    public String getLevel() {
        return level;
    }

    public boolean getLevelMatching(String input) {
        return level.equals(input);
    }

    public boolean getMissionMatching(Mission input) {
        return mission.getName().equals(input.getName());
    }

    public boolean getCourseMatching(Course course) {
        String courseName = crewList.get(0).getCourse().getName();
        String inputCourseName = course.getName();
        return courseName.equals(inputCourseName);
    }

}
