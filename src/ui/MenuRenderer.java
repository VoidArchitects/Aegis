package ui;

public class MenuRenderer {
    public static void displayMenu(){
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
    public static void displayTaskManagerMenu(){
        System.out.println( """
                ===========================================
                            TASK MANAGER
                ===========================================

                1. Add Task
                2. Remove Task
                3. Mark Task as Completed
                4. Mark Task as Not Completed
                5. View All Tasks
                6. Edit Task
                7. Search Tasks by Title
                8. Search Tasks by Category
                9. Search Tasks by Priority

                0. Back to Main Menu
                ===========================================

                Enter Your Choice: 
        """ );
    }
    public static void displayDSAMenu(){
        System.out.println(
            """
                ===========================================
                            DSA MANAGER
                ===========================================

                1. Add Problem
                2. Remove Problem
                3. Edit Problem
                4. View All Problems
                5. Mark Favorite
                6. Mark Revision
                7. Search problems by Difficulty
                8. Search problems by Topic

                0. Back to Main Menu
                ===========================================

                Enter Your Choice:                     
            """
        );
    }
}