package schedule.task;

import schedule.task.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {

    public DailyTask(String title, String description, TaskType typeOfTask, LocalDateTime taskDateTime) {
        super(title, description, typeOfTask, taskDateTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        LocalDate taskDate = getTaskDateTime().toLocalDate();
        return taskDate.equals(date) && taskDate.isBefore(date);
    }
}
