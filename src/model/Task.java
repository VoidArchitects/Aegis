package model;

import enums.Category;
import enums.Priority;
import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable{
    private String title;
    private String description;
    private Category category;
    private Priority priority;
    private LocalDate deadline;
    private boolean completed;
    private static final long serialVersionUID = 1L;

    public Task(String title, String description, Category category, Priority priority, LocalDate deadline) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.deadline = deadline;
        this.completed = false;
    }

// =================================GETTERS=================================

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public Priority getPriority() {
        return priority;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean isCompleted() {
        return completed;
    }

    // ================================SETTERS=================================
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void markComplete() {
        this.completed = true;
    }
    public void markIncomplete() {
        this.completed = false;
    }

    // ================================TO STRING=================================
    @Override
    public String toString(){
        return """
                    =========================
                              TASK
                    =========================
                    Title       : %s
                    Description : %s
                    Category    : %s
                    Priority    : %s
                    Deadline    : %s
                    Completed   : %s
                    ==========================
            """.formatted(title, description, category, priority, deadline, completed? "Yes" : "No");
    }
}