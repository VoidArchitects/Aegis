package ui;

import enums.JapaneseType;
import java.util.List;
import model.Japanese;
import service.JapaneseService;

public class JapaneseUI {

    // ============================================== FIELDS ==============================================
    private final JapaneseService japaneseService;
    private final InputHandler inputHandler;

    // ============================================ CONSTRUCTOR ==========================================
    public JapaneseUI(JapaneseService japaneseService,
                      InputHandler inputHandler) {
        this.japaneseService = japaneseService;
        this.inputHandler = inputHandler;
    }

    // ============================================== CORE ===============================================

    public void start() {
        boolean running = true;
        while (running) {
            displayJapaneseMenu();
            int choice = inputHandler.readInt();
            switch (choice) {
                case 1 -> addJapanese();
                case 2 -> editJapanese();
                case 3 -> removeJapanese();
                case 4 -> viewAllJapanese();
                case 5 -> searchByType();
                case 6 -> searchByMastered();
                case 7 -> searchByRevision();
                case 8 -> searchByLesson();
                case 0 -> {
                    displayJapaneseExitMsg();
                    running = false;
                }
                default -> System.out.println("Invalid choice, please try again...");
            }
        }
    }
    // =========================================== MENU ================================================

    private void displayJapaneseMenu() {
        System.out.println("""
                ====================================
                       JAPANESE TRACKER
                ====================================
                    1. Add Japanese
                    2. Edit Japanese
                    3. Remove Japanese
                    4. View All Japanese
                    5. Search by Type
                    6. Search by Mastered Status
                    7. Search by Revision Status
                    8. Search by Lesson
                    0. Exit
                ====================================
                """);

        System.out.print("Enter your choice: ");
    }

    // =========================================== ADD =================================================
    public void addJapanese() {

        System.out.println("""
                ====================================
                    ADD JAPANESE ITEM
                ====================================
                """);

        System.out.print("Name: ");
        String name = inputHandler.readLine();

        JapaneseType type = inputHandler.readJapaneseType();

        System.out.print("Lesson: ");
        int lesson = inputHandler.readInt();

        System.out.print("Mastered? (true/false): ");
        boolean mastered = inputHandler.readBoolean();

        System.out.print("Needs Revision? (true/false): ");
        boolean revisionNeeded = inputHandler.readBoolean();

        System.out.print("Notes: ");
        String notes = inputHandler.readLine();

        Japanese japanese = new Japanese(
                name,
                type,
                lesson,
                mastered,
                revisionNeeded,
                notes
        );
        japaneseService.addItem(japanese);
        System.out.println("Japanese item added successfully!");
    }

    // =========================================== EDIT =================================================
    public void editJapanese() {
        if (!ensureItemsExist()) return;
        viewAllJapanese();
        System.out.print("Enter the index of the item you want to edit: ");
        int index = inputHandler.readInt();
        if (!isValidIndex(index)) return;
        boolean running = true;
        while (running) {
            System.out.println("""
                    ====================================
                       WHAT WOULD YOU LIKE TO EDIT?
                    ====================================
                        1. Name
                        2. Type
                        3. Lesson
                        4. Mastered Status
                        5. Revision Status
                        6. Notes
                        0. Back
                    ====================================
                    """);
            System.out.print("Enter your choice: ");
            int choice = inputHandler.readInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("New name: ");
                    String name = inputHandler.readLine();

                    japaneseService.editItem(index, name);

                    System.out.println("Name updated successfully!");
                }

                case 2 -> {
                    JapaneseType type = inputHandler.readJapaneseType();

                    japaneseService.editType(index, type);

                    System.out.println("Type updated successfully!");
                }

                case 3 -> {
                    System.out.print("New lesson: ");
                    int lesson = inputHandler.readInt();

                    japaneseService.editLesson(index, lesson);

                    System.out.println("Lesson updated successfully!");
                }

                case 4 -> {
                    System.out.print("Mastered? (true/false): ");
                    boolean mastered = inputHandler.readBoolean();

                    japaneseService.editMastered(index, mastered);

                    System.out.println("Mastered status updated successfully!");
                }

                case 5 -> {
                    System.out.print("Needs Revision? (true/false): ");
                    boolean revisionNeeded = inputHandler.readBoolean();

                    japaneseService.editRevisionNeeded(index, revisionNeeded);

                    System.out.println("Revision status updated successfully!");
                }

                case 6 -> {
                    System.out.print("New notes: ");
                    String notes = inputHandler.readLine();

                    japaneseService.editNotes(index, notes);

                    System.out.println("Notes updated successfully!");
                }

                case 0 -> running = false;

                default ->
                    System.out.println("Invalid choice, please try again...");
            }
        }
    }

    // =========================================== REMOVE ===============================================

    public void removeJapanese() {

        if (!ensureItemsExist()) return;

        viewAllJapanese();

        System.out.print("Enter the index of the item you want to remove: ");
        int index = inputHandler.readInt();

        if (!isValidIndex(index)) return;

        japaneseService.removeItem(index);

        System.out.println("Japanese item removed successfully!");
    }

    // =========================================== VIEW =================================================

    public void viewAllJapanese() {

        List<Japanese> items = japaneseService.getAllItems();

        if (items.isEmpty()) {
            System.out.println("No Japanese items available.");
            return;
        }

        for (int i = 0; i < items.size(); i++) {

            System.out.println(
                    "---------------- JAPANESE " + (i + 1) + " ----------------"
            );

            System.out.println(items.get(i));
        }
    }

    // =========================================== SEARCH ==============================================

    public void searchByType() {

        if (!ensureItemsExist()) return;

        JapaneseType type = inputHandler.readJapaneseType();

        List<Japanese> results = japaneseService.findByType(type);

        displaySearchResults(results);
    }

    public void searchByMastered() {

        if (!ensureItemsExist()) return;

        System.out.print("Show mastered items? (true/false): ");
        boolean mastered = inputHandler.readBoolean();

        List<Japanese> results =
                japaneseService.findByMastered(mastered);

        displaySearchResults(results);
    }

    public void searchByRevision() {

        if (!ensureItemsExist()) return;

        System.out.print("Show items needing revision? (true/false): ");
        boolean revisionNeeded = inputHandler.readBoolean();

        List<Japanese> results =
                japaneseService.findByRevisionNeeded(revisionNeeded);

        displaySearchResults(results);
    }

    public void searchByLesson() {

        if (!ensureItemsExist()) return;

        System.out.print("Enter lesson number: ");
        int lesson = inputHandler.readInt();

        List<Japanese> results =
                japaneseService.findByLesson(lesson);

        displaySearchResults(results);
    }

    // ========================================== DISPLAY HELPERS =======================================

    private void displaySearchResults(List<Japanese> results) {

        if (results.isEmpty()) {
            System.out.println("No matching Japanese items found.");
            return;
        }

        for (int i = 0; i < results.size(); i++) {

            System.out.println(
                    "---------------- RESULT " + (i + 1) + " ----------------"
            );

            System.out.println(results.get(i));
        }
    }
    // ========================================== VALIDATION ============================================

    private boolean ensureItemsExist() {

        if (!japaneseService.hasItems()) {
            System.out.println("No Japanese items available.");
            return false;
        }

        return true;
    }

    private boolean isValidIndex(int index) {

        if (index < 1 || index > japaneseService.getCountOfItems()) {
            System.out.println("Invalid index, please try again...");
            return false;
        }

        return true;
    }

    // ========================================== EXIT ==================================================

    private void displayJapaneseExitMsg() {
        System.out.println("Exiting Japanese Tracker...");
    }
}

