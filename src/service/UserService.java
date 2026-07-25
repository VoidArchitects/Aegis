package service;
// =============================================IMPORTS=================================
import model.User;

// ==============================================CLASS==================================
public class UserService {
    // =============================================METHODS=================================
    public User createDefaultUser(){
        return new User("Default", 20, "Default College", "Default Goal", java.time.LocalDate.now());
    }
}
