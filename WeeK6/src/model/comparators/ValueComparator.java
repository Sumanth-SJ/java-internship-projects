package exm.inventory.comparators;



import java.util.Comparator;

import exm.inventory.model.Product;

public class ValueComparator implements Comparator<Product> {
    public int compare(Product a, Product b) {
        return Double.compare(b.getInventoryValue(), a.getInventoryValue());
    }
}
