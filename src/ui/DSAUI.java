package ui;

import enums.Difficulty;
import enums.Topics;
import java.time.LocalDate;
import java.util.List;
import model.Problem;
import service.DSAService;

public class DSAUI {
    private final InputHandler inputHandler;
    private final DSAService dsaService;
    
    public DSAUI(DSAService dsaService,
        InputHandler inputHandler) {
        this.inputHandler = inputHandler;
        this.dsaService = dsaService;
    }
    
    // ==========================================DSA METHODS================================
    public void start(){
        boolean running = true;
        while(running){
            MenuRenderer.displayDSAMenu();
            int choice = inputHandler.readInt();
            switch(choice) {
                case 1 -> addProblem();
                case 2 -> removeProblem();
                case 3 -> editProblem();
                case 4 -> viewAllProblems();
                case 5 -> toggleFavorite();
                case 6 -> toggleRevision();
                case 7 -> searchByDiff();
                case 8 -> searchByTopic();
                case 0 -> {displayDSAExitMsg(); running = false;}
                default -> System.out.println("Invalid choice, please try again...");
            }
        }
    }
    private void addProblem(){
        System.out.println("Give Info about the problem you solved");

        System.out.println("Name :");
        String name = inputHandler.readLine();

        System.out.println("Leetcode No. #");
        int prbNo = inputHandler.readInt();

        System.out.println("Difficulty :");
        Difficulty difficulty = inputHandler.readDifficulty();

        System.out.println("Topics : ");
        List<Topics> topics = inputHandler.readTopics();

        System.out.println("Date of Soln :");
        LocalDate date = inputHandler.readDate();

        System.out.println("Notes :");
        String notes = inputHandler.readLine();

        System.out.println("Total time given in minutes :");
        int time = inputHandler.readInt();

        System.out.println("Favorite?");
        boolean favorite = inputHandler.readFavorite();

        System.out.println("Needs Revision?");
        boolean revision = inputHandler.readRevision();

        Problem newProblem = new Problem(name, prbNo, difficulty, topics, date, notes, time, favorite, revision);
        dsaService.addProblem(newProblem);
        System.out.println("Question added succesfully!");
    }
    private void removeProblem(){
        if(!ensureProblemsExist()){return;}
        System.out.println("Which problem would you like to remove?");
        viewAllProblems();
        System.out.println("Enter the index of the problem you would like to remove");
        int index = inputHandler.readInt();
        if(isValidProblemIndex(index)) {
            dsaService.removeProblem(index);
            System.out.println("Problem removed successfully!!");
        }
    }
    private void editProblem(){
        if(!ensureProblemsExist()){return;}
        System.out.println("Which Problem would you like to edit?");
        viewAllProblems();
        System.out.println("Enter the index of the problem you would like to edit");
        int index = inputHandler.readInt();
        if(isValidProblemIndex(index)){
            boolean running = true;
            while(running){
                System.out.println("""
                            ====================================
                                What would you like to edit?
                            ====================================
                                    1. Problem Name       
                                    2. Leetcode No.  
                                    3. Difficulty     
                                    4. Topics   
                                    5. Date Solved    
                                    6. Notes
                                    7. Time Taken
                                    8. Favorite status
                                    9. Revision status 

                                    0. back
                            ====================================
                        """);
                System.out.println("Enter your Choice");
                int choice = inputHandler.readInt();
                switch(choice){
                    case 1 -> {
                        System.out.print("New Problem name: ");
                        String newName = inputHandler.readLine();
                        dsaService.editProblemName(index, newName);
                        System.out.println("Problem updated successfully!");
                    }
                    case 2 -> {
                        System.out.print("New Leetcode No: ");
                        int newNo = inputHandler.readInt();
                        dsaService.editLeetcodeNo(index, newNo);
                        System.out.println("Problem updated successfully!");
                    }
                    case 3 -> {
                        System.out.print("New difficulty: ");                       
                        Difficulty newDifficulty = inputHandler.readDifficulty();
                        dsaService.editDifficulty(index, newDifficulty);
                        System.out.println("Problem updated successfully!");
                    }
                    case 4 -> {
                        System.out.print("New Topics: ");
                        List<Topics> topics = inputHandler.readTopics();
                        dsaService.editTopics(index, topics);
                        System.out.println("Problem updated successfully!");
                    }
                    case 5 -> {
                        System.out.print("New date: ");
                        LocalDate newDate = inputHandler.readDate();
                        dsaService.editDateSolved(index, newDate);
                        System.out.println("Problem updated successfully!");
                    }
                    case 6 -> {
                        System.out.println("New Notes");
                        String newNotes = inputHandler.readLine();
                        dsaService.editNotes(index, newNotes);
                        System.out.println("Problem updated successfully!");
                    }
                    case 7 -> {
                        System.out.println("New Time Taken");
                        int newTime = inputHandler.readInt();
                        dsaService.editTimeTaken(index, newTime);
                        System.out.println("Problem updated successfully!");
                    }
                    case 8 -> {
                        System.out.print("""
                            Input your choice from 
                                1. Set favorite
                                2. remove favorite
                                """);
                        int choiceX = inputHandler.readInt();
                        if(choiceX == 1)
                            dsaService.markAsFavorite(index);
                        else if(choiceX == 2)
                            dsaService.unmarkAsFavorite(index);
                        System.out.println("Problem updated successfully!");
                    }
                    case 9 -> {
                        System.out.print("""
                            Input your choice from 
                                1. Needs Revision
                                2. Doesnt need Revision
                                """);
                        int choiceX = inputHandler.readInt();
                        if(choiceX == 1)
                            dsaService.markForRevision(index);
                        else if(choiceX == 2)
                            dsaService.unmarkForRevision(index);
                        System.out.println("Problem updated successfully!");
                    }
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice, try again"); 
                }
            }
        }
    }
    private void viewAllProblems(){
        List<Problem> problems = dsaService.getAllProblems();
        if (problems.isEmpty()) {
            System.out.println("No Problems available.");
            return;
        }
        for (int i = 0; i < problems.size(); i++) {
            System.out.println("---------------- Problem "+(i + 1)+" ----------------");
            System.out.println(problems.get(i));
            System.out.println();
        }
    }
    private void toggleFavorite(){
        if(!ensureProblemsExist()){return;}
        System.out.println("Which problem's favorite status would you like to toggle?");
        viewAllProblems();
        System.out.println("Enter the index of the problem you would like to change");
        int index = inputHandler.readInt();
        if(isValidProblemIndex(index)) dsaService.toggleFavorite(index);
    }
    private void toggleRevision(){
        if(!ensureProblemsExist()){return;}
        System.out.println("Which problem's revision status would you like to toggle?");
        viewAllProblems();
        System.out.println("Enter the index of the problem you would like to change");
        int index = inputHandler.readInt();
        if(isValidProblemIndex(index)) dsaService.toggleRevision(index);
    }
    private void searchByDiff(){
        if(!ensureProblemsExist()){return;}
        Difficulty diff = inputHandler.readDifficulty();
        List<Problem> problems = dsaService.findByDifficulty(diff);
        if(problems.isEmpty()){
            System.out.println("No problems found with this Difficulty.");
            return;
        }
        int i = 1;
        for (Problem problem : problems) {
            System.out.println("Problem #"+ i);
            System.out.println(problem);
            i++;
        }
    }
    private void searchByTopic(){
        if(!ensureProblemsExist()){return;}
        Topics topic = inputHandler.readTopic();
        List<Problem> problems = dsaService.findByTopic(topic);
        if(problems.isEmpty()){
            System.out.println("No problems found with this topic.");
            return;
        }
        int i = 1;
        for (Problem problem : problems) {
            System.out.println("Problem #"+ i);
            System.out.println(problem);
            i++;
        }
    }
    private boolean isValidProblemIndex(int index){
        if (index < 1 || index > dsaService.getProblemCount()) {
            System.out.println("Invalid Index, please try again...");
            return false;
        }
        return true;
    }
    private boolean ensureProblemsExist(){
        if(!dsaService.hasProblems()){
            System.out.println("No Problems available");
            return false;
        }
        return true;
    }
    public void displayDSAExitMsg(){
        System.out.println("Exiting DSA menu...");
    }
}
