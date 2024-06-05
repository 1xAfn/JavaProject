import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}

public class SupermarketBillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Product> cart = new HashMap<>();
        double totalBill = 0;

        System.out.println("\nWelcome to the Supermarket Billing System!");

        while (true) {
            System.out.print("Enter product name (or 'done' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter price per item: ");
            double price = Double.parseDouble(scanner.nextLine());

            Product product = new Product(name, price, quantity);
            cart.put(name, product);
            totalBill += product.getTotalPrice();
        }

        System.out.println("\n**** Receipt ****");
        for (Map.Entry<String, Product> entry : cart.entrySet()) {
            Product product = entry.getValue();
            System.out.println(product.getName() + "\t" + product.getQuantity() + "\t$" + product.getTotalPrice());
        }
        System.out.println("Total items: " + cart.size());
        System.out.println("Total bill: $" + totalBill);

        System.out.println("\nThank you for shopping with us!");
    }
}