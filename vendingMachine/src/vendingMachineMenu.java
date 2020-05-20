import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class vendingMachineMenu {
    public void Run(vendingMachine machine) {
        Scanner sc = new Scanner(System.in);
        char userInput = ' ';
        while (userInput != 'q') {
            System.out.println("S)how Products, I)nsert Coin, B)uy, A)dd Product, R)emove Coins, Q)uit");
            userInput = sc.next().charAt(0);
            // Show products
            if (userInput == 's' || userInput == 'S') {
                if (machine.products != null && !machine.products.isEmpty()) {
                    // Create a HashSet to print without duplication
                    Set<Product> currentItems = new HashSet<>();
                    currentItems.addAll(machine.products);
                    // Print the items in the HashSet
                    for (Product currentItem : currentItems) {
                        System.out.println(currentItem);
                    }
                }
                else {
                    System.out.println("No products in the machine");
                }
                System.out.println();
            }
            // Insert coin
            else if (userInput == 'i' || userInput == 'I') {
                char coinChoice = ' ';
                // Input validation
                System.out.println("A) Nickel @ $0.05\nB) Dime @ $0.10\nC) Quarter @ $0.25\nD) Dollar @ $1.00");
                coinChoice = sc.next().charAt(0);
                // Based on user input, create a coin object and add it to the user inputted coins.
                machine.addCoins(machine.getCoin(coinChoice));
                System.out.println();
            }
            // Buy product
            else if (userInput == 'b' || userInput == 'B') {
                if (machine.products != null && !machine.products.isEmpty()) {
                    char item = ' ';
                    int i = 0;
                    // Create a HashSet to print without duplication
                    Set<Product> currentItems = new HashSet<>();
                    currentItems.addAll(machine.products);
                    // Print the items in the HashSet
                    for (Product currentItem : currentItems) {
                        System.out.println((char) ('A' + i) + ")" + currentItem);
                        // Increase i to print letters in increasing order
                        i++;
                    }
                    System.out.println("Select a product");
                    item = sc.next().charAt(0);
                    // Make sure character is uppercase to prevent the wrong ascii character from being selected
                    // and subtract 65 to reduce it to 0 for indexing
                    item = (char) (Character.toUpperCase(item) - 65);
                    // Turn the set into an array to allow indexing
                    Object[] selectedItem = currentItems.toArray();
                    machine.buyProduct((Product) selectedItem[item]);
                }
                else {
                    System.out.println("No products in the machine.");
                }
                System.out.println();
            }
            // Add product
            else if (userInput == 'a' || userInput == 'A') {
                String productName;
                double productPrice;
                int quantity;
                System.out.println("Product Name: ");
                productName = sc.next();
                System.out.println("Product Price: ");
                productPrice = sc.nextDouble();
                System.out.println("Quantity: ");
                quantity = sc.nextInt();
                Product p = new Product(productName, productPrice);
                machine.addProduct(p, quantity);
                System.out.println();
            }
            else if (userInput == 'r' || userInput == 'R') {
                String removedMoney = String.format("%.2f", machine.removeMoney());
                System.out.println("Removed: $" + removedMoney);
                System.out.println();
            }
            // Quit
            else {
                userInput = 'q';
            }
        }
    }
}