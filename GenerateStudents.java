import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Utility class to generate a CSV file with 1000 student records
 * Run this once to create the students.csv file
 */
public class GenerateStudents {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("students.csv")) {
            // Write header
            writer.write("name,course,credit,grade,cgpa\n");
            
            Random random = new Random();
            String[] firstNames = {"Ali", "Siti", "Kumar", "Fatimah", "Ahmad", "Nurul", "Raj", "Lim", "Aisha", "Muhammad",
                                  "Zainab", "Hassan", "Mei Ling", "Arjun", "Nadia", "Ismail", "Priya", "Chen", "Amira", "Yusuf"};
            String[] lastNames = {"Bin Ahmad", "Nur", "Kumar", "Zahra", "Ibrahim", "Aina", "Singh", "Wei Ming", "Binti Ali", "Hafiz",
                                 "Abdullah", "Rahman", "Wong", "Patel", "Hassan", "Tan", "Sharma", "Lee", "Karim", "Ali"};
            
            // Generate 1000 students
            for (int i = 0; i < 1000; i++) {
                String name;
                if (i < 20) {
                    // First 20 with real names
                    name = firstNames[i % firstNames.length] + " " + lastNames[i % lastNames.length];
                } else {
                    // Rest with Student_X format
                    name = "Student_" + i;
                }
                
                String course = "CS" + (101 + (i % 500));
                int credit = 2 + random.nextInt(3); // 2, 3, or 4 credits
                double grade = 70.0 + (random.nextDouble() * 25.0); // 70.0 to 95.0
                double cgpa = 2.5 + (random.nextDouble() * 1.5); // 2.5 to 4.0
                
                writer.write(String.format("%s,%s,%d,%.1f,%.2f\n", 
                           name, course, credit, grade, cgpa));
            }
            
            System.out.println("Successfully generated students.csv with 1000 student records!");
            
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
