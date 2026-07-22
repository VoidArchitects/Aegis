package app;
import service.TaskService;
import service.UserService;
import ui.ConsoleUI;
public class Main{
    public static void main(String[] args) {
        //User krishna = new User("Krishna", 18, "TIT", "N5 in japanese", java.time.LocalDate.now());
        UserService userService = new UserService();
        TaskService taskService = new TaskService();
        ConsoleUI ui = new ConsoleUI(userService, taskService);
        ui.start();
        
    }
}