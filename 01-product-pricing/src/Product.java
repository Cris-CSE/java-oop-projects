import java.util.Scanner;

public class Product {

    public double setPrice(int category) {

        double price;

        // Define the product price according to the following conditionals: if, else and return.
        if (category == 1) {
            price = 4.5;
        } else if (category == 2) {
            price = 3.5;
        } else {
            price = 2.5;
        }

        return price;
    }

    public void credit(double totalPrice) {

        double parcialPayment;

        parcialPayment = totalPrice / 3;

        // Displays the balance payable for each month
        for (int month = 0; month <= 3; month++) {
            System.out.printf("Balance payable of Month %d ---> %.2f%n", month, totalPrice);
            totalPrice = totalPrice - parcialPayment;
        }
    }

    public static void main(String args[]) {

        int productType;
        int quantity;
        double totalPrice;

        Scanner selection = new Scanner(System.in);

        System.out.println("Which product would you like to order? 1, 2 or 3?");
        productType = selection.nextInt();

        System.out.println("How many products would you like to order?");
        quantity = selection.nextInt();

        // Creates an object of the Product class
        Product prod = new Product();

        totalPrice = quantity * prod.setPrice(productType);

        System.out.printf("The total price of your order is: %.2f%n", totalPrice);

        prod.credit(totalPrice);

        selection.close();
    }
}
