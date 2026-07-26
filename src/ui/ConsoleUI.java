package ui;
// =============================================IMPORTS=================================
import enums.Category;
import enums.Difficulty;
import enums.Priority;
import enums.Topic.Topics;
import java.time.LocalDate;
import java.util.List;
import model.Problem;
import model.Task;
import model.User;
import service.DSAService;
import service.TaskService;
import service.UserService;

// ==============================================CLASS==================================
public class ConsoleUI{
    // =============================================FIELDS==================================
    private final User currentUser;
    private final UserService userService;
    private final TaskService taskService;
    private final DSAService dsaService;
    private final InputHandler inputHandler;

    // ===========================================CONSTRUCTORS==============================
    public ConsoleUI(UserService userService,
                 TaskService taskService,
                DSAService dsaService,
            InputHandler inputHandler){
        this.userService = userService;
        this.taskService = taskService;
        this.dsaService = dsaService;
        this.inputHandler = inputHandler;
        this.currentUser  = this.userService.createDefaultUser();
    }

    // ===========================================CORE METHODS==============================
    public void start(){
        boolean running = true;
        while(running){
            MenuRenderer.displayMenu();
            int choice = inputHandler.readInt();
            switch(choice){
                case 1 -> displayUserProfile(currentUser);
                case 2 -> displayTaskManager();
                case 3 -> displayDSATracker();
                case 4 -> displayGymTracker();
                case 5 -> displayJapaneseTracker();
                case 0 -> { displayExitMessage(); running = false; }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // =========================================DISPLAY METHODS=============================
    public void displayUserProfile(User user){
        System.out.println(user);
    }
    public void displayExitMessage(){
        System.out.println("Thank you for using Project Aegis. Goodbye!");
    }
    public void displayTaskExitMsg(){
        System.out.println("Exiting task menu...");
    }
    public void displayDSAExitMsg(){
        System.out.println("Exiting DSA menu...");
    }
    public void displayGymTracker(){
        System.out.println("Gym Tracker coming soon...");
    }
    public void displayJapaneseTracker(){
        System.out.println("Japanese Tracker coming soon...");
    }

    // =======================================TASK MANAGER METHODS==========================
    public void displayTaskManager(){
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
                case 0 -> {displayTaskExitMsg(); running = false;}
                default -> System.out.println("Invalid choice, please try again...");
            }
        }
    }
    public void addTask(){
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
    public void removeTask(){
        if(!ensureTasksExist()){return;}
        System.out.println("Which task would you like to remove?");
        viewAllTasks();
        System.out.println("Enter the index of the task you would like to remove");
        int index = inputHandler.readInt();
        if(isValidTaskIndex(index)) taskService.removeTask(index);  
    }
    public void markTaskAsCompleted(){
        if(!ensureTasksExist()){return;}
        System.out.println("Which task would you like to mark?");
        viewAllTasks();
        System.out.println("Enter the index of the task you would like to mark");
        int index = inputHandler.readInt();
        if(isValidTaskIndex(index)) taskService.markTaskAsCompleted(index); 
    }
    public void markTaskAsIncomplete(){
        if(!ensureTasksExist()){return;}
        System.out.println("Which task would you like to mark?");
        viewAllTasks();
        System.out.println("Enter the index of the task you would like to mark");
        int index = inputHandler.readInt();
        if(isValidTaskIndex(index)) taskService.markTaskAsNotCompleted(index); 
    }
    public void editTask(){
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
    public void viewAllTasks(){
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

    // ==========================================DSA METHODS================================
    public void displayDSATracker(){
        boolean running = true;
        while(running){
            MenuRenderer.displayDSAMenu();
            int choice = inputHandler.readInt();
            switch(choice) {
                case 1 -> addProblem();
                case 2 -> removeProblem();
                case 3 -> editProblem();
                case 4 -> viewAllProblems();
                case 5 -> markFavorite();
                case 6 -> markRevision();
                case 7 -> searchByDiff();
                case 8 -> searchByTopic();
                case 0 -> {displayDSAExitMsg(); running = false;}
                default -> System.out.println("Invalid choice, please try again...");
            }
        }
    }
    public void addProblem(){
        System.out.println("Give Info about the problem you solved");

        System.out.println("Name :");
        String name = inputHandler.readLine();

        System.out.println("Leetcode No. #");
        int prbNo = inputHandler.readInt();

        System.out.println("Difficulty :");
        Difficulty difficulty = inputHandler.readDifficulty();

        System.out.println("Topics : ");
        List<Topics> topics = inputHandler.readTopics();

        System.out.println("Date of Soln :");
        LocalDate date = inputHandler.readDate();

        System.out.println("Notes :");
        String notes = inputHandler.readLine();

        System.out.println("Total time given in minutes :");
        int time = inputHandler.readInt();

        System.out.println("Favorite?");
        boolean favorite = inputHandler.readFavorite();

        System.out.println("Needs Revision?");
        boolean revision = inputHandler.readRevision();

        Problem newproblem = new Problem(name, prbNo, difficulty, topics, date, notes, time, favorite, revision);
        dsaService.addProblem(newproblem);
        System.out.println("Question added succesfully!");
    }
    public void removeProblem(){

    }
    public void editProblem(){

    }
    public void viewAllProblems(){

    }
    public void markFavorite(){

    }
    public void markRevision(){

    }
    public void searchByDiff(){

    }
    public void searchByTopic(){

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
}