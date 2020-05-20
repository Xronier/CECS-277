import java.util.Scanner;
import java.util.ArrayList;
public class MainMethod {
    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<>();
        String userChoice = " ";
        Scanner sc = new Scanner(System.in);

        while (!userChoice.equalsIgnoreCase("4")) {
            String brand;
            String model;
            double price;
            int quantity;

            System.out.println("1. Order Laptop" + "\n" +
                    "2. Order Mobile Phone" + "\n" +
                    "3. Order Video Game" + "\n" +
                    "4. Quit and show items");
            userChoice = sc.nextLine();


            switch (userChoice) {
                case "1":
                    System.out.println("Enter order details:");
                    System.out.println("Enter brand name: ");
                    brand = sc.nextLine();
                    System.out.println("Enter price: ");
                    price = sc.nextDouble();
                    System.out.println("Enter quantity: ");
                    quantity = sc.nextInt();
                    LaptopComputer laptop = new LaptopComputer(brand, price, quantity);
                    laptop.accept(new PriceVisitor());
                    productList.add(laptop);
                    break;

                case "2":
                    System.out.println("Enter order details:");
                    System.out.println("Enter brand name: ");
                    brand = sc.nextLine();
                    System.out.println("Enter model: ");
                    model = sc.nextLine();
                    System.out.println("Enter price: ");
                    price = sc.nextDouble();
                    System.out.println("Enter quantity: ");
                    quantity = sc.nextInt();
                    MobilPhone phone = new MobilPhone(brand, model, price, quantity);
                    phone.accept(new PriceVisitor());
                    productList.add(phone);
                    break;

                case "3":
                    System.out.println("Enter order details:");
                    System.out.println("Enter brand name: ");
                    brand = sc.nextLine();
                    System.out.println("Enter price: ");
                    price = sc.nextDouble();
                    System.out.println("Enter quantity: ");
                    quantity = sc.nextInt();
                    VideoGame console = new VideoGame(brand, price, quantity);
                    console.accept(new PriceVisitor());
                    productList.add(console);
                    break;

                case "4":
                    for (Product p : productList) {
                        p.display();
                    }
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
            sc.nextLine();
        }
    }
}
