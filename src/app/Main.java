package app;
// =============================================IMPORTS=================================
import service.DSAService;
import service.TaskService;
import service.UserService;
import ui.ConsoleUI;
import ui.InputHandler;

// ==============================================CLASS==================================
public class Main{
    // ===========================================MAIN METHOD===============================
    public static void main(String[] args) {
        //User krishna = new User("Krishna", 18, "TIT", "N5 in japanese", java.time.LocalDate.now());
        UserService userService = new UserService();
        TaskService taskService = new TaskService();
        DSAService dsaService = new DSAService();
        InputHandler inputHandler = new InputHandler();
        ConsoleUI ui = new ConsoleUI(userService, taskService, dsaService, inputHandler);
        ui.start();
    }
}