
public class Student {

    private String studentId;
    private String name;
    private int age;
    private String contact;

    public Student(String studentId, String name, int age, String contact) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getContact() {
        return contact;
    }

    public void display() {
        System.out.printf("%-10s %-15s %-5d %-15s%n",
                studentId, name, age, contact);
    }
}
