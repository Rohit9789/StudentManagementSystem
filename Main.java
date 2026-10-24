
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        ArrayList<Student> students = loadStudents();

        int nextId = 105;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() >= nextId) {
                nextId = students.get(i).getId() + 1;
            }
        }

        System.out.println("Students loaded: " + students.size());

        while (true) {
            System.out.println("==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Update Student Age");
            System.out.println("6. Delete Student");
            System.out.println("7. Update Student Marks");
            System.out.println("8. Show Class Statistics");
            System.out.println("9. Sort Students by Marks");
            System.out.println("10. Show Topper");
            System.out.println("11. Search Student by Name");
            System.out.println("12. Export Student Report");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter student name: ");
                String name = sc.nextLine();

                System.out.print("Enter student age: ");
                int age = sc.nextInt();

                if (age <= 0) {
                    System.out.println("Age must be greater than 0!");
                    continue;
                }

                System.out.print("Enter student marks: ");
                double marks = sc.nextDouble();

                if (marks < 0 || marks > 100) {
                    System.out.println("Marks must be between 0 and 100!");
                    continue;
                }

                Student newStudent =
                        new Student(nextId, name, age, marks);

                nextId++;
                students.add(newStudent);

                saveStudents(students);

                System.out.println("Student added successfully!");
            }

            else if (choice == 2) {
                System.out.println("ID | Name | Age | Marks");
                System.out.println("-------------------------");

                for (int i = 0; i < students.size(); i++) {
                    System.out.println(
                        students.get(i).getId() + " | " +
                        students.get(i).getName() + " | " +
                        students.get(i).getAge() + " | " +
                        students.get(i).getMarks()
                    );
                }
            }

            else if (choice == 3) {
                saveStudents(students);

                System.out.println(
                    "Exiting Student Management System. Goodbye!"
                );
                break;
            }

            else if (choice == 4) {
                System.out.print("Enter student ID: ");
                int searchId = sc.nextInt();

                boolean found = false;

                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getId() == searchId) {
                        System.out.println("Student found!");
                        System.out.println(
                            "ID: " + students.get(i).getId()
                        );
                        System.out.println(
                            "Name: " + students.get(i).getName()
                        );
                        System.out.println(
                            "Age: " + students.get(i).getAge()
                        );
                        System.out.println(
                            "Marks: " + students.get(i).getMarks()
                        );

                        found = true;
                        break;
                    }
                }

                if (found == false) {
                    System.out.println("Student not found!");
                }
            }
            else if (choice == 5){
                System.out.print("Enter student ID: ");
                int searchId = sc.nextInt();

                
                boolean found = false;

                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getId() == searchId) {
                    System.out.print("Enter new age: ");
                    int newAge = sc.nextInt();

                    if (newAge <= 0) {
                        System.out.println("Age must be greater than 0!");
                    } else {
                        students.get(i).setAge(newAge);
                        saveStudents(students);
                        System.out.println("Student age updated successfully!");
                    }
                        found = true;
                        break;
                    }
                }

                if (found == false) {
                    System.out.println("Student not found!");
                }

            }
            else if (choice == 6) {
                System.out.print("Enter student ID to delete: ");
                int searchId = sc.nextInt();

                boolean found = false;

                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getId() == searchId) {
                        students.remove(i);
                        saveStudents(students);
                        System.out.println("Student deleted successfully!");
                        found = true;
                        break;
                    }
                }

                if (found == false) {
                    System.out.println("Student not found!");
                }
            }
            else if (choice == 7) {
                System.out.print("Enter student ID: ");
                int searchId = sc.nextInt();

                boolean found = false;

                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getId() == searchId) {
                        System.out.print("Enter new marks: ");
                        double newMarks = sc.nextDouble();

                        if (newMarks < 0 || newMarks > 100) {
                            System.out.println("Marks must be between 0 and 100!");
                        } else {
                            students.get(i).setMarks(newMarks);
                            saveStudents(students);
                            System.out.println("Student marks updated successfully!");
                        }

                        found = true;
                        break;
                    }
                }

                if (found == false) {
                    System.out.println("Student not found!");
                }
            }
            else if (choice == 8) {
                if (students.isEmpty()) {
                    System.out.println("No students available.");
                } else {
                    double totalMarks = 0;
                    double highestMarks = students.get(0).getMarks();
                    double lowestMarks = students.get(0).getMarks();

                    for (int i = 0; i < students.size(); i++) {
                        double marks = students.get(i).getMarks();

                        totalMarks += marks;

                        if (marks > highestMarks) {
                            highestMarks = marks;
                        }

                        if (marks < lowestMarks) {
                            lowestMarks = marks;
                        }
                    }
                        double averageMarks = totalMarks / students.size();

                        System.out.println("Class Statistics");
                        System.out.println("Average marks: " + averageMarks);
                        System.out.println("Highest marks: " + highestMarks);
                        System.out.println("Lowest marks: " + lowestMarks);
                }
            }  
            else if (choice == 9) {
                for (int i = 0; i < students.size(); i++) {
                    for (int j = i + 1; j < students.size(); j++) {

                        if (students.get(i).getMarks() < students.get(j).getMarks()) {
                            Student temp = students.get(i);
                            students.set(i, students.get(j));
                            students.set(j, temp);
                        }

                    }
                }

                System.out.println("Students sorted by marks!");
            }  
            else if (choice == 10) {
                if (students.isEmpty()) {
                    System.out.println("No students available.");
                } else {
                    Student topper = students.get(0);

                    for (int i = 1; i < students.size(); i++) {
                        if (students.get(i).getMarks() > topper.getMarks()) {
                            topper = students.get(i);
                        }
                    }

                    System.out.println("Class Topper");
                    System.out.println("Name: " + topper.getName());
                    System.out.println("Marks: " + topper.getMarks());
                }
            } 
            else if (choice == 11) {
                System.out.print("Enter student name: ");
                String searchName = sc.nextLine();

                boolean found = false;

                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getName().equalsIgnoreCase(searchName)) {
                        System.out.println("Student found!");
                        System.out.println("ID: " + students.get(i).getId());
                        System.out.println("Name: " + students.get(i).getName());
                        System.out.println("Age: " + students.get(i).getAge());
                        System.out.println("Marks: " + students.get(i).getMarks());

                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Student not found.");
                }
            }
            else if (choice == 12) {
                try {
                    FileWriter writer = new FileWriter("student_report.txt");

                    writer.write("STUDENT REPORT\n");
                    writer.write("====================\n");

                    for (int i = 0; i < students.size(); i++) {
                        Student s = students.get(i);

                        writer.write("ID: " + s.getId() + "\n");
                        writer.write("Name: " + s.getName() + "\n");
                        writer.write("Age: " + s.getAge() + "\n");
                        writer.write("Marks: " + s.getMarks() + "\n");
                        writer.write("--------------------\n");
                    }

                    writer.close();

                    System.out.println("Student report exported successfully!");

                } catch (IOException e) {
                    System.out.println("Error exporting student report.");
                }
            }
            else {
                System.out.println(
                    "Invalid choice. Please try again."
                );
            }
        }

        sc.close();
    }
        public static void saveStudents(ArrayList<Student> students) {
        try {
            FileWriter writer = new FileWriter("students.txt");

            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);

                writer.write(
                    s.getId() + "," +
                    s.getName() + "," +
                    s.getAge() + "," +
                    s.getMarks() + "\n"
                );
            }

            writer.close();
            System.out.println("Students saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving students!");
        }
    }
        public static ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<>();

        try {
            File file = new File("students.txt");

            if (file.exists()) {
                java.util.Scanner reader = new java.util.Scanner(file);

                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    String[] data = line.split(",");

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    double marks = Double.parseDouble(data[3]);

                    Student student = new Student(id, name, age, marks);
                    students.add(student);
                }

                reader.close();
            }

        } catch (IOException e) {
            System.out.println("Error loading students!");
        }

        return students;
    }
}
