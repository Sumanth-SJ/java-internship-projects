public class ReportGenerator {

    public static void performanceReport(StudentGrade[] students, int count) {
        System.out.println("\n=== PERFORMANCE REPORT ===");
        System.out.println("Total Students: " + count);

        int a=0,b=0,c=0,d=0,f=0;

        for (int i = 0; i < count; i++) {
            switch (students[i].grade) {
                case "A+": case "A": a++; break;
                case "B": b++; break;
                case "C": c++; break;
                case "D": d++; break;
                case "F": f++; break;
            }
        }

        System.out.println("\nGRADE DISTRIBUTION:");
        System.out.println("A Grade: " + a);
        System.out.println("B Grade: " + b);
        System.out.println("C Grade: " + c);
        System.out.println("D Grade: " + d);
        System.out.println("F Grade: " + f);
    }

    public static void topPerformers(StudentGrade[] students, int count) {
        System.out.println("\n=== TOP PERFORMERS ===");
        for (int i = 0; i < count; i++) {
            System.out.println(students[i].name + " → " + students[i].average);
        }
    }
}
