package schedule.task;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public String taskTypeToString(Task task) {
        switch (task.getTypeOfTask()) {
            case PERSONAL:
                return "Личная";
            case WORK:
                return "Рабочая";
        }
        return taskTypeToString(task);
    }
}
