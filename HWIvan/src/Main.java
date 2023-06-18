import model.*;
import service.Calculations;

import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws Exception {
        Calculations calculation = new Calculations();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Your order:");
        addItems(calculation, scanner, Laptop::new, "Enter the count of laptops: ");
        addItems(calculation, scanner, Mouse::new, "Enter the count of mice: ");
        addItems(calculation, scanner, Desktop::new, "Enter the count of desktops: ");
        addItems(calculation, scanner, Monitor::new, "Enter the count of LCD monitors: ");

        calculation.calculateContainers();
    }

    /**
     * Helper function to add specified items to the calculations.
     *
     * @param calculation Calculations instance.
     * @param scanner Scanner instance.
     * @param supplier Supplier to create new instances of a specific item.
     * @param message Prompt message to ask for item quantity.
     */
    private static void addItems(Calculations calculation, Scanner scanner, Supplier<Item> supplier, String message) {
        System.out.print(message);
        int count = getValidInt(scanner);
        for (int i = 0; i < count; i++) {
            calculation.addItem(supplier.get());
        }
    }

    /**
     * Prompts the user for an integer input. Continues prompting until a non-negative integer is entered.
     *
     * @param scanner Scanner instance.
     * @return a non-negative integer.
     */
    private static int getValidInt(Scanner scanner) {
        int count = -1;
        while (count < 0) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a non-negative value.");
                scanner.next(); // consume the invalid token
            } else {
                count = scanner.nextInt();
                if (count < 0) {
                    System.out.println("Invalid input. Please enter a non-negative value.");
                }
            }
        }
        return count;
    }
}
