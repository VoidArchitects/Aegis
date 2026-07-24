package service;
import enums.Difficulty;
import enums.Topic;
import java.util.ArrayList;
import java.util.List;
import model.Problem;
import storage.FileManager;
public class DSAService {
    private final List<Problem> problems; 
    private final FileManager fileManager;
    public DSAService() {
        this.fileManager = new FileManager();
        this.problems = new ArrayList<>(fileManager.loadQns());
    
    }
    private void save(){
        fileManager.saveQn(problems);
    }
    // ===================================TASK MANAGEMENT METHODS=======================================
    public void addProblem(Problem problem){
        problems.add(problem);
        save();
    }
    public void removeProblem(int index){
        problems.remove(index - 1);
        save();
    }
    public void markAsFavorite(int index){
        problems.get(index -1).markFavorite();
        save();
    }
    public void unmarkAsFavorite(int index){
        problems.get(index -1).unmarkFavorite();
        save();
    }
    public void markForRevision(int index){
        problems.get(index -1).markForRevision();
        save();
    }
    public void unmarkForRevision(int index){
        problems.get(index -1).unmarkForRevision();
        save();
    }
    // ========================================QUERIES METHODS===========================================
    public List<Problem> getAllProblems(){   
        return List.copyOf(problems);
    }
    public int getProblemCount(){
        return problems.size();
    }
    public boolean hasProblems(){
        return !problems.isEmpty();
    }
    // =========================================SEARCH METHODS=============================================
    public List<Problem> findByDifficulty(Difficulty difficulty){
        List<Problem> result = new ArrayList<>();
        for(Problem problem : problems){
            if(problem.getDifficulty() == (difficulty)){
                result.add(problem);
            }
        }
        return result;
    }
    public List<Problem> findByTopic(Topic topic){
        List<Problem> result = new ArrayList<>();
        for(Problem problem : problems){
            if(problem.getTopics().contains(topic)){
                result.add(problem);
            }
        }
        return result;
    }
    public List<Problem> getFavoriteProblems(){
        List<Problem> result = new ArrayList<>();
        for(Problem problem : problems){
            if(problem.isFavorite()){
                result.add(problem);
            }
        }
        return result;
    }
    public List<Problem> getRevisionProblems(){
        List<Problem> result = new ArrayList<>();
        for(Problem problem : problems){
            if(problem.needsRevision()){
                result.add(problem);
            }
        }
        return result;
    }
}