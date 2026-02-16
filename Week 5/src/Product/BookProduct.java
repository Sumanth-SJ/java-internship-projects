package com.exm.products;



public class BookProduct extends Product {

    private String author;
    private String isbn;

    public BookProduct(String id, String name, double price,
                       String description, int stockQuantity,
                       String author, String isbn) {
        super(id, name, price, description, stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public double calculateDiscount() {
        return price * 0.05;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Book");
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("----------------------------------");
    }
}
