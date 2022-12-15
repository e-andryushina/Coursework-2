package schedule;

import schedule.task.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Schedule {

    private final Map<Integer, Task> tasks = new HashMap<>();


    public void addTask(Task task) {
        tasks.put(task.getTaskID(), task);
    }

    public void removeTask (int id) {
        if (!tasks.containsKey(id)) {
            throw new IllegalArgumentException("Не найден ID задачи");
        }
        else {
            tasks.remove(id);
        }
    }


    public Collection<Task> getTaskOfDay(LocalDate day) {
        String dateString = day.format(DateTimeFormatter.ofPattern("dd.mm.yyyy"));
        System.out.println("Задачи на " + dateString);
        Set<Task> taskOfDay = new TreeSet<>(new TaskTimeComparator());
        for (Task task : tasks.values()) {
            if (task.appearsIn(day)) {
                taskOfDay.add(task);
            }
        }
        return taskOfDay;
    }


}

