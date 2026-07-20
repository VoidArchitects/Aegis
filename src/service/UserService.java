package service;
import model.User;

public class UserService {
    public User createDefaultUser(){
        return new User("Default", 20, "Default College", "Default Goal", java.time.LocalDate.now());
    }
}
