package Task;

import Task.Task;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    static TaskList taskList = new TaskList();

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            deleteTask(scanner);
                            break;
                        case 3:
                            getTaskForDay(scanner);
                        case 4:
                            taskList.printAllTasks();
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

    private static void inputTask(Scanner scanner) {
        try {
            System.out.print("Введите заголовок задачи: " );
            String headingName = scanner.next();
            System.out.print("Введите описание задачи: " );
            String descriptionName = scanner.next();
            int typeOfTask;
            int repeatability;
            do {
                System.out.print("Введите тип задачи:\n" +
                        "1. Личная.\n" +
                        "2. Рабочая.\n" +
                        "Ввод: " );
                typeOfTask = scanner.nextInt();

                System.out.print("Введите повторяемость задачи:\n" +
                        "1. Однократная.\n" +
                        "2. Ежедневная.\n" +
                        "3. Еженедельная.\n" +
                        "4. Ежемесячная.\n" +
                        "5. Ежегодная.\n" +
                        "Ввод: " );
                repeatability = scanner.nextInt();
            } while (!(repeatability > 0 && repeatability < 6) || !(typeOfTask > 0 && typeOfTask < 3));

            switch (repeatability) {
                case 1:
                    if (typeOfTask == 1) {
                        Task task1 = new Task(headingName, descriptionName, TaskType.PERSONAL, RepeatType.ONE_TIME);
                        taskList.addList(task1.getId(), task1);
                        break;
                    } else {
                        Task task1 = new Task(headingName, descriptionName, TaskType.WORKING, RepeatType.ONE_TIME);
                        taskList.addList(task1.getId(), task1);
                        break;
                    }
                case 2:
                    if (typeOfTask == 1) {
                        Task task1 = new Task(headingName, descriptionName, TaskType.PERSONAL, RepeatType.DAILY);
                        taskList.addList(task1.getId(), task1);
                        break;
                    } else {
                        Task task1 = new Task(headingName, descriptionName, TaskType.WORKING, RepeatType.DAILY);
                        taskList.addList(task1.getId(), task1);
                        break;
                    }
                case 3:
                    if (typeOfTask == 1) {
                        Task task1 = new Task(headingName, descriptionName, TaskType.PERSONAL, RepeatType.WEEKLY);
                        taskList.addList(task1.getId(), task1);
                        break;
                    } else {
                        Task task1 = new Task(headingName, descriptionName, TaskType.WORKING, RepeatType.WEEKLY);
                        taskList.addList(task1.getId(), task1);
                        break;
                    }
                case 4:
                    if (typeOfTask == 1) {
                        Task task1 = new Task(headingName, descriptionName, TaskType.PERSONAL, RepeatType.MONTHLY);
                        taskList.addList(task1.getId(), task1);
                        break;
                    } else {
                        Task task1 = new Task(headingName, descriptionName, TaskType.WORKING, RepeatType.MONTHLY);
                        taskList.addList(task1.getId(), task1);
                        break;
                    }
                case 5:
                    if (typeOfTask == 1) {
                        Task task1 = new Task(headingName, descriptionName, TaskType.PERSONAL, RepeatType.ANNUAL);
                        taskList.addList(task1.getId(), task1);
                        break;
                    } else {
                        Task task1 = new Task(headingName, descriptionName, TaskType.WORKING, RepeatType.ANNUAL);
                        taskList.addList(task1.getId(), task1);
                        break;
                    }
            }
        } catch (RuntimeException e) {
            System.out.println("Ошибка в заполнении задачи!");
        }
    }



    public static void deleteTask(Scanner scanner) {
        try {
            System.out.print("Введите ID задачи для удаления: " );
            int delete = scanner.nextInt();
            if (taskList.deleteTask(delete)) {
                System.out.println("\nЗадача с заданным ID - удалена успешно!\n" );
            } else {
                System.out.println("\nНе удается удалить задачу. Проверьте ввод id!\n" );
            }
        } catch (RuntimeException e) {
            System.out.println("Ошибка в удалении задачи!");
        }
    }

    public static void getTaskForDay(Scanner scanner) {
        try {
            System.out.print("Введите дату для поиска задачи в формате 'yyyy-mm-dd': " );
            String dateInputStr = scanner.next();
            if (!isValidDate(dateInputStr)) {
                LocalDate dateInput = LocalDate.parse(dateInputStr);
                taskList.receivingTask(dateInput);
            } else {
                System.out.print("\nВведена дата не по формату!\n\n" );
                System.out.print("Cписок доступных задач:\n\n" );
            }
        } catch (RuntimeException е) {
            System.out.println("Ошибка в получении задачи!");
        }
    }

    private static void printMenu() {
        System.out.println(
                "1. Добавить задачу.\n" +
                        "2. Удалить задачу.\n" +
                        "3. Получить задачу на указанный день.\n" +
                        "4. Получить список всех задач.\n" +
                        "0. Выход."
        );
    }

    public static boolean isValidDate(String dateStr) {

        if (!dateStr.matches("((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])")) {
            return true;
        } else {
            return false;
        }
    }
}