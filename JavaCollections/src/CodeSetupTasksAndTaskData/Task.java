package CodeSetupTasksAndTaskData;

import java.util.Objects;

enum Status {ASSIGNED, IN_PROGRESS, IN_QUEUE}
enum Priority {HIGH, MEDIUM, LOW}

public class Task implements Comparable<Task> {

    private String assignee;
    private String projectName;
    private String projectDescription;
    private Priority priority;
    private Status status;

    public Task(String assignee, String projectName, String projectDescription, Priority priority, Status status) {
        this.assignee = assignee;
        this.projectDescription = projectDescription;
        this.status = status;
        this.projectName = projectName;
        this.priority = priority;
    }

    public Task(String assignee, String projectName, String projectDescription, Priority priority) {
        this(assignee, projectName, projectDescription, priority, assignee != null ? Status.ASSIGNED : Status.IN_QUEUE);
    }

    public Task(String projectName, String projectDescription, Priority priority) {
        this(null, projectName, projectDescription, priority);
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "%-20s %-25s %-10s %-10s %s".formatted(projectName, projectDescription, priority, assignee, status);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Task task = (Task) object;
        return Objects.equals(getProjectName(), task.getProjectName()) && Objects.equals(getProjectDescription(), task.getProjectDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProjectName(), getProjectDescription());
    }

    @Override
    public int compareTo(Task o) {
        int result = projectName.compareTo(o.projectName);
        if (result == 0) {
            result = projectDescription.compareTo(o.projectDescription);
        }
        return result;
    }
}
