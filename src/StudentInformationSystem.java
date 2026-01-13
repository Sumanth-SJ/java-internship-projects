import java.util.ArrayList;
import java.util.Scanner;

public class StudentInformationSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== STUDENT INFORMATION SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        if (age <= 0) {
            System.out.println("Age must be positive!");
            return;
        }

        System.out.print("Enter Contact: ");
        String contact = sc.nextLine();

        students.add(new Student(id, name, age, contact));
        System.out.println("Student Added Successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.printf("%-10s %-15s %-5s %-15s%n",
                "ID", "Name", "Age", "Contact");
        System.out.println("------------------------------------------");

        for (Student s : students) {
            s.display();
        }
    }
}
