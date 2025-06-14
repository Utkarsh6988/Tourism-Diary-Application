//Simulate an inventory system using an array to calculate total inventory and average stock 

import java.util.*;

public class InventorySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of products in inventory: ");
        int numProducts = sc.nextInt();
        
        String[] productNames = new String[numProducts];
        int[] productQuantities = new int[numProducts];
        double[] productPrices = new double[numProducts];
        
        
        for (int i = 0; i < numProducts; i++) {
            sc.nextLine(); 
            System.out.println("\nEnter details for product #" + (i + 1));
            
            System.out.print("Product name: ");
            productNames[i] = sc.nextLine();
            
            System.out.print("Quantity in stock: ");
            productQuantities[i] = sc.nextInt();
            
            System.out.print("Unit price: ");
            productPrices[i] = sc.nextDouble();
        }
        
        int totalStock = 0;
        double totalValue = 0.0;
        
        for (int i = 0; i < numProducts; i++) {
            totalStock += productQuantities[i];
            totalValue += productQuantities[i] * productPrices[i];
        }
        
        double averageStock = (double) totalStock / numProducts;
        double averageValue = totalValue / numProducts;

        System.out.println("\n=== Inventory Report ===");
        System.out.println("Total products in inventory: " + numProducts);
        System.out.println("Total quantity in stock: " + totalStock);
        System.out.println("Average stock per product: " + String.format("%.2f", averageStock));
        System.out.println("Total inventory value: $" + String.format("%.2f", totalValue));
        System.out.println("Average product value: $" + String.format("%.2f", averageValue));
        
        
        System.out.println("\n=== Product Details ===");
        for (int i = 0; i < numProducts; i++) {
            System.out.printf("%-20s | Qty: %-5d | Price: $%-7.2f | Value: $%.2f%n",
                            productNames[i],
                            productQuantities[i],
                            productPrices[i],
                            productQuantities[i] * productPrices[i]);
        }
        
        sc.close();
    }
}