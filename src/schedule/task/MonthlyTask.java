package schedule.task;

import schedule.task.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {

    public MonthlyTask(String title, String description, TaskType typeOfTask,
                       LocalDateTime taskDateTime) {
        super(title, description, typeOfTask, taskDateTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        LocalDate taskDate = getTaskDateTime().toLocalDate();
        return (taskDate.getDayOfMonth() == date.getDayOfMonth())
                && taskDate.isBefore(date);
    }
}

