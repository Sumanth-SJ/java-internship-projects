package exm.inventory.model;



import java.util.Date;

public class Product implements Comparable<Product> {

    private String sku;
    private String name;
    private String category;
    private double price;
    private int quantity;
    private Date lastUpdated;

    public Product(String sku, String name, String category, double price, int quantity) {
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.lastUpdated = new Date();
    }

    @Override
    public int compareTo(Product other) {
        return this.sku.compareTo(other.sku);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        Product p = (Product) obj;
        return sku.equals(p.sku);
    }

    @Override
    public int hashCode() {
        return sku.hashCode();
    }

    public String getSku() { return sku; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.lastUpdated = new Date();
    }

    public double getInventoryValue() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format(
            "%-8s %-15s %-12s ₹%-8.2f %-5d ₹%-10.2f",
            sku, name, category, price, quantity, getInventoryValue()
        );
    }
}
