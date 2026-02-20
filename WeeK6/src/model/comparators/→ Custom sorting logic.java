package exm.inventory.comparators;



import java.util.Comparator;

import exm.inventory.model.Product;

public class NameComparator implements Comparator<Product> {
    public int compare(Product a, Product b) {
        return a.getName().compareTo(b.getName());
    }
}
