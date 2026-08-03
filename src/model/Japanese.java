package model;
import enums.JapaneseType;
import java.io.Serializable;
public class Japanese implements Serializable{
    private String item = "";   
    private JapaneseType type;    
    private int lesson;
    private boolean mastered;
    private boolean revisionNeeded;
    private String notes;
    private static final long serialVersionUID = 1L;

    public Japanese(
            String item,
            JapaneseType type,
            int lesson,
            boolean mastered,
            boolean revisionNeeded,
            String notes) 
    {
        this.item = item;
        this.type = type;
        this.lesson = lesson;
        this.mastered = mastered;
        this.revisionNeeded = revisionNeeded;
        this.notes = notes;
    }

    //=======================================getters==================================
    public String getitem(){
        return item;
    }
    public JapaneseType getType(){
        return type;
    }
    public int getLesson(){
        return lesson;
    }
    public boolean isMastered(){
        return mastered;
    }
    public boolean needsRevision(){
        return revisionNeeded;
    }
    public String getNotes(){
        return notes;
    }
    //====================================setters======================================
    public void setitem(String item) {
        this.item = item;
    }

    public void setType(JapaneseType type) {
        this.type = type;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    public void setMastered(boolean mastered) {
        this.mastered = mastered;
    }

    public void setRevisionNeeded(boolean revisionNeeded) {
        this.revisionNeeded = revisionNeeded;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    //=================================to string====================================
    @Override
    public String toString(){
        return("""
                =========================
                    JAPANESE PROGRESS
                =========================
                item             :  %s
                Type             :  %s
                Lesson           :  %d
                Mastered         :  %s
                Needs Revision   :  %s
                Notes            :  %s
                ==========================
            """.formatted(
                item,
                type,
                lesson,
                mastered? "Yes":"No",
                revisionNeeded? "Yes":"No",
                notes));
    }
}
