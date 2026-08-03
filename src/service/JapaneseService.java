package service;

import enums.JapaneseType;
import java.util.ArrayList;
import java.util.List;
import model.Japanese;
import storage.FileManager;

public class JapaneseService {

    private final List<Japanese> items;
    private final FileManager fileManager;

    public JapaneseService() {
        this.fileManager = new FileManager();
        this.items = new ArrayList<>(fileManager.loadItems());
    }

    public void addItem(Japanese item){
        items.add(item);
        save();
    }
    public void removeItem(int index){
        if(!isValidIndex(index)) return;
        items.remove(index - 1);
        save();
    }
    public List<Japanese> getAllItems(){
        return List.copyOf(items);
    }
    public int getCountOfItems(){
        return items.size();
    }
    public boolean hasItems(){
        return !items.isEmpty();
    }
    //====================================================EDIT==============================================
    public void editItem(int index, String item){
        if(!isValidIndex(index)) return;
        getItem(index).setitem(item);
        save();
    }
    public void editType(int index, JapaneseType type){
        if(!isValidIndex(index)) return;
        getItem(index).setType(type);
        save();
    }
    public void editLesson(int index, int lesson){
        if(!isValidIndex(index)) return;
        getItem(index).setLesson(lesson);
        save();
    }
    public void editNotes(int index, String notes){
        if(!isValidIndex(index)) return;
        getItem(index).setNotes(notes);
        save();
    }
    public void editMastered(int index, boolean mastered){
        if(!isValidIndex(index)) return;
        getItem(index).setMastered(mastered);
        save();
    }
    public void editRevisionNeeded(int index, boolean revisionNeeded){
        if(!isValidIndex(index)) return;
        getItem(index).setRevisionNeeded(revisionNeeded);
        save();
    }
    //====================================================SEARCH==============================================
    public List<Japanese> findByType(JapaneseType type){
        List<Japanese> result = new ArrayList<>();
        for(Japanese item : items){
            if(item.getType() == type) result.add(item);
        }
        return List.copyOf(result);
    }
    public List<Japanese> findByMastered(boolean mastered){
        List<Japanese> result = new ArrayList<>();
        for(Japanese item : items){
            if(item.isMastered() == mastered) result.add(item);
        }
        return List.copyOf(result);
    }
    public List<Japanese> findByRevisionNeeded(boolean revisionNeeded){
        List<Japanese> result = new ArrayList<>();
        for(Japanese item : items){
            if(item.needsRevision() == revisionNeeded) result.add(item);
        }
        return List.copyOf(result);
    }
    public List<Japanese> findByLesson(int lesson){
        List<Japanese> result = new ArrayList<>();
        for(Japanese item : items){
            if(item.getLesson() == lesson) result.add(item);
        }
        return List.copyOf(result);
    }
    //====================================================UTIL==============================================
    public void markMastered(int index) {
        if(!isValidIndex(index)) return;
        getItem(index).setMastered(true);
        save();
    }
    public void unmarkMastered(int index) {
        if(!isValidIndex(index)) return;
        getItem(index).setMastered(false);
        save();
    }
    public void toggleMastered(int index){
        if(!isValidIndex(index)) return;

        if(getItem(index).isMastered()) getItem(index).setMastered(false);
        else getItem(index).setMastered(true);
        save();
    }

    public void markForRevision(int index) {
        if(!isValidIndex(index)) return;
        getItem(index).setRevisionNeeded(true);
        save();
    }

    public void unmarkForRevision(int index) {
        if(!isValidIndex(index)) return;
        getItem(index).setRevisionNeeded(false);
        save();
    }

    public void toggleRevision(int index){
        if(!isValidIndex(index)) return;

        if(getItem(index).needsRevision()) getItem(index).setRevisionNeeded(false);
        else getItem(index).setRevisionNeeded(true);
        save();
    }

    private void save(){
        fileManager.saveItems(items);
    }
    private boolean isValidIndex(int index){
        return index >=1 && index <= items.size();
    }
    private Japanese getItem(int index){
        return items.get(index-1);
    }
    
}