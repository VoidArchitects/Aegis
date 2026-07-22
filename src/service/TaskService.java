package service;
import enums.Category;
import enums.Priority;
import java.time.LocalDate;
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
    public void removeTask(int index){
        tasks.remove(index - 1);
    }
    public void markTaskAsCompleted(int index){
        tasks.get(index - 1).markComplete();
    }
    public void markTaskAsNotCompleted(int index){
        tasks.get(index - 1).markIncomplete();
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
    // ==================================EDIT METHODS====================================
    public void editTitle(int index, String newTitle){
        Task task = tasks.get(index - 1);
        task.setTitle(newTitle);
    }
    public void editDescription(int index, String newDescription){
        Task task = tasks.get(index - 1);
        task.setDescription(newDescription);
    }
    public void editCategory(int index, Category newCategory){
        Task task = tasks.get(index - 1);
        task.setCategory(newCategory);
    }
    public void editPriority(int index, Priority newPriority){
        Task task = tasks.get(index - 1);
        task.setPriority(newPriority);
    }
    public void editDeadline(int index, LocalDate newDeadline){
        Task task = tasks.get(index - 1);
        task.setDeadline(newDeadline);
    }
}