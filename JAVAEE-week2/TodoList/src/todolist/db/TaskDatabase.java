package todolist.db;

import todolist.task.Task;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class TaskDatabase {
    private static Long id = 1L;

    static ArrayList<Task> allTasks = new ArrayList<>();

    static{
    }

    public static void addTask(Task task){
        task.setId(id);
        allTasks.add(task);
        id++;
    }

    public static Task getTask(Long id){
        Task taskToReturn = allTasks.stream().filter(a -> a.getId() == id).collect(Collectors.toList()).get(0);
        return taskToReturn;
    }

    public static ArrayList getAllTasks(){
        return allTasks;
    }

    public static void deleteTask(Long id){
        allTasks.removeIf(task -> task.getId().equals(id));
    }
}
