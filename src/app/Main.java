package app;
// =============================================IMPORTS=================================
import service.*;
import ui.*;

// ==============================================CLASS==================================
public class Main{
    // ===========================================MAIN METHOD===============================
    public static void main(String[] args) {
        //User krishna = new User("Krishna", 18, "TIT", "N5 in japanese", java.time.LocalDate.now());
        UserService userService = new UserService();
        TaskService taskService = new TaskService();
        DSAService dsaService = new DSAService();
        JapaneseService japaneseService = new JapaneseService();
        InputHandler inputHandler = new InputHandler();
        JapaneseUI japaneseUI = new JapaneseUI(japaneseService, inputHandler);
        DSAUI dsaUI = new DSAUI(dsaService, inputHandler);
        TaskUI taskUI = new TaskUI(inputHandler, taskService);
        ConsoleUI ui = new ConsoleUI(userService, dsaUI, taskUI,japaneseUI, inputHandler);
        ui.start();
    }
}