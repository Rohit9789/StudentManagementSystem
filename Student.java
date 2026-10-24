
public class Student {

    // Student information
    private int id;
    private String name;
    private int age;
    private double marks;

    // Constructor: creates a new student
    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Returns the student's ID
    public int getId() {
        return id;
    }

    // Returns the student's name
    public String getName() {
        return name;
    }

    // Returns the student's age
    public int getAge() {
        return age;
    }

    // Updates the student's age
    public void setAge(int age) {
        this.age = age;
    }

    // Returns the student's marks
    public double getMarks() {
        return marks;
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }
}
