package Task;

public enum RepeatType {

    ONE_TIME("Однократная"),
    DAILY("Ежедневная"),
    WEEKLY("Еженедельная"),
    MONTHLY("Ежемесячная"),
    ANNUAL("Ежегодная");

    String repeatType;

    RepeatType(String repeatType) {
        this.repeatType = repeatType;
    }

    public String getRepeatType() {
        return repeatType;
    }
}
