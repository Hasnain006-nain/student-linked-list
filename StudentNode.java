public class StudentNode {
    private String name;
    private String course;
    private int credit;
    private double grade;
    private double cgpa;
    private StudentNode next;
    
    public StudentNode(String name, String course, int credit, double grade, double cgpa) {
        this.name = name;
        this.course = course;
        this.credit = credit;
        this.grade = grade;
        this.cgpa = cgpa;
        this.next = null;
    }
    
    public String getName() {
        return name;
    }
    
    public String getCourse() {
        return course;
    }
    
    public int getCredit() {
        return credit;
    }
    
    public double getGrade() {
        return grade;
    }
    
    public double getCgpa() {
        return cgpa;
    }
    
    public StudentNode getNext() {
        return next;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    public void setGrade(double grade) {
        this.grade = grade;
    }
    
    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
    
    public void setNext(StudentNode next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        return String.format("Name: %s, Course: %s, Credit: %d, Grade: %.2f, CGPA: %.2f", 
                           name, course, credit, grade, cgpa);
    }
}
