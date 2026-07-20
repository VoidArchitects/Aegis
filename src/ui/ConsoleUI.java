package ui;
import java.util.Scanner;
import model.User;
import service.UserService;
public class ConsoleUI{
    private final Scanner sc;
    private final UserService userService;
    private final User currentUser;
    public ConsoleUI(UserService userService){
        this.sc = new Scanner(System.in);
        this.userService = userService;
        this.currentUser  = userService.createDefaultUser();
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
    public int getChoice(){
        return sc.nextInt();
    }
    // ===============================START METHOD===============================
    public void start(){
        boolean running = true;
        while(running){
            displayMenu();
            int choice = getChoice();
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
        System.out.println(user.toString());
    }
    public void displayTaskManager(){
        System.out.println("Task Manager coming soon...");
    }
    public void displayDSATracker(){
        System.out.println("DSA Tracker coming soon...");
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
}