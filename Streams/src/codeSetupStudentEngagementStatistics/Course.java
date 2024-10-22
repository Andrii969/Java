package codeSetupStudentEngagementStatistics;

public record Course(String courseCode, String title, int lectureCount) {

    // Compact constructor with validation (available for records, not for classes)
    public Course {
        if (lectureCount <= 0) {
            lectureCount = 1;
        }
    }

    public Course(String courseCode, String title) {
        this(courseCode, title, 40);
    }

    @Override
    public String toString() {
        return "%s %s".formatted(courseCode, title);
    }
}
