package Task;

public enum TaskType {
    PERSONAL("Личная"),
    WORKING("Рабочая");

    String taskType;

    TaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskType() {
        return taskType;
    }
}
