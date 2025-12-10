import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String CSV_FILE = "students.csv";
    private static StudentLinkedList studentList = new StudentLinkedList();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  STUDENT LINKED LIST MANAGEMENT SYSTEM");
        System.out.println("========================================\n");
        loadStudentsFromCSV();
        displayMenu();
        scanner.close();
    }
    
    private static void displayMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n========================================");
            System.out.println("           MAIN MENU");
            System.out.println("========================================");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Insert At Index");
            System.out.println("4. Delete First");
            System.out.println("5. Delete Last");
            System.out.println("6. Delete At Index");
            System.out.println("7. Search by Name");
            System.out.println("8. Display All");
            System.out.println("9. Get Size");
            System.out.println("10. Run Performance Tests");
            System.out.println("0. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1: addFirst(); break;
                    case 2: addLast(); break;
                    case 3: insertAt(); break;
                    case 4: deleteFirst(); break;
                    case 5: deleteLast(); break;
                    case 6: deleteAt(); break;
                    case 7: searchByName(); break;
                    case 8: displayAll(); break;
                    case 9: getSize(); break;
                    case 10: runPerformanceTests(); break;
                    case 0:
                        System.out.println("\n========================================");
                        System.out.println("Thank you for using the Student Management System!");
                        System.out.println("All changes have been saved to " + CSV_FILE);
                        System.out.println("========================================");
                        running = false;
                        break;
                    default:
                        System.out.println("\n[ERROR] Invalid choice! Please enter 0-10.");
                }
            } catch (Exception e) {
                System.out.println("\n[ERROR] Invalid input!");
                scanner.nextLine();
            }
        }
    }
    
    private static void addFirst() {
        System.out.println("\n--- Add Student at First Position ---");
        try {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter course code: ");
            String course = scanner.nextLine();
            System.out.print("Enter credit hours: ");
            int credit = scanner.nextInt();
            System.out.print("Enter grade: ");
            double grade = scanner.nextDouble();
            System.out.print("Enter CGPA: ");
            double cgpa = scanner.nextDouble();
            scanner.nextLine();
            studentList.addFirst(name, course, credit, grade, cgpa);
            writeStudentsToCSV();
            System.out.println("\n[SUCCESS] Student added!");
            System.out.println("[INFO] CSV file updated.");
        } catch (Exception e) {
            System.out.println("\n[ERROR] Invalid input!");
            scanner.nextLine();
        }
    }
    
    private static void addLast() {
        System.out.println("\n--- Add Student at Last Position ---");
        try {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter course code: ");
            String course = scanner.nextLine();
            System.out.print("Enter credit hours: ");
            int credit = scanner.nextInt();
            System.out.print("Enter grade: ");
            double grade = scanner.nextDouble();
            System.out.print("Enter CGPA: ");
            double cgpa = scanner.nextDouble();
            scanner.nextLine();
            studentList.addLast(name, course, credit, grade, cgpa);
            writeStudentsToCSV();
            System.out.println("\n[SUCCESS] Student added!");
            System.out.println("[INFO] CSV file updated.");
        } catch (Exception e) {
            System.out.println("\n[ERROR] Invalid input!");
            scanner.nextLine();
        }
    }
    
    private static void insertAt() {
        System.out.println("\n--- Insert Student at Specific Index ---");
        System.out.println("Current list size: " + studentList.getSize());
        try {
            System.out.print("Enter index (0 to " + studentList.getSize() + "): ");
            int index = scanner.nextInt();
            scanner.nextLine();
            if (index < 0 || index > studentList.getSize()) {
                System.out.println("\n[ERROR] Invalid index!");
                return;
            }
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter course code: ");
            String course = scanner.nextLine();
            System.out.print("Enter credit hours: ");
            int credit = scanner.nextInt();
            System.out.print("Enter grade: ");
            double grade = scanner.nextDouble();
            System.out.print("Enter CGPA: ");
            double cgpa = scanner.nextDouble();
            scanner.nextLine();
            studentList.insertAt(index, name, course, credit, grade, cgpa);
            writeStudentsToCSV();
            System.out.println("\n[SUCCESS] Student inserted!");
            System.out.println("[INFO] CSV file updated.");
        } catch (Exception e) {
            System.out.println("\n[ERROR] Invalid input!");
            scanner.nextLine();
        }
    }
    
    private static void deleteFirst() {
        System.out.println("\n--- Delete First Student ---");
        if (studentList.isEmpty()) {
            System.out.println("[ERROR] Cannot delete from empty list!");
            return;
        }
        studentList.deleteFirst();
        writeStudentsToCSV();
        System.out.println("\n[SUCCESS] First student deleted!");
        System.out.println("[INFO] CSV file updated.");
    }
    
    private static void deleteLast() {
        System.out.println("\n--- Delete Last Student ---");
        if (studentList.isEmpty()) {
            System.out.println("[ERROR] Cannot delete from empty list!");
            return;
        }
        studentList.deleteLast();
        writeStudentsToCSV();
        System.out.println("\n[SUCCESS] Last student deleted!");
        System.out.println("[INFO] CSV file updated.");
    }
    
    private static void deleteAt() {
        System.out.println("\n--- Delete Student at Specific Index ---");
        if (studentList.isEmpty()) {
            System.out.println("[ERROR] Cannot delete from empty list!");
            return;
        }
        System.out.println("Current list size: " + studentList.getSize());
        try {
            System.out.print("Enter index (0 to " + (studentList.getSize() - 1) + "): ");
            int index = scanner.nextInt();
            scanner.nextLine();
            if (index < 0 || index >= studentList.getSize()) {
                System.out.println("\n[ERROR] Invalid index!");
                return;
            }
            studentList.deleteAt(index);
            writeStudentsToCSV();
            System.out.println("\n[SUCCESS] Student deleted!");
            System.out.println("[INFO] CSV file updated.");
        } catch (Exception e) {
            System.out.println("\n[ERROR] Invalid input!");
            scanner.nextLine();
        }
    }
    
    private static void searchByName() {
        System.out.println("\n--- Search Student by Name ---");
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        int index = studentList.search(name);
        if (index != -1) {
            System.out.println("\n[SUCCESS] Found at index: " + index);
        } else {
            System.out.println("\n[NOT FOUND] Student does not exist.");
        }
    }
    
    private static void displayAll() {
        System.out.println("\n--- Display All Students ---");
        studentList.display();
    }
    
    private static void getSize() {
        System.out.println("\n--- Current List Size ---");
        System.out.println("Total students: " + studentList.getSize());
    }
    
    private static void loadStudentsFromCSV() {
        System.out.println("Loading students from " + CSV_FILE + "...");
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            boolean isFirstLine = true;
            int count = 0;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 5) {
                    studentList.addLast(data[0].trim(), data[1].trim(), 
                        Integer.parseInt(data[2].trim()), 
                        Double.parseDouble(data[3].trim()), 
                        Double.parseDouble(data[4].trim()));
                    count++;
                }
            }
            System.out.println("[SUCCESS] Loaded " + count + " students.\n");
        } catch (IOException e) {
            System.out.println("[WARNING] Could not read CSV file.");
            System.out.println("[INFO] Starting with empty list.\n");
        }
    }
    
    private static void writeStudentsToCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE))) {
            writer.println("name,course,credit,grade,cgpa");
            if (!studentList.isEmpty()) {
                try {
                    java.lang.reflect.Field headField = StudentLinkedList.class.getDeclaredField("head");
                    headField.setAccessible(true);
                    StudentNode current = (StudentNode) headField.get(studentList);
                    while (current != null) {
                        writer.println(current.getName() + "," + current.getCourse() + "," + 
                            current.getCredit() + "," + current.getGrade() + "," + current.getCgpa());
                        current = current.getNext();
                    }
                } catch (Exception e) {}
            }
        } catch (IOException e) {}
    }
    
    private static void runPerformanceTests() {
        System.out.println("\n========================================");
        System.out.println("  PERFORMANCE TESTING PHASE");
        System.out.println("========================================");
        System.out.println("\nTesting all operations with timing...");
        System.out.println("Current list size: " + studentList.getSize());
        System.out.println("\nPress Enter to start...");
        scanner.nextLine();
        
        System.out.println("\n=== TEST 1: ADD FIRST ===");
        System.out.println("Time Complexity: O(1)");
        long start = System.nanoTime();
        studentList.addFirst("Test_First", "CS999", 3, 95.0, 3.85);
        long end = System.nanoTime();
        System.out.println("Time: " + String.format("%.2f", (end-start)/1000.0) + " microseconds");
        writeStudentsToCSV();
        
        System.out.println("\n=== TEST 2: ADD LAST ===");
        System.out.println("Time Complexity: O(n)");
        start = System.nanoTime();
        studentList.addLast("Test_Last", "CS998", 3, 88.0, 3.65);
        end = System.nanoTime();
        System.out.println("Time: " + String.format("%.2f", (end-start)/1000.0) + " microseconds");
        writeStudentsToCSV();
        
        System.out.println("\n=== TEST 3: INSERT AT MIDDLE ===");
        System.out.println("Time Complexity: O(n)");
        int mid = studentList.getSize() / 2;
        start = System.nanoTime();
        studentList.insertAt(mid, "Test_Mid", "CS997", 3, 85.0, 3.55);
        end = System.nanoTime();
        System.out.println("Time: " + String.format("%.2f", (end-start)/1000.0) + " microseconds");
        writeStudentsToCSV();
        
        System.out.println("\n=== TEST 4: SEARCH BEST CASE ===");
        System.out.println("Time Complexity: O(1)");
        start = System.nanoTime();
        int idx = studentList.search("Test_First");
        end = System.nanoTime();
        System.out.println("Time: " + String.format("%.2f", (end-start)/1000.0) + " microseconds");
        System.out.println("Found at index: " + idx);
        
        System.out.println("\n=== TEST 5: SEARCH WORST CASE ===");
        System.out.println("Time Complexity: O(n)");
        start = System.nanoTime();
        idx = studentList.search("Test_Last");
        end = System.nanoTime();
        System.out.println("Time: " + String.format("%.2f", (end-start)/1000.0) + " microseconds");
        System.out.println("Found at index: " + idx);
        
        System.out.println("\n=== TEST 6: DELETE FIRST ===");
        System.out.println("Time Complexity: O(1)");
        start = System.nanoTime();
        studentList.deleteFirst();
        end = System.nanoTime();
        System.out.println("Time: " + String.format("%.2f", (end-start)/1000.0) + " microseconds");
        writeStudentsToCSV();
        
        System.out.println("\n=== TEST 7: DELETE LAST ===");
        System.out.println("Time Complexity: O(n)");
        start = System.nanoTime();
        studentList.deleteLast();
        end = System.nanoTime();
        System.out.println("Time: " + String.format("%.2f", (end-start)/1000.0) + " microseconds");
        writeStudentsToCSV();
        
        System.out.println("\n=== TEST 8: DELETE AT MIDDLE ===");
        System.out.println("Time Complexity: O(n)");
        mid = studentList.getSize() / 2;
        start = System.nanoTime();
        studentList.deleteAt(mid);
        end = System.nanoTime();
        System.out.println("Time: " + String.format("%.2f", (end-start)/1000.0) + " microseconds");
        writeStudentsToCSV();
        
        System.out.println("\n=== TEST 9: DISPLAY ===");
        System.out.println("Time Complexity: O(n)");
        start = System.nanoTime();
        int count = 0;
        try {
            java.lang.reflect.Field headField = StudentLinkedList.class.getDeclaredField("head");
            headField.setAccessible(true);
            StudentNode current = (StudentNode) headField.get(studentList);
            while (current != null) {
                count++;
                current = current.getNext();
            }
        } catch (Exception e) {}
        end = System.nanoTime();
        System.out.println("Traversed " + count + " nodes");
        System.out.println("Time: " + String.format("%.2f", (end-start)/1000.0) + " microseconds");
        
        System.out.println("\n=== TEST 10: GET SIZE ===");
        System.out.println("Time Complexity: O(1)");
        start = System.nanoTime();
        int size = studentList.getSize();
        end = System.nanoTime();
        System.out.println("Size: " + size);
        System.out.println("Time: " + String.format("%.2f", (end-start)/1000.0) + " microseconds");
        
        System.out.println("\n========================================");
        System.out.println("  ALL TESTS COMPLETE!");
        System.out.println("========================================");
        System.out.println("Final list size: " + studentList.getSize());
        System.out.println("\nPress Enter to return to menu...");
        scanner.nextLine();
    }
}
