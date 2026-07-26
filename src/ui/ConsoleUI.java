package ui;
import model.User;
import service.UserService;

public class ConsoleUI{
    // =============================================FIELDS==================================
    private final User currentUser;
    private final UserService userService;
    private final TaskUI taskUI;
    private final DSAUI dsaUI;
    private final InputHandler inputHandler;

    // ===========================================CONSTRUCTOR==============================
    public ConsoleUI(UserService userService,
                DSAUI dsaUI,
            TaskUI taskUI,
            InputHandler inputHandler){
        this.dsaUI = dsaUI;
        this.userService = userService;
        this.taskUI = taskUI;
        this.inputHandler = inputHandler;
        this.currentUser  = this.userService.createDefaultUser();
    }

    // ===========================================CORE METHOD=============================
    public void start(){
        boolean running = true;
        while(running){
            MenuRenderer.displayMenu();
            int choice = inputHandler.readInt();
            switch(choice){
                case 1 -> displayUserProfile(currentUser);
                case 2 -> taskUI.start();
                case 3 -> dsaUI.start();
                case 4 -> displayGymTracker();
                case 5 -> displayJapaneseTracker();
                case 0 -> { displayExitMessage(); running = false; }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // =========================================DISPLAY METHODS=============================
    public void displayUserProfile(User user){
        System.out.println(currentUser);
    }
    public void displayExitMessage(){
        System.out.println("Thank you for using Project Aegis. Goodbye!");
    }
    public void displayGymTracker(){
        System.out.println("Gym Tracker coming soon...");
    }
    public void displayJapaneseTracker(){
        System.out.println("Japanese Tracker coming soon...");
    }
}