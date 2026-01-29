public class StudentGrade {
    String name;
    double[] marks;
    double average;
    String grade;

    public StudentGrade(String name, int subjectCount) {
        this.name = name;
        this.marks = new double[subjectCount];
    }
}
