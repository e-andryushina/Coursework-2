package schedule.task;

import schedule.task.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {

    public WeeklyTask(String title, String description, TaskType typeOfTask,
                      LocalDateTime taskDateTime) {
        super(title, description, typeOfTask, taskDateTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
     LocalDate taskDate = getTaskDateTime().toLocalDate();
        return taskDate.getDayOfWeek().equals(date.getDayOfWeek())
                && taskDate.isBefore(date);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
