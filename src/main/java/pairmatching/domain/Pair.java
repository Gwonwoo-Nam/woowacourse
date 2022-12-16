package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {

    private List<String> crewList;
    private String level;
    private Mission mission;
    private Course course;

    public Pair(List<String> crewList, String level, Mission mission, Course course) {
        this.crewList = crewList;
        this.level = level;
        this.mission = mission;
        this.course = course;
    }

    public boolean equalsPair(Pair destPair) {
        int count = 0;
        List<String> destCrewList = destPair.getCrewList();
        for (String srcCrew : crewList) {
            for (String destCrew : destCrewList) {
                if (srcCrew.equals(destCrew)) {
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
        for (String crew : crewList) {
            crewString.add(crew);
        }

        return crewString;
    }

    public List<String> getCrewList() {

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

    public boolean getCourseMatching(Course inputCourse) {
        return course.getName().equals(inputCourse.getName());
    }

    public Course getCourse() {
        return course;
    }
}
