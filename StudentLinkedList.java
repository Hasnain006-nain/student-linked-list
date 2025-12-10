/**
 * StudentLinkedList class manages the singly linked list operations.
 * This class provides methods to add, delete, search, and display student records.
 */
public class StudentLinkedList {
    private StudentNode head;  // First node in the list
    private int size;          // Number of nodes in the list
    
    /**
     * Constructor initializes an empty linked list
     */
    public StudentLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    /**
     * Adds a new student node at the beginning of the list
     * Time Complexity: O(1) - Constant time, always adds at head
     */
    public void addFirst(String name, String course, int credit, double grade, double cgpa) {
        StudentNode newNode = new StudentNode(name, course, credit, grade, cgpa);
        newNode.setNext(head);
        head = newNode;
        size++;
    }
    
    /**
     * Adds a new student node at the end of the list
     * Time Complexity: O(n) - Must traverse entire list to find the last node
     */
    public void addLast(String name, String course, int credit, double grade, double cgpa) {
        StudentNode newNode = new StudentNode(name, course, credit, grade, cgpa);
        
        // If list is empty, new node becomes head
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        
        // Traverse to the last node
        StudentNode current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        
        // Add new node at the end
        current.setNext(newNode);
        size++;
    }
    
    /**
     * Inserts a new student node at a specified index (0-based)
     * Time Complexity: O(n) - Must traverse to the specified index
     */
    public void insertAt(int index, String name, String course, int credit, double grade, double cgpa) {
        // Check if index is valid
        if (index < 0 || index > size) {
            System.out.println("Error: Index " + index + " is out of bounds. Valid range: 0 to " + size);
            return;
        }
        
        // If inserting at beginning
        if (index == 0) {
            addFirst(name, course, credit, grade, cgpa);
            return;
        }
        
        // Create new node
        StudentNode newNode = new StudentNode(name, course, credit, grade, cgpa);
        
        // Traverse to the node before the insertion point
        StudentNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        
        // Insert the new node
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }
    
    /**
     * Removes the first student node from the list
     * Time Complexity: O(1) - Constant time, just update head pointer
     */
    public void deleteFirst() {
        if (head == null) {
            System.out.println("Error: Cannot delete from an empty list.");
            return;
        }
        
        head = head.getNext();
        size--;
    }
    
    /**
     * Removes the last student node from the list
     * Time Complexity: O(n) - Must traverse to second-to-last node
     */
    public void deleteLast() {
        if (head == null) {
            System.out.println("Error: Cannot delete from an empty list.");
            return;
        }
        
        // If only one node exists
        if (head.getNext() == null) {
            head = null;
            size--;
            return;
        }
        
        // Traverse to second-to-last node
        StudentNode current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        
        // Remove last node
        current.setNext(null);
        size--;
    }
    
    /**
     * Removes the student node at the specified index
     * Time Complexity: O(n) - Must traverse to the specified index
     */
    public void deleteAt(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Error: Index " + index + " is out of bounds. Valid range: 0 to " + (size - 1));
            return;
        }
        
        // If deleting first node
        if (index == 0) {
            deleteFirst();
            return;
        }
        
        // Traverse to the node before the deletion point
        StudentNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        
        // Delete the node
        current.setNext(current.getNext().getNext());
        size--;
    }
    
    /**
     * Searches for a student by name and returns the index
     * Time Complexity: O(n) - Must potentially check all nodes
     */
    public int search(String name) {
        StudentNode current = head;
        int index = 0;
        
        while (current != null) {
            if (current.getName().equalsIgnoreCase(name)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        
        return -1; // Student not found
    }
    
    /**
     * Displays all student nodes from head to tail
     * Time Complexity: O(n) - Must visit every node
     */
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        
        System.out.println("\n========== Student List ==========");
        StudentNode current = head;
        int index = 0;
        
        while (current != null) {
            System.out.println("[" + index + "] " + current.toString());
            current = current.getNext();
            index++;
        }
        System.out.println("==================================\n");
    }
    
    /**
     * Returns the number of nodes in the linked list
     * Time Complexity: O(1) - Just return the size variable
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Checks if the list is empty
     */
    public boolean isEmpty() {
        return head == null;
    }
}
