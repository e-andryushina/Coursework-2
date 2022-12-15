import schedule.Schedule;
import schedule.task.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Schedule schedule = new Schedule();
            try (Scanner scanner = new Scanner(System.in)) {
                label:
                while (true) {
                    printMenu();
                    System.out.print("Выберите пункт меню: ");
                    if (scanner.hasNextInt()) {
                        int menu = scanner.nextInt();
                        switch (menu) {
                            case 1:
                                inputTask(schedule, scanner);
                                break;
                            case 2:
                                removeTask(schedule, scanner);
                                break;
                            case 3:
                                getTasksOfDay(schedule, scanner);
                                break;
                            case 0:
                                break label;
                        }
                    } else {
                        scanner.next();
                        System.out.println("Выберите пункт меню из списка!");
                    }
                }
            }
        }

        private static LocalDate inputDate (Scanner scanner) {
        LocalDate date = null;
        boolean userNeedToAnswer = true;
        while (userNeedToAnswer) {
            try {
                System.out.println("Введите дату задачи в формате дд.мм.гггг.");
                String dateOfTask = scanner.nextLine();
                date = LocalDate.parse(dateOfTask, DateTimeFormatter.ofPattern("дд.мм.гггг."));
                userNeedToAnswer = false;
            } catch (Exception e) {
                System.out.println("Пожалуйста, введите задачу еще раз");
            }
        }
        return date;
    }

        private static void inputTask(Schedule schedule, Scanner scanner) {

            System.out.print("Введите название задачи: ");
            String taskName = scanner.next();
            scanner.nextLine();
            System.out.print("Введите описание задачи: ");
            String taskDescription = scanner.nextLine();
            LocalDate taskDate = inputDate(scanner);
            System.out.println("Введите время задачи в формате чч:мм");
            String time = scanner.nextLine();
            LocalTime taskTime = LocalTime.parse (time, DateTimeFormatter.ofPattern("чч:мм"));
            LocalDateTime finalDate = LocalDateTime.of (taskDate, taskTime);
            System.out.println("Введите тип задачи:%n"
                    +"1 - Личный%n"
                    +"2 - Рабочий%n");
            int type = scanner.nextInt();
            TaskType taskType = type == 1 ? TaskType.PERSONAL : TaskType.WORK;

            System.out.printf("Введите повторяемость задачи:%n"
                    + "0 - не повторяется%n"
                    + "1 - ежедневно%n"
                    + "2 - еженедельно%n"
                    + "3 - ежемесячно%n"
                    + "4 - раз в год%n"
            );
            int taskRepeat = scanner.nextInt();
            switch (taskRepeat) {
                case 0:
                    schedule.addTask(new SingleTask(taskName, taskDescription,taskType, finalDate ));
                case 1:
                    schedule.addTask(new DailyTask(taskName, taskDescription,taskType, finalDate ));
                case 2:
                    schedule.addTask(new WeeklyTask(taskName, taskDescription,taskType, finalDate ));
                case 3:
                    schedule.addTask(new MonthlyTask(taskName, taskDescription,taskType, finalDate ));
                case 4:
                    schedule.addTask(new AnnuallyTask(taskName, taskDescription,taskType, finalDate ));
                default:
                    throw new RuntimeException("Нет такого типа задач");
            }
        }


        private static void removeTask (Schedule schedule, Scanner scanner) {
            System.out.println("Введите id задачи. которую Вы хотите удалить");
           int id = scanner.nextInt();
           schedule.removeTask(id);
        }

        private static void getTasksOfDay (Schedule schedule, Scanner scanner) {
            System.out.println("Чтобы получить список задач, введите дату в формате дд.мм.гггг.");
            scanner.nextLine();
            String date = scanner.nextLine();
            LocalDate taskDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("дд.мм.гггг."));
            Collection<Task> tasks = schedule.getTaskOfDay(taskDate);
            for (Task task : tasks) {
                if (tasks.size() == 0) {
                    System.out.println("Нет задач на: " + date);
                } else {
                    System.out.printf("%s %s %s Описание: %s%n", task.getTaskID(), task.getTitle(),
                            task.getTaskDateTime().toLocalTime(), task.getDescription());
                }
            }
        }

        private static void printMenu() {
            System.out.printf("1. Добавить задачу %n" +
                    "2. Удалить задачу %n" +
                    "3. Получить задачу на указанный день %n" +
                    "0. Выход %n"
            );
        }
    }
