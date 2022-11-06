package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task {

    private final int id;

    private static int counter;

    private final String heading;

    private final String description;

    private TaskType taskType;

    private RepeatType repeatType;

    private final LocalDateTime dateTimeCreation;

    private LocalDate nextDate;

    public Task(String heading,
                String description,
                TaskType taskType,
                RepeatType repeatType) {
        if (heading == null || heading.isBlank() ||
                description == null || description.isBlank()) {
            throw new IllegalArgumentException("Заполните задачу полностью!");
        }
        counter++;
        this.id = getCounter();
        this.heading = heading;
        this.description = description;
        this.taskType = taskType;
        this.repeatType = repeatType;
        this.dateTimeCreation = LocalDateTime.now();
        this.nextDate = nextDate();
    }

    public int getId() {
        return id;
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public RepeatType getRepeatType() {
        return repeatType;
    }

    public LocalDateTime getDateTimeCreation() {
        return dateTimeCreation;
    }

    public LocalDate getNextDate() {
        return nextDate;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Задача -" +
                "Заголовок - '" + heading + '\'' +
                ", Описание - '" + description + '\'' +
                ", Тип - " + taskType.getTaskType() +
                ", Повторяемость - " + repeatType.getRepeatType() +
                ", Дата и время создания - " + dateTimeCreation +
                '}';
    }

    public LocalDate nextDate() {
        switch (this.repeatType) {
            case ONE_TIME:
                nextDate = LocalDate.from(dateTimeCreation);
                break;
            case DAILY:
                nextDate = LocalDate.from(dateTimeCreation.plusDays(1));
                break;
            case WEEKLY:
                nextDate = LocalDate.from(dateTimeCreation.plusWeeks(1));
                break;
            case MONTHLY:
                nextDate = LocalDate.from(dateTimeCreation.plusMonths(1));
                break;
            case ANNUAL:
                nextDate = LocalDate.from(dateTimeCreation.plusYears(1));
                break;
            default:
                break;
        }
        return nextDate;
    }
}