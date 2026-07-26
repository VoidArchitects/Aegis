package ui;

import enums.*;
import java.time.LocalDate;
import java.util.List;
import model.Task;
import service.TaskService;

public class TaskUI {
    private final InputHandler inputHandler;
    private final TaskService taskService;

    public TaskUI(InputHandler inputHandler,
        TaskService taskService) {
        this.inputHandler = inputHandler;
        this.taskService = taskService;
    }
    
    public void start(){
        boolean running = true;
        while(running){
            MenuRenderer.displayTaskManagerMenu();
            int choice = inputHandler.readInt();
            switch(choice){
                case 1 -> addTask();
                case 2 -> removeTask();
                case 3 -> markTaskAsCompleted();
                case 4 -> markTaskAsIncomplete();
                case 5 -> viewAllTasks();
                case 6 -> editTask();
                case 7 -> searchByTitle();
                case 8 -> searchByCategory();
                case 9 -> searchByPriority();
                case 0 -> {displayTaskExitMsg(); running = false;}
                default -> System.out.println("Invalid choice, please try again...");
            }
        }
    }
    private void addTask(){
        System.out.println(
            "Give info about the task you want to add:"
        );

        System.out.print(
            "Title: "
        );
        String title = inputHandler.readLine();
        System.out.println("\n");

        System.out.print(
            "Description: "
        );
        String description = inputHandler.readLine();
        System.out.println("\n");

        Category category = inputHandler.readCategory();
        System.out.println("\n");

        Priority priority = inputHandler.readPriority();
        System.out.println("\n");

        LocalDate deadline = inputHandler.readDeadline();

        Task newTask = new Task(title, description, category, priority, deadline);
        taskService.addTask(newTask);
        System.out.println("Task added successfully!");
    }
    private void removeTask(){
        if(!ensureTasksExist()){return;}
        System.out.println("Which task would you like to remove?");
        viewAllTasks();
        System.out.println("Enter the index of the task you would like to remove");
        int index = inputHandler.readInt();
        if(isValidTaskIndex(index)) {
            taskService.removeTask(index);  
            System.out.println("Task removed successfully!!");
        }
    }
    private void markTaskAsCompleted(){
        if(!ensureTasksExist()){return;}
        System.out.println("Which task would you like to mark?");
        viewAllTasks();
        System.out.println("Enter the index of the task you would like to mark");
        int index = inputHandler.readInt();
        if(isValidTaskIndex(index)) {
            taskService.markTaskAsCompleted(index); 
            System.out.println("Task marked as completed successfully!!");
        }
    }
    private void markTaskAsIncomplete(){
        if(!ensureTasksExist()){return;}
        System.out.println("Which task would you like to mark?");
        viewAllTasks();
        System.out.println("Enter the index of the task you would like to mark");
        int index = inputHandler.readInt();
        if(isValidTaskIndex(index)) {
            taskService.markTaskAsNotCompleted(index); 
            System.out.println("Task marked as incomplete successfully!!");
        }
    }
    private void editTask(){
        if(!ensureTasksExist()){return;}
        System.out.println("Which task would you like to edit?");
        viewAllTasks();
        System.out.println("Enter the index of the task you would like to edit");
        int index = inputHandler.readInt();
        if(isValidTaskIndex(index)){
            boolean running = true;
            while(running){
                System.out.println("""
                            ====================================
                                What would you like to edit?
                            ====================================
                                    1. Title       
                                    2. Description  
                                    3. Category     
                                    4. Priority     
                                    5. Deadline    
                                    6. Completed status    
                                    0. back
                            ====================================
                        """);
                System.out.println("Enter your Choice");
                int choice = inputHandler.readInt();
                switch(choice){
                    case 1 -> {
                        System.out.print("New title: ");
                        String title = inputHandler.readLine();
                        taskService.editTitle(index, title);
                        System.out.println("Task updated successfully!");
                    }
                    case 2 -> {
                        System.out.print("New description: ");
                        String description = inputHandler.readLine();
                        taskService.editDescription(index, description);
                        System.out.println("Task updated successfully!");
                    }
                    case 3 -> {
                        System.out.print("New category: ");                       
                        Category category = inputHandler.readCategory();
                        taskService.editCategory(index, category);
                        System.out.println("Task updated successfully!");
                    }
                    case 4 -> {
                        System.out.print("New priority: ");
                        Priority priority = inputHandler.readPriority();
                        taskService.editPriority(index, priority);
                        System.out.println("Task updated successfully!");
                    }
                    case 5 -> {
                        System.out.print("New deadline: ");
                        LocalDate deadline = inputHandler.readDeadline();
                        taskService.editDeadline(index, deadline);
                        System.out.println("Task updated successfully!");
                    }
                    case 6 -> {
                        System.out.print("""
                            Input your choice from 
                                1. Complete
                                2. Incomplete
                                """);
                        int choiceX = inputHandler.readInt();
                        if(choiceX == 1)
                            taskService.markTaskAsCompleted(index);
                        else if(choiceX == 2)
                            taskService.markTaskAsNotCompleted(index);
                        System.out.println("Task updated successfully!");
                    }
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice, try again"); 
                }
            }
        }
    }
    private void viewAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("---------------- TASK "+(i + 1)+" ----------------");
            System.out.println(tasks.get(i));
            System.out.println();
        }
    }
    // =======================================VALIDATION HELPERS============================
    private boolean ensureTasksExist() {
        if (!taskService.hasTasks()) {
            System.out.println("No tasks available.");
            return false;
        }
        return true;
    }
    private boolean isValidTaskIndex(int index){
        if (index < 1 || index > taskService.getTaskCount()) {
            System.out.println("Invalid Index, please try again...");
            return false;
        }
        return true;
    }
    private void displayTaskExitMsg(){
        System.out.println("Exiting task menu...");
    }
    private void searchByTitle(){
        if(!ensureTasksExist()){return;}
        System.out.print("Enter search title: ");
        String title = inputHandler.readLine();
        List<Task> tasks = taskService.findTasksByTitle(title);
        if(tasks.isEmpty()){
            System.out.println("No tasks found with this title.");
            return;
        }
        int i = 1;
        for (Task task : tasks) {
            System.out.println("Task #" + i);
            System.out.println(task);
            i++;
        }
    }
    private void searchByCategory(){
        if(!ensureTasksExist()){return;}
        Category category = inputHandler.readCategory();
        List<Task> tasks = taskService.findTasksByCategory(category);
        if(tasks.isEmpty()){
            System.out.println("No tasks found with this category.");
            return;
        }
        int i = 1;
        for (Task task : tasks) {
            System.out.println("Task #" + i);
            System.out.println(task);
            i++;
        }
    }
    private void searchByPriority(){
        if(!ensureTasksExist()){return;}
        Priority priority = inputHandler.readPriority();
        List<Task> tasks = taskService.findTasksByPriority(priority);
        if(tasks.isEmpty()){
            System.out.println("No tasks found with this priority.");
            return;
        }
        int i = 1;
        for (Task task : tasks) {
            System.out.println("Task #" + i);
            System.out.println(task);
            i++;
        }
    }
}
