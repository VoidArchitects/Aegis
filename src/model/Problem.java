package model;

import enums.Difficulty;
import enums.Topic;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Problem implements Serializable {
    private static final long serialVersionUID = 1L;
    private String problemName;
    private int leetcodeNo;
    private Difficulty difficulty;
    private List<Topic> topics;
    private LocalDate dateSolved;
    private String notes;
    private int timeTakenInMinutes;
    private boolean favorite;
    private boolean needsRevision;

    // =================================CONSTRUCTORS============================
    public Problem(String problemName, int leetcodeNo, Difficulty difficulty, List<Topic> topics, 
                      LocalDate dateSolved, String notes, int timeTakenInMinutes, 
                      boolean favorite, boolean needsRevision) {
        this.problemName = problemName;
        this.leetcodeNo = leetcodeNo;
        this.difficulty = difficulty;
        this.topics = topics;
        this.dateSolved = dateSolved;
        this.notes = notes;
        this.timeTakenInMinutes = timeTakenInMinutes;
        this.favorite = favorite;
        this.needsRevision = needsRevision;
    }

    // =================================GETTERS=================================
    public String getProblemName() {
        return problemName;
    }

    public int getLeetcodeNo() {
        return leetcodeNo;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public List<Topic> getTopics() {
        return List.copyOf(topics);
    }

    public LocalDate getDateSolved() {
        return dateSolved;
    }

    public String getNotes() {
        return notes;
    }

    public int getTimeTakenInMinutes() {
        return timeTakenInMinutes;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public boolean needsRevision() {
        return needsRevision;
    }

    //==================================SETTERS=================================
    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public void setLeetcodeNo(int leetcodeNo) {
        this.leetcodeNo = leetcodeNo;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = List.copyOf(topics);
    }

    public void setDateSolved(LocalDate dateSolved) {
        this.dateSolved = dateSolved;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setTimeTakenInMinutes(int timeTakenInMinutes) {
        this.timeTakenInMinutes = timeTakenInMinutes;
    }

    public void markFavorite(){
        this.favorite = true;
    }

    public void unmarkFavorite(){
        this.favorite = false;
    }

    public void markForRevision(){
        this.needsRevision = true;
    }

    public void unmarkForRevision(){
        this.needsRevision = false;
    }

    // ========================================TO STRING===============================
    @Override
    public String toString(){
        return """
                =========================
                       DSA PROBLEM
                =========================
                Problem Name     :  %s
                Leetcode No      :  %s
                Difficulty       :  %s
                Topics           :  %s
                Date Solved      :  %s
                Notes            :  %s
                Total Time Taken :  %s
                Favorite         :  %s
                Needs Revision   :  %s
                ==========================
            """.formatted(
                problemName,
                leetcodeNo,
                difficulty,
                topics,
                dateSolved,
                notes,
                timeTakenInMinutes,
                favorite? "Yes" : "No",
                needsRevision? "Yes" : "No");        
    }
}
