# Student Linked List Management System

A menu-driven Java console application for managing student records using a singly linked list with CSV persistence and performance testing.

## Features

- **Interactive Menu** with 11 options (0-10)
- **CSV Persistence** - automatically saves after every modification
- **Performance Testing** - measures execution time for all operations
- **Complete Operations**: Add, Insert, Delete, Search, Display
- **Edge Case Handling** - validates all inputs

## Quick Start

### Run the Application

**Option 1: Double-click**
```
RUN_NOW.bat
```

**Option 2: Command Line**
```cmd
cd student-linked-list-main
java Main
```

## Menu Options

1. **Add First** - Add student at beginning (O(1))
2. **Add Last** - Add student at end (O(n))
3. **Insert At Index** - Insert at specific position (O(n))
4. **Delete First** - Remove first student (O(1))
5. **Delete Last** - Remove last student (O(n))
6. **Delete At Index** - Remove at specific position (O(n))
7. **Search by Name** - Find student (O(n))
8. **Display All** - Show all students (O(n))
9. **Get Size** - Get total count (O(1))
10. **Run Performance Tests** - Test all operations with timing ⭐
0. **Exit** - Save and close

## Performance Testing (Option 10)

Tests all 10 operations and measures execution time in microseconds:

- Add First (O(1))
- Add Last (O(n))
- Insert At Middle (O(n))
- Search Best Case (O(1))
- Search Worst Case (O(n))
- Delete First (O(1))
- Delete Last (O(n))
- Delete At Middle (O(n))
- Display All (O(n))
- Get Size (O(1))

### To Run Performance Tests:
1. Type: `10`
2. Press: Enter
3. Press: Enter again to start
4. Watch all tests execute with timing
5. Press: Enter to return to menu

## Generate Large Dataset

To test with 1000 students:
```cmd
java GenerateStudents
java Main
```
Then choose option 10 to see performance differences with larger data.

## Files

### Source Code
- `Main.java` - Main application with menu and performance testing
- `StudentLinkedList.java` - Linked list implementation
- `StudentNode.java` - Node class
- `GenerateStudents.java` - Generates 1000 students for testing

### Data
- `students.csv` - Student data file (auto-loaded and auto-saved)

### Compiled
- `*.class` - Compiled Java files (ready to run)

### Utilities
- `RUN_NOW.bat` - Quick launch script
- `FINAL_WORKING_INSTRUCTIONS.txt` - Detailed instructions

## Compilation

If you need to recompile:
```cmd
javac StudentNode.java StudentLinkedList.java Main.java
```

## Requirements

- Java JDK 8 or higher
- No external dependencies

## CSV Format

```csv
name,course,credit,grade,cgpa
Ali Bin Ahmad,CS101,4,91.8,3.24
Siti Nur,CS102,2,73.9,3.20
```

## Time Complexity

| Operation | Time Complexity |
|-----------|----------------|
| Add First | O(1) |
| Add Last | O(n) |
| Insert At | O(n) |
| Delete First | O(1) |
| Delete Last | O(n) |
| Delete At | O(n) |
| Search | O(n) |
| Display | O(n) |
| Get Size | O(1) |

## License

See LICENSE file for details.

---

**Ready to run!** Just execute `java Main` or double-click `RUN_NOW.bat`
