package app;
import model.User;
public class Main{
    public static void main(String[] args) {
        User krishna = new User("Krishna", 18, "TIT", "N5 in japanese", java.time.LocalDate.now());
        System.out.println(krishna.toString());
    }
}