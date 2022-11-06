package Task;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TaskList {

    private HashMap <Integer, Task> taskHashMap = new HashMap<>();

    public void addList(int id, Task task) {
        taskHashMap.put(id, task);
    }

    public void printAllTasks() {
        for (Map.Entry<Integer, Task> entry : taskHashMap.entrySet()) {
            System.out.println("id = " + entry.getKey() + " " + entry.getValue());
        }
    }

    public boolean deleteTask(int id) {
        boolean fladDelete = false;
        for (Map.Entry<Integer, Task> entry : taskHashMap.entrySet()) {
            if (entry.getKey() == id) {
                taskHashMap.remove(id);
                fladDelete = true;
                break;
            }
        }
        return  fladDelete;
    }

    public void receivingTask(LocalDate dateInput) {
        System.out.println("dateInput = " + dateInput);
        for (Map.Entry<Integer, Task> entry : taskHashMap.entrySet()) {
            if (entry.getValue().getNextDate().equals(dateInput)) {
                System.out.println(entry.getValue());
            }
        }
    }

}
