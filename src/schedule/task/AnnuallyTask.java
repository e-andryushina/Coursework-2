package schedule.task;

import schedule.task.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnnuallyTask extends Task {


    public AnnuallyTask(String title, String description, TaskType typeOfTask,
                        LocalDateTime taskDateTime) {
        super(title, description, typeOfTask, taskDateTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        LocalDate taskDate = getTaskDateTime().toLocalDate();
        return taskDate.getDayOfMonth() == date.getDayOfMonth() &&
        taskDate.getMonth().equals(date.getMonth()) && taskDate.isBefore(date);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

