package schedule.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {


private static int countTaskID = 1;
private int taskID;
private String title;
private String description;
private TaskType typeOfTask;
private LocalDateTime taskDateTime;

    public Task(String title, String description, TaskType typeOfTask,
                LocalDateTime taskDateTime) {

        this.taskID = countTaskID++;
        this.title = title;
        this.description = description;
        this.typeOfTask = typeOfTask;
        this.taskDateTime = taskDateTime;

    }

    public static int getCountTaskID() {
        return countTaskID;
    }

    public int getTaskID() {
        return taskID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskType getTypeOfTask() {
        return typeOfTask;
    }

    public LocalDateTime getTaskDateTime() {
        return taskDateTime;
    }

    public abstract boolean appearsIn (LocalDate date);

    @Override
    public String toString() {
        return "Task{" +
                "taskID=" + taskID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", typeOfTask='" + typeOfTask + '\'' +
                ", taskDateTime=" + taskDateTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskID == task.taskID && Objects.equals(title, task.title) && Objects.equals(description, task.description) && typeOfTask == task.typeOfTask && Objects.equals(taskDateTime, task.taskDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskID, title, description, typeOfTask, taskDateTime);
    }
}
