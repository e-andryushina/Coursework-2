package schedule.task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SingleTask extends Task {


    public SingleTask(String title, String description, TaskType typeOfTask, LocalDateTime taskDateTime) {
        super(title, description, typeOfTask, taskDateTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getTaskDateTime().toLocalDate().equals(date);
    }
}
