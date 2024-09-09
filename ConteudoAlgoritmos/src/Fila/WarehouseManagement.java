package Fila;

import java.util.Scanner;

public class WarehouseManagement {
    private static final int MAX_PRODUCTS = 10;
    private static String[] products = new String[MAX_PRODUCTS];
    private static int front = 0;
    private static int rear = -1;
    private static int itemCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWarehouse Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Display Added Products");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (itemCount == MAX_PRODUCTS) {
                        System.out.println("Warehouse is full, cannot add more products.");
                    } else {
                        System.out.print("Enter the product name to add: ");
                        String product = scanner.next();
                        enqueue(product);
                        System.out.println("Product added successfully.");
                    }
                    break;
                case 2:
                    if (itemCount == 0) {
                        System.out.println("Warehouse is empty, cannot remove products.");
                    } else {
                        String removedProduct = dequeue();
                        System.out.println("Product removed: " + removedProduct);
                    }
                    break;
                case 3:
                    displayProducts();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void enqueue(String product) {
        rear = (rear + 1) % MAX_PRODUCTS;
        products[rear] = product;
        itemCount++;
    }

    private static String dequeue() {
        String removedProduct = products[front];
        front = (front + 1) % MAX_PRODUCTS;
        itemCount--;
        return removedProduct;
    }

    private static void displayProducts() {
        if (itemCount == 0) {
            System.out.println("Warehouse is empty.");
        } else {
            System.out.println("Products in the warehouse:");
            for (int i = 0; i < itemCount; i++) {
                int index = (front + i) % MAX_PRODUCTS;
                System.out.println(products[index]);
            }
        }
    }
}

