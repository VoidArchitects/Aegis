package ui;

import enums.*;
import enums.Topic.Topics;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private final Scanner sc;

    public InputHandler() {
        sc = new Scanner(System.in);
    }
    // =======================================INPUT HELPER METHODS==========================
    public Category readCategory() {
        while (true) {
            System.out.println("Choose Category:");
            for (int i = 0; i < Category.values().length; i++) {
                System.out.println((i + 1) + ". " + Category.values()[i]);
            }
            int choice = readInt();
            if (choice >= 1 && choice <= Category.values().length) {
                return Category.values()[choice - 1];
            }
            System.out.println("Invalid category. Try again.");
        }
    }
    public Priority readPriority() {
        while (true) {
            System.out.println("Choose Priority:");
            for (int i = 0; i < Priority.values().length; i++) {
                System.out.println((i + 1) + ". " + Priority.values()[i]);
            }
            int choice = readInt();
            if (choice >= 1 && choice <= Priority.values().length) {
                return Priority.values()[choice - 1];
            }
            System.out.println("Invalid priority. Try again.");
        }
    }
    public LocalDate readDeadline() {
        while (true) {
            try {
                System.out.print("Deadline (yyyy-MM-dd): ");
                return LocalDate.parse(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date. Use yyyy-MM-dd.");
            }
        }
    }
    public int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    public Difficulty readDifficulty() {
        while (true) {
            System.out.println("Choose Difficulty:");
            for (int i = 0; i < Difficulty.values().length; i++) {
                System.out.println((i + 1) + ". " + Difficulty.values()[i]);
            }
            int choice = readInt();
            if (choice >= 1 && choice <= Difficulty.values().length) {
                return Difficulty.values()[choice - 1];
            }
            System.out.println("Invalid Difficulty. Try again.");
        }
    }
    public List<Topics> readTopics() {
        List<Topics> result = new ArrayList<>();
        while (true) {
            System.out.println("Choose Topics:");
            for(int i = 0 ; i < Topics.values().length ; i++){
                System.out.println((i+1) + "." + Topics.values()[i]);
            }
            System.out.println("0. Completed topic selection");
            int choice = readInt();
            if (choice >= 1 && choice <= Topics.values().length) {
                result.add(Topics.values()[choice-1]);
            }
            else if(choice > Topics.values().length){
                System.out.println("Invalid choice, try again");
            }
            else{
                return result;
            }
        }
    }
    public LocalDate readDate(){
        while (true) {
            try {
                System.out.print("Date of Soln (yyyy-MM-dd): ");
                return LocalDate.parse(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date. Use yyyy-MM-dd.");
            }
        }
    }
    public boolean readFavorite(){
        System.out.println("Mark as favorite?");
        System.out.println("Yes? No?");
        String fav = sc.nextLine();
        return fav.trim().substring(0, 2).equalsIgnoreCase("yes") || fav.trim().substring(0, 0).equals("y");
    }
    public boolean readRevision(){
        System.out.println("Mark as needs Revision?");
        System.out.println("Yes? No?");
        String rev = sc.nextLine();
        return rev.trim().substring(0, 2).equalsIgnoreCase("yes") || rev.trim().substring(0, 0).equals("y");
    }
    public String readLine(){
        return sc.nextLine();
    }
}