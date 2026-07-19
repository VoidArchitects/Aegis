package model;
// =============================================IMPORTS===============================
import java.time.LocalDate;
// ==============================================CLASS===============================
public class User{
    private String name;
    private int age;
    private String college;
    private String goal;
    private LocalDate joinDate;

    // =============================CONSTRUCTOR===============================

    public User(String name, int age, String college, String goal, LocalDate joinDate) {
        this.name = name;
        this.age = Math.max(age,0);
        this.college = college;
        this.goal = goal;
        this.joinDate = joinDate;
    }

    // ===============================GETTERS===============================

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getCollege(){
        return college;
    }
    public String getGoal(){
        return goal;
    }
    public LocalDate getJoinDate() {
        return joinDate;
    }

    // ===============================SETTERS===============================

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = Math.max(age,0);
    }
    public void setCollege(String college){
        this.college = college;
    }
    public void setGoal(String goal){
        this.goal = goal;
    }
    public void setJoinDate(LocalDate joinDate){
        this.joinDate = joinDate;
    }

    // ===============================METHODS===============================

    @Override
    public String toString(){
        return """
            ========== USER ==========
            Name      : %s
            Age       : %d
            College   : %s
            Goal      : %s
            Joined On : %s
            ==========================
            """.formatted(name, age, college, goal, joinDate);
    }
}