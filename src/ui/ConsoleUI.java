package ui;
import enums.Category;
import enums.Difficulty;
import enums.Priority;
import enums.Topic.Topics;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Problem;
import model.Task;
import model.User;
import service.DSAService;
import service.TaskService;
import service.UserService;
public class ConsoleUI{
    private final Scanner sc;
    private final User currentUser;
    private final UserService userService;
    private final TaskService taskService;
    private final DSAService dsaService;
    public ConsoleUI(UserService userService,
                 TaskService taskService,
                DSAService dsaService){
        this.sc = new Scanner(System.in);
        this.userService = userService;
        this.taskService = taskService;
        this.dsaService = dsaService;
        this.currentUser  = this.userService.createDefaultUser();
    }
    public void displayMenu(){
        System.out.println( """
                ===========================================
                            PROJECT AEGIS
                ===========================================

                1. User Profile
                2. Task Manager
                3. DSA Tracker
                4. Gym Tracker
                5. Japanese Tracker

                0. Exit
                ===========================================

                Enter Your Choice: 
        """ );
    }
    // ===============================START METHOD===============================
    public void start(){
        boolean running = true;
        while(running){
            displayMenu();
            int choice = readInt();
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
    // ===============================DISPLAY METHODS===============================
    public void displayUserProfile(User user){
        System.out.println(user);
    }
    public void displayTaskManager(){
        boolean running = true;
        while(running){
            displayTaskManagerMenu();
            int choice = readInt();
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
    public void displayDSATracker(){
        boolean running = true;
        while(running){
            displayDSAMenu();
            int choice = readInt();
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
    public void displayGymTracker(){
        System.out.println("Gym Tracker coming soon...");
    }
    public void displayJapaneseTracker(){
        System.out.println("Japanese Tracker coming soon...");
    }
    public void displayExitMessage(){
        System.out.println("Thank you for using Project Aegis. Goodbye!");
    }
    // =================================TASK MANAGER METHODS=================================
    public void displayTaskManagerMenu(){
        System.out.println( """
                ===========================================
                            TASK MANAGER
                ===========================================

                1. Add Task
                2. Remove Task
                3. Mark Task as Completed
                4. Mark Task as Not Completed
                5. View All Tasks
                6. Edit Task
                7. Search Tasks by Title
                8. Search Tasks by Category
                9. Search Tasks by Priority

                0. Back to Main Menu
                ===========================================

                Enter Your Choice: 
        """ );
    }
    public void addTask(){
        System.out.println(
            "Give info about the task you want to add:"
        );

        System.out.print(
            "Title: "
        );
        String title = sc.nextLine();
        System.out.println("\n");

        System.out.print(
            "Description: "
        );
        String description = sc.nextLine();
        System.out.println("\n");

        Category category = readCategory();
        System.out.println("\n");

        Priority priority = readPriority();
        System.out.println("\n");

        LocalDate deadline = readDeadline();

        Task newTask = new Task(title, description, category, priority, deadline);
        taskService.addTask(newTask);
        System.out.println("Task added successfully!");
    }
    public void removeTask(){
        if(!ensureTasksExist()){return;}
        System.out.println("Which task would you like to remove?");
        viewAllTasks();
        System.out.println("Enter the index of the task you would like to remove");
        int index = readInt();
        if(isValidTaskIndex(index)) taskService.removeTask(index);  
    }
    public void markTaskAsCompleted(){
        if(!ensureTasksExist()){return;}
        System.out.println("Which task would you like to mark?");
        viewAllTasks();
        System.out.println("Enter the index of the task you would like to mark");
        int index = readInt();
        if(isValidTaskIndex(index)) taskService.markTaskAsCompleted(index); 
    }
    public void markTaskAsIncomplete(){
        if(!ensureTasksExist()){return;}
        System.out.println("Which task would you like to mark?");
        viewAllTasks();
        System.out.println("Enter the index of the task you would like to mark");
        int index = readInt();
        if(isValidTaskIndex(index)) taskService.markTaskAsNotCompleted(index); 
    }
    public void editTask(){
        if(!ensureTasksExist()){return;}
        System.out.println("Which task would you like to edit?");
        viewAllTasks();
        System.out.println("Enter the index of the task you would like to edit");
        int index = readInt();
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
                int choice = readInt();
                switch(choice){
                    case 1 -> {
                        System.out.print("New title: ");
                        String title = sc.nextLine();
                        taskService.editTitle(index, title);
                        System.out.println("Task updated successfully!");
                    }
                    case 2 -> {
                        System.out.print("New description: ");
                        String description = sc.nextLine();
                        taskService.editDescription(index, description);
                        System.out.println("Task updated successfully!");
                    }
                    case 3 -> {
                        System.out.print("New category: ");                       
                        Category category = readCategory();
                        taskService.editCategory(index, category);
                        System.out.println("Task updated successfully!");
                    }
                    case 4 -> {
                        System.out.print("New priority: ");
                        Priority priority = readPriority();
                        taskService.editPriority(index, priority);
                        System.out.println("Task updated successfully!");
                    }
                    case 5 -> {
                        System.out.print("New deadline: ");
                        LocalDate deadline = readDeadline();
                        taskService.editDeadline(index, deadline);
                        System.out.println("Task updated successfully!");
                    }
                    case 6 -> {
                        System.out.print("""
                            Input your choice from 
                                1. Complete
                                2. Incomplete
                                """);
                        int choiceX = readInt();
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
    public void displayTaskExitMsg(){
        System.out.println("Exiting task menu...");
    }
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
    private Category readCategory() {
        while (true) {
            System.out.println("Choose Category:");
            for (int i = 0; i < Category.values().length; i++) {
                System.out.println((i + 1) + ". " + Category.values()[i]);
            }
            int choice = readInt();
            if (choice >= 1 && choice <= Category.values().length) {
                return Category.values()[choice - 1];
            }
            System.out.println("Invalid category. Try again.");
        }
    }
    private Priority readPriority() {
        while (true) {
            System.out.println("Choose Priority:");
            for (int i = 0; i < Priority.values().length; i++) {
                System.out.println((i + 1) + ". " + Priority.values()[i]);
            }
            int choice = readInt();
            if (choice >= 1 && choice <= Priority.values().length) {
                return Priority.values()[choice - 1];
            }
            System.out.println("Invalid priority. Try again.");
        }
    }
    private LocalDate readDeadline() {
        while (true) {
            try {
                System.out.print("Deadline (yyyy-MM-dd): ");
                return LocalDate.parse(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date. Use yyyy-MM-dd.");
            }
        }
    }
    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    // ========================================DSA Interface==================================
    public void displayDSAMenu(){
        System.out.println(
            """
                ===========================================
                            DSA MANAGER
                ===========================================

                1. Add Problem
                2. Remove Problem
                3. Edit Problem
                4. View All Problems
                5. Mark Favorite
                6. Mark Revision
                7. Search problems by Difficulty
                8. Search problems by Topic

                0. Back to Main Menu
                ===========================================

                Enter Your Choice:                     
            """
        );
    }
    // =========================================DSA METHODS========================================
    public void addProblem(){
        System.out.println("Give Info about the problem you solved");

        System.out.println("Name :");
        String name = sc.nextLine();

        System.out.println("Leetcode No. #");
        int prbNo = readInt();

        System.out.println("Difficulty :");
        Difficulty difficulty = readDifficulty();

        System.out.println("Topics : ");
        List<Topics> topics = readTopics();

        System.out.println("Date of Soln :");
        LocalDate date = readDate();

        System.out.println("Notes :");
        String notes = sc.nextLine();

        System.out.println("Total time given in minutes :");
        int time = readInt();

        System.out.println("Favorite?");
        boolean favorite = readFavorite();

        System.out.println("Needs Revision?");
        boolean revision = readRevision();

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
    public void displayDSAExitMsg(){

    }
    // ==========================================DSA HELPERS====================================
    private Difficulty readDifficulty() {
        while (true) {
            System.out.println("Choose Difficulty:");
            for (int i = 0; i < Difficulty.values().length; i++) {
                System.out.println((i + 1) + ". " + Difficulty.values()[i]);
            }
            int choice = readInt();
            if (choice >= 1 && choice <= Difficulty.values().length) {
                return Difficulty.values()[choice - 1];
            }
            System.out.println("Invalid Difficulty. Try again.");
        }
    }
    private List<Topics> readTopics() {
        List<Topics> result = new ArrayList<>();
        while (true) {
            System.out.println("Choose Topics:");
            for(int i = 0 ; i < Topics.values().length ; i++){
                System.out.println((i+1) + "." + Topics.values()[i]);
            }
            System.out.println("0. Completed topic selection");
            int choice = readInt();
            if (choice >= 1 && choice <= Topics.values().length) {
                result.add(Topics.values()[choice-1]);
            }
            else if(choice > Topics.values().length){
                System.out.println("Invalid choice, try again");
            }
            else{
                return result;
            }
        }
    }
    private LocalDate readDate(){
        while (true) {
            try {
                System.out.print("Date of Soln (yyyy-MM-dd): ");
                return LocalDate.parse(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date. Use yyyy-MM-dd.");
            }
        }
    }
    private boolean readFavorite(){
        System.out.println("Mark as favorite?");
        System.out.println("Yes? No?");
        String fav = sc.nextLine();
        return fav.trim().substring(0, 2).equalsIgnoreCase("yes") || fav.trim().substring(0, 0).equals("y");
    }
    private boolean readRevision(){
        System.out.println("Mark as needs Revision?");
        System.out.println("Yes? No?");
        String rev = sc.nextLine();
        return rev.trim().substring(0, 2).equalsIgnoreCase("yes") || rev.trim().substring(0, 0).equals("y");
    }
}