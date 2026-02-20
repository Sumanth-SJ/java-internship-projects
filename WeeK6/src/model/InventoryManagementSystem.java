package exm.inventory.collections;




import java.util.*;

import exm.inventory.comparators.NameComparator;
import exm.inventory.comparators.PriceComparator;
import exm.inventory.comparators.ValueComparator;
import exm.inventory.model.Product;

public class InventoryManagementSystem {

    private HashSet<Product> productSet = new HashSet<>();
    private LinkedList<String> transactions = new LinkedList<>();
    private Deque<Product> undoStack = new ArrayDeque<>();
    private Queue<Product> lowStockQueue = new LinkedList<>();

    public void addProduct(Product p) {
        if (productSet.add(p)) {
            transactions.addFirst("ADD: " + p.getSku());
            if (p.getQuantity() < 10) lowStockQueue.offer(p);
            System.out.println("✅ Product added");
        } else {
            System.out.println("❌ Duplicate SKU");
        }
    }

    public void updateQuantity(String sku, int qty) {
        for (Product p : productSet) {
            if (p.getSku().equals(sku)) {
                undoStack.push(new Product(
                        p.getSku(), p.getName(), p.getCategory(),
                        p.getPrice(), p.getQuantity()
                ));
                p.setQuantity(qty);
                transactions.addFirst("UPDATE: " + sku);
                System.out.println("✅ Quantity updated");
                return;
            }
        }
        System.out.println("❌ Product not found");
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("❌ Nothing to undo");
            return;
        }
        Product p = undoStack.pop();
        updateQuantity(p.getSku(), p.getQuantity());
        System.out.println("↩ Undo done");
    }

    public void display(String sortType) {
        List<Product> list = new ArrayList<>(productSet);

        switch (sortType) {
            case "sku": Collections.sort(list); break;
            case "price": list.sort(new PriceComparator()); break;
            case "value": list.sort(new ValueComparator()); break;
            case "name": list.sort(new NameComparator()); break;
            default:
                System.out.println("Invalid sort");
                return;
        }

        System.out.println("SKU      Name            Category     Price    Qty   Value");
        System.out.println("-------------------------------------------------------------");
        for (Product p : list) System.out.println(p);
    }

    public void lowStock() {
        if (lowStockQueue.isEmpty()) {
            System.out.println("No low stock items");
            return;
        }
        for (Product p : lowStockQueue) {
            System.out.println(p.getSku() + " Qty: " + p.getQuantity());
        }
    }

    public void showTransactions(int n) {
        int i = 0;
        for (String t : transactions) {
            System.out.println(t);
            if (++i == n) break;
        }
    }
}
