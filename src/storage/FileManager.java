package storage;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Problem;
import model.Task;

public class FileManager {
    private static final String TASK_FILE = "src/data/tasks.dat";
    private static final String DSA_FILE = "src/data/problems.dat";

    public void saveTasks(List<Task> tasks){
        try {
           try (ObjectOutputStream out =
            new ObjectOutputStream(new FileOutputStream(TASK_FILE))) {
                out.writeObject(tasks);
            }      
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public List<Task> loadTasks(){
        File file = new File(TASK_FILE);

        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }
        try {
            try (ObjectInputStream in =
            new ObjectInputStream(new FileInputStream(TASK_FILE))) {
                return (List<Task>) in.readObject();
            }
        } catch (EOFException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return new ArrayList<>();
    }
    public void saveQn(List<Problem> problems){
        try {
           try (ObjectOutputStream out =
            new ObjectOutputStream(new FileOutputStream(DSA_FILE))) {
                out.writeObject(problems);
            }      
        } catch (IOException e) {
            System.out.println("Error loading questions: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public List<Problem> loadQns(){
        File file = new File(DSA_FILE);

        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }
        try {
            try (ObjectInputStream in =
            new ObjectInputStream(new FileInputStream(DSA_FILE))) {
                return (List<Problem>) in.readObject();
            }
        } catch (EOFException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading questions: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}