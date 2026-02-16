package com.exm.carts;



import java.util.*;

import com.exm.products.Product;

public class ShoppingCart {

    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {

        if (quantity > product.getStockQuantity()) {
            System.out.println("❌ Not enough stock!");
            return;
        }

        for (CartItem item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        items.add(new CartItem(product, quantity));
    }

    public double getTotalAmount() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getItemTotal();
        }
        return total;
    }

    public void displayCart() {
        System.out.println("\n=== SHOPPING CART ===");

        if (items.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        for (CartItem item : items) {
            System.out.println(item.getProduct().getName() +
                    " x " + item.getQuantity() +
                    " = ₹" + item.getItemTotal());
        }

        System.out.println("Total: ₹" + getTotalAmount());
    }

    public List<CartItem> getItems() {
        return items;
    }
}
