package storage;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Task;

public class FileManager {

    public void saveTasks(List<Task> tasks){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/data/tasks.dat"));
            out.writeObject(tasks);
            out.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Task> loadTasks(){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/data/tasks.dat"));
            List<Task> tasks = (List<Task>) in.readObject();
            in.close();
            return tasks;
        } catch (EOFException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}