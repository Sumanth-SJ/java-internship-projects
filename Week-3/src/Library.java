import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Book findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Member findMember(String id) {
        for (Member member : members) {
            if (member.getMemberId().equals(id)) {
                return member;
            }
        }
        return null;
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library");
            return;
        }

        for (Book book : books) {
            book.displayBook();
        }
    }

    public void searchBook(String keyword) {
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found");
        }
    }
}
