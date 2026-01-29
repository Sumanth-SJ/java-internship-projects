# Library Management System – Project Documentation

## 1. Project Overview
Library Management System is a console-based Java application developed
to understand Object-Oriented Programming concepts.

The system helps in managing:
- Books in a library
- Members of the library
- Borrowing and returning books

This project mainly focuses on OOP concepts like:
- Classes and Objects
- Encapsulation
- Data Hiding
- Method usage
- Menu-driven programs

---

## 2. Technologies Used
- Java (JDK 8 or above)
- ArrayList Collection
- Scanner class

---

## 3. System Features
- Add new books to the library
- Register new members
- Display all books
- Search books by title or author
- Borrow and return books
- Book availability validation

---

## 4. Class Descriptions

### 4.1 Book Class
**Attributes:**
- isbn : String
- title : String
- author : String
- genre : String
- available : boolean

**Methods:**
- Getters and setters
- displayInfo()

Purpose:
Stores book details and tracks availability.

---

### 4.2 Member Class
**Attributes:**
- memberId : String
- name : String
- contact : String
- borrowedBooks : ArrayList<Book>

**Methods:**
- borrowBook()
- returnBook()
- displayInfo()

Purpose:
Manages library members and borrowed books.

---

### 4.3 Library Class
**Attributes:**
- books : ArrayList<Book>
- members : ArrayList<Member>

**Methods:**
- addBook()
- addMember()
- findBookByIsbn()
- findMemberById()
- searchBooks()
- displayAllBooks()
- displayAvailableBooks()

Purpose:
Controls all library operations.

---

### 4.4 LibrarySystem Class
Purpose:
Main class that provides menu-driven interface for user interaction.

---

## 5. OOP Concepts Implemented
- Encapsulation using private variables
- Abstraction using methods
- Objects creation
- Class relationships

---

## 6. Validation & Error Handling
- Prevent borrowing unavailable books
- Validate member ID and ISBN
- Proper messages for invalid inputs

---

## 7. Conclusion
This project gives hands-on experience in Java OOP concepts and
real-world application design.

