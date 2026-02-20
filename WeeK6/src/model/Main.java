package exm.inventory.main;


import java.util.Scanner;

import exm.inventory.collections.InventoryManagementSystem;
import exm.inventory.model.Product;

public class Main {

    public static void main(String[] args) {

        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add  2.Update  3.View  4.LowStock  5.History  6.Undo  7.Exit");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("SKU: ");
                    String sku = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Category: ");
                    String cat = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Qty: ");
                    int qty = sc.nextInt();
                    ims.addProduct(new Product(sku, name, cat, price, qty));
                    break;

                case 2:
                    System.out.print("SKU: ");
                    ims.updateQuantity(sc.nextLine(), sc.nextInt());
                    break;

                case 3:
                    System.out.print("Sort by (sku/price/value/name): ");
                    ims.display(sc.nextLine());
                    break;

                case 4:
                    ims.lowStock();
                    break;

                case 5:
                    System.out.print("How many? ");
                    ims.showTransactions(sc.nextInt());
                    break;

                case 6:
                    ims.undo();
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}
