package com.exm.main;



import java.util.*;

import com.exm.carts.ShoppingCart;
import com.exm.customers.Customer;
import com.exm.orders.Order;
import com.exm.products.BookProduct;
import com.exm.products.ClothingProduct;
import com.exm.products.ElectronicsProduct;
import com.exm.products.Product;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Sample Products
        Product p1 = new ElectronicsProduct(
                "E001", "Smartphone", 50000,
                "5G Mobile", 10, "Samsung", 24);

        Product p2 = new ClothingProduct(
                "C001", "T-Shirt", 1200,
                "Cotton Shirt", 50, "M", "Blue");

        Product p3 = new BookProduct(
                "B001", "Java Book", 800,
                "Learn Java", 30, "James", "123-456");

        List<Product> products = Arrays.asList(p1, p2, p3);

        ShoppingCart cart = new ShoppingCart();
        Customer customer = new Customer("CUST01", "Sumanth", "sumanth@email.com");

        int choice;

        do {
            System.out.println("\n=== E-COMMERCE SYSTEM ===");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    for (Product p : products) {
                        p.displayInfo();
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    String id = sc.next();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    for (Product p : products) {
                        if (p.getId().equalsIgnoreCase(id)) {
                            cart.addItem(p, qty);
                            System.out.println("Added to cart ✅");
                        }
                    }
                    break;

                case 3:
                    cart.displayCart();
                    break;

                case 4:
                    Order order = new Order(cart);
                    order.displayOrder();
                    break;

                case 5:
                    System.out.println("Thank you for shopping!");
                    break;
            }

        } while (choice != 5);

        sc.close();
    }
}

