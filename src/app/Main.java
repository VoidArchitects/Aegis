package app;
import service.UserService;
import ui.ConsoleUI;
public class Main{
    public static void main(String[] args) {
        //User krishna = new User("Krishna", 18, "TIT", "N5 in japanese", java.time.LocalDate.now());
        UserService userService = new UserService();
        ConsoleUI ui = new ConsoleUI(userService);
        ui.start();
        
    }
}