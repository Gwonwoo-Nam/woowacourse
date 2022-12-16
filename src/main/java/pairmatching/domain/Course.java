package pairmatching.domain;

public enum Course {
    BACKEND("백엔드", "src/main/resources/backend-crew.md"),
    FRONTEND("프론트엔드", "src/main/resources/frontend-crew.md");

    private String name;
    private String path = "";

    Course(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public static Course matchCourse(String input) {
        for (Course course : Course.values()) {
            if (course.getName().equals(input)) {
                return course;
            }
        }
        return null;
    }

}