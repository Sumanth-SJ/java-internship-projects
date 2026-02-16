package com.exm.orders;


import java.util.Date;

import com.exm.carts.ShoppingCart;


public class Order {

    private static int orderCounter = 1000;

    private String orderId;
    private Date orderDate;
    private ShoppingCart cart;
    private double finalAmount;

    public Order(ShoppingCart cart) {
        this.orderId = "ORD" + (orderCounter++);
        this.orderDate = new Date();
        this.cart = cart;
        this.finalAmount = cart.getTotalAmount() * 1.18; // 18% GST
    }

    public void displayOrder() {
        System.out.println("\n=== ORDER DETAILS ===");
        System.out.println("Order ID: " + orderId);
        System.out.println("Date: " + orderDate);

        cart.displayCart();

        System.out.println("Final Amount (Including GST): ₹" + finalAmount);
        System.out.println("Order Confirmed ✅");
    }
}
