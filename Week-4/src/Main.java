import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        while (true) {
            System.out.println("\n=== EMPLOYEE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add New Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Generate Reports");
            System.out.println("7. Save to File");
            System.out.println("8. Load from File");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: ems.addEmployee(); break;
                case 2: ems.viewEmployees(); break;
                case 3: ems.searchEmployee(); break;
                case 4: ems.updateEmployee(); break;
                case 5: ems.deleteEmployee(); break;
                case 6: ems.generateReport(); break;
                case 7: ems.saveToFile(); break;
                case 8: ems.loadFromFile(); break;
                case 9:
                    System.out.println("Exiting system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
