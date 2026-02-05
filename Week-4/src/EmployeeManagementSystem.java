import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmployeeManagementSystem {

    private ArrayList<Employee> employees = new ArrayList<>();
    private HashMap<String, Employee> employeeMap = new HashMap<>();
    private static final String FILE_NAME = "employees.dat";
    private Scanner sc = new Scanner(System.in);

    public EmployeeManagementSystem() {
        loadFromFile();
    }

    // 1. ADD
    public void addEmployee() {
        System.out.println("\n=== ADD NEW EMPLOYEE ===");

        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        if (employeeMap.containsKey(id)) {
            System.out.println("Employee ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.print("Enter Position: ");
        String pos = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        Employee e = new Employee(id, name, dept, pos, salary);
        employees.add(e);
        employeeMap.put(id, e);

        System.out.println("Employee added successfully.");
    }

    // 2. VIEW
    public void viewEmployees() {
        System.out.println("\n=== ALL EMPLOYEES ===");

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.printf("%-8s %-20s %-15s %-15s %-10s %-12s%n",
                "ID","Name","Department","Position","Salary","Join Date");
        System.out.println("--------------------------------------------------------------------------------");

        for (Employee e : employees) {
            System.out.printf("%-8s %-20s %-15s %-15s %-10.2f %-12s%n",
                    e.getId(), e.getName(), e.getDepartment(),
                    e.getPosition(), e.getSalary(), sdf.format(e.getJoinDate()));
        }
    }

    // 3. SEARCH
    public void searchEmployee() {
        System.out.println("\n1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Department");
        System.out.print("Enter choice: ");
        int ch = sc.nextInt();
        sc.nextLine();

        if (ch == 1) {
            System.out.print("Enter ID: ");
            String id = sc.nextLine();
            Employee e = employeeMap.get(id);
            System.out.println(e != null ? e : "Employee not found.");

        } else if (ch == 2) {
            System.out.print("Enter Name: ");
            String name = sc.nextLine().toLowerCase();
            for (Employee e : employees) {
                if (e.getName().toLowerCase().contains(name)) {
                    System.out.println(e);
                }
            }

        } else if (ch == 3) {
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();
            for (Employee e : employees) {
                if (e.getDepartment().equalsIgnoreCase(dept)) {
                    System.out.println(e);
                }
            }
        }
    }

    // 4. UPDATE
    public void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        String id = sc.nextLine();

        Employee e = employeeMap.get(id);
        if (e == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("Enter new Department: ");
        e.setDepartment(sc.nextLine());

        System.out.print("Enter new Position: ");
        e.setPosition(sc.nextLine());

        System.out.print("Enter new Salary: ");
        e.setSalary(sc.nextDouble());
        sc.nextLine();

        System.out.println("Employee updated successfully.");
    }

    // 5. DELETE
    public void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        String id = sc.nextLine();

        Employee e = employeeMap.remove(id);
        if (e != null) {
            employees.remove(e);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // 6. REPORT
    public void generateReport() {
        double total = 0, max = 0, min = Double.MAX_VALUE;
        Employee maxEmp = null, minEmp = null;

        for (Employee e : employees) {
            total += e.getSalary();
            if (e.getSalary() > max) { max = e.getSalary(); maxEmp = e; }
            if (e.getSalary() < min) { min = e.getSalary(); minEmp = e; }
        }

        System.out.println("\n=== SALARY REPORT ===");
        System.out.println("Total Employees: " + employees.size());
        System.out.println("Total Salary: " + total);
        System.out.println("Average Salary: " + (employees.isEmpty() ? 0 : total / employees.size()));
        if (maxEmp != null)
            System.out.println("Highest Salary: " + max + " (" + maxEmp.getName() + ")");
        if (minEmp != null)
            System.out.println("Lowest Salary: " + min + " (" + minEmp.getName() + ")");
    }

    // 7. SAVE
    public void saveToFile() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employee data saved to file.");
        } catch (IOException e) {
            System.out.println("File save error.");
        }
    }

    // 8. LOAD
    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        File f = new File(FILE_NAME);
        if (!f.exists()) return;

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (ArrayList<Employee>) ois.readObject();
            employeeMap.clear();
            for (Employee e : employees) {
                employeeMap.put(e.getId(), e);
            }
        } catch (Exception e) {
            System.out.println("File load error.");
        }
    }
}
