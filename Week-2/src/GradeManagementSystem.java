import java.util.Scanner;

public class GradeManagementSystem {

    static final int MAX = 100;
    static final int SUBJECTS = 5;

    static StudentGrade[] students = new StudentGrade[MAX];
    static int count = 0;

    static Scanner sc = new Scanner(System.in);
    static String[] subjectNames = {"Math", "Science", "English", "History", "Computer"};

    public static void main(String[] args) {

        boolean run = true;

        while (run) {
            System.out.println("\n=== GRADE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Calculate Grades");
            System.out.println("4. Top Performers");
            System.out.println("5. Report");
            System.out.println("6. Exit");
            System.out.print("Choice: ");

            int ch = getInt(1,6);

            switch (ch) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> calculateGrades();
                case 4 -> ReportGenerator.topPerformers(students, count);
                case 5 -> ReportGenerator.performanceReport(students, count);
                case 6 -> run = false;
            }
        }
        sc.close();
    }

    static void addStudent() {
        if (count >= MAX) {
            System.out.println("Student limit reached!");
            return;
        }

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        StudentGrade sg = new StudentGrade(name, SUBJECTS);

        for (int i = 0; i < SUBJECTS; i++) {
            System.out.print(subjectNames[i] + " marks: ");
            sg.marks[i] = getMark();
        }

        students[count++] = sg;
        System.out.println("✅ Student Added");
    }

    static void viewStudents() {
        System.out.println("\nNAME\tAVERAGE\tGRADE");
        for (int i = 0; i < count; i++) {
            System.out.println(students[i].name + "\t" +
                    students[i].average + "\t" +
                    students[i].grade);
        }
    }

    static void calculateGrades() {
        for (int i = 0; i < count; i++) {
            double avg = GradeCalculator.calculateAverage(students[i].marks);
            students[i].average = avg;
            students[i].grade = GradeCalculator.calculateGrade(avg);
        }
        System.out.println("Grades calculated successfully!");
    }

    static int getInt(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n >= min && n <= max) return n;
            } catch (Exception ignored) {}
            System.out.print("Enter valid number: ");
        }
    }

    static double getMark() {
        while (true) {
            try {
                double m = Double.parseDouble(sc.nextLine());
                if (m >= 0 && m <= 100) return m;
            } catch (Exception ignored) {}
            System.out.print("Enter marks (0-100): ");
        }
    }
}
