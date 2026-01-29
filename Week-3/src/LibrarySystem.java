import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Display All Books");
            System.out.println("4. Search Book");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();

                    library.addBook(new Book(isbn, title, author, genre));
                    System.out.println("✅ Book added successfully");
                    break;

                case 2:
                    System.out.print("Member ID: ");
                    String id = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Contact: ");
                    String contact = sc.nextLine();

                    library.addMember(new Member(id, name, contact));
                    System.out.println("✅ Member registered");
                    break;

                case 3:
                    library.showAllBooks();
                    break;

                case 4:
                    System.out.print("Enter keyword: ");
                    String key = sc.nextLine();
                    library.searchBook(key);
                    break;

                case 5:
                    System.out.print("Member ID: ");
                    String mid = sc.nextLine();
                    System.out.print("Book ISBN: ");
                    String bisbn = sc.nextLine();

                    Member m = library.findMember(mid);
                    Book b = library.findBook(bisbn);

                    if (m != null && b != null && m.borrowBook(b)) {
                        System.out.println("📘 Book borrowed successfully");
                    } else {
                        System.out.println("❌ Borrow failed");
                    }
                    break;

                case 6:
                    System.out.print("Member ID: ");
                    mid = sc.nextLine();
                    System.out.print("Book ISBN: ");
                    bisbn = sc.nextLine();

                    m = library.findMember(mid);
                    b = library.findBook(bisbn);

                    if (m != null && b != null && m.returnBook(b)) {
                        System.out.println("📗 Book returned successfully");
                    } else {
                        System.out.println("❌ Return failed");
                    }
                    break;

                case 7:
                    System.out.println("Thank you!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
