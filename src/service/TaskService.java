package service;
import enums.Category;
import enums.Priority;
import java.util.ArrayList;
import java.util.List;
import model.Task;
public class TaskService{
    private final List<Task> tasks;
    public TaskService(){
        tasks = new ArrayList<>();
    }
    // ================================TASK MANAGEMENT METHODS=================================
    public void addTask(Task task){
        tasks.add(task);
    }
    public void removeTask(Task task){
        tasks.remove(task);
    }
    public void markTaskAsCompleted(Task task){
        task.markComplete();
    }
    public void markTaskAsNotCompleted(Task task){
        task.markIncomplete();
    }
    // ================================QUERIES=================================
    public List<Task> getAllTasks(){
        return List.copyOf(tasks);
    }
    public int getTaskCount(){
        return tasks.size();
    }
    public boolean hasTasks() {
        return !tasks.isEmpty();
    }
    // =================================SEARCH METHODS=================================
    public List<Task> findTasksByTitle(String title){
        List<Task> result = new ArrayList<>();
        for(Task task : tasks){
            if(task.getTitle().equalsIgnoreCase(title)){
                result.add(task);
            }
        }
        return result;
    }
    public List<Task> findTasksByCategory(Category category){
        List<Task> result = new ArrayList<>();
        for(Task task : tasks){
            if(task.getCategory() == (category)){
                result.add(task);
            }
        }
        return result;
    }
    public List<Task> findTasksByPriority(Priority priority){
        List<Task> result = new ArrayList<>();
        for(Task task : tasks){
            if(task.getPriority() == (priority)){
                result.add(task);
            }
        }
        return result;
    }
    // ================================SORTING METHODS=================================
    public List<Task> sortTasksByTitle(){
        List<Task> sortedTasks = new ArrayList<>(tasks);
        sortedTasks.sort((a, b) -> a.getTitle().compareTo(b.getTitle()));
        return List.copyOf(sortedTasks);
    }
    public List<Task> sortTasksByPriority(){
        List<Task> sortedTasks = new ArrayList<>(tasks);
        sortedTasks.sort((a,b) -> a.getPriority().compareTo(b.getPriority()));
        return List.copyOf(sortedTasks);
    }
    public List<Task> sortTasksByDeadline(){
        List<Task> sortedTasks = new ArrayList<>(tasks);
        sortedTasks.sort((a,b) -> a.getDeadline().compareTo(b.getDeadline()));
        return List.copyOf(sortedTasks);
    }
}