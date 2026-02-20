package exm.inventory.utils;



import java.util.Collection;

public class InventoryUtils {
    public static <T> void display(Collection<T> items) {
        for (T item : items) {
            System.out.println(item);
        }
    }
