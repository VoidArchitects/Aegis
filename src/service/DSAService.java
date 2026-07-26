package service;
// =============================================IMPORTS=================================
import enums.Difficulty;
import enums.Topics;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Problem;
import storage.FileManager;

// ==============================================CLASS==================================
public class DSAService {
    // =============================================FIELDS==================================
    private final List<Problem> problems; 
    private final FileManager fileManager;

    // ===========================================CONSTRUCTORS==============================
    public DSAService() {
        this.fileManager = new FileManager();
        this.problems = new ArrayList<>(fileManager.loadQns());
    }

    // =========================================CORE METHODS================================
    public void addProblem(Problem problem){
        problems.add(problem);
        save();
    }
    public void removeProblem(int index){
        if(!isValidIndex(index)) {
            return;
        }
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
    //=========================================EDIT METHODS================================
    public void editProblemName(int index, String newName){
        Problem problem = getProblem(index);
        problem.setProblemName(newName);
        save();
    }
    public void editLeetcodeNo(int index, int newNo){
        Problem problem = getProblem(index);
        problem.setLeetcodeNo(newNo);
        save();
    }
    public void editDifficulty(int index, Difficulty newDifficulty){
        Problem problem = getProblem(index);
        problem.setDifficulty(newDifficulty);
        save();
    }
    public void editTopics(int index, List<Topics> newtopics){
        Problem problem = getProblem(index);
        problem.setTopics(newtopics);
        save();
    }
    public void editDateSolved(int index ,LocalDate newDate){
        Problem problem = getProblem(index);
        problem.setDateSolved(newDate);
        save();
    }
    public void editNotes(int index, String newNotes){
        Problem problem = getProblem(index);
        problem.setNotes(newNotes);
        save();
    }
    public void editTimeTaken(int index, int newTime){
        Problem problem = getProblem(index);
        problem.setTimeTakenInMinutes(newTime);
        save();
    }
    public void setFavoriteStatus(int index, boolean fav){
        Problem problem = getProblem(index);
        if(fav) problem.markFavorite();
        else problem.unmarkFavorite();
        save();
    }
    public void setRevisionStatus(int index, boolean rev){
        Problem problem = getProblem(index);
        if(rev) problem.markForRevision();
        else problem.unmarkForRevision();
        save();
    }
    // ========================================QUERIES METHODS==============================
    public List<Problem> getAllProblems(){   
        return List.copyOf(problems);
    }
    public int getProblemCount(){
        return problems.size();
    }
    public boolean hasProblems(){
        return !problems.isEmpty();
    }

    // =========================================SEARCH METHODS==============================
    public List<Problem> findByDifficulty(Difficulty difficulty){
        List<Problem> result = new ArrayList<>();
        for(Problem problem : problems){
            if(problem.getDifficulty() == (difficulty)){
                result.add(problem);
            }
        }
        return List.copyOf(result);
    }
    public List<Problem> findByTopic(Topics topic){
        List<Problem> result = new ArrayList<>();
        for(Problem problem : problems){
            if(problem.getTopics().contains(topic)){
                result.add(problem);
            }
        }
        return List.copyOf(result);
    }
    public List<Problem> getFavoriteProblems(){
        List<Problem> result = new ArrayList<>();
        for(Problem problem : problems){
            if(problem.isFavorite()){
                result.add(problem);
            }
        }
        return List.copyOf(result);
    }
    public List<Problem> getRevisionProblems(){
        List<Problem> result = new ArrayList<>();
        for(Problem problem : problems){
            if(problem.needsRevision()){
                result.add(problem);
            }
        }
        return List.copyOf(result);
    }
    //========================================STATISTICS METHODS============================
    public int countEasyProblems(){
        int count = 0;
        for(Problem problem : problems){
            if(problem.getDifficulty().equals(Difficulty.Easy)){
                count++;
            }
        }
        return count;
    }

    public int countMediumProblems(){
        int count = 0;
        for(Problem problem : problems){
            if(problem.getDifficulty().equals(Difficulty.Medium)){
                count++;
            }
        }
        return count;        
    }

    public int countHardProblems(){
        int count = 0;
        for(Problem problem : problems){
            if(problem.getDifficulty().equals(Difficulty.Hard)){
                count++;
            }
        }
        return count;        
    }

    // ========================================HELPER METHODS===============================
    private void save(){
        fileManager.saveQn(problems);
    }
    private Problem getProblem(int index){
        return problems.get(index-1);
    }
    private boolean isValidIndex(int index){
        return index >=1 && index <= problems.size();
    }
}