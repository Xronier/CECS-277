import java.util.ArrayList;

public class vendingMachine {
    ArrayList<Product> products = new ArrayList<>();
    public coinSet vendingCoins = new coinSet(); // coins in machine
    public coinSet userCoins = new coinSet(); // coins inserted by user

    public void addCoins(Coin c) {
        userCoins.addCoin(c);
    }

    public Coin getCoin(char type) {
        if (type == 'a' || type == 'A') {
            return new Coin(0.05, "Nickel");
        }
        else if (type == 'b' || type == 'B') {
            return new Coin(0.10, "Dime");
        }
        else if (type == 'c' || type == 'C') {
            return new Coin(.25, "Quarter");
        }
        else if (type == 'd' || type == 'D') {
            return new Coin(1.0, "Dollar");
        }
        return null;
    }

    public void addProduct(Product p, int quantity) {
        for (int i = 0; i < quantity; i++) {
            products.add(p);
        }
    }

    public double removeMoney() {
        double value = 0.0;
        // Get the amount the vending machine currently has and save it to a temp var
        value += vendingCoins.getValue();
        // clear the money the vending machine has
        if (vendingCoins.set != null) {
            vendingCoins.set.clear();
        }
        return value;
    }

    public coinSet getChange(double neededChange, coinSet s) {
        s.removeAllCoins();
        while (neededChange != 0.0) {
            if (neededChange >= 1.0) {
                s.addCoin(new Coin(1.0, "Dollar"));
                neededChange -= 1.0;
            }
            else if (neededChange >= .25) {
                s.addCoin(new Coin(.25, "Quarter"));
                neededChange -= .25;
            }
            else if (neededChange >= .10) {
                s.addCoin(new Coin(.10, "Dime"));
                neededChange -= .10;
            }
            else if (neededChange >= .05) {
                s.addCoin(new Coin(.5, "Nickel"));
                neededChange -= .05;
            }
            else {
                s.addCoin(new Coin(.01, "Penny"));
                neededChange -= .01;
            }
        }
        return s;
    }

    public void buyProduct(Product p) {
        for (int i = 0; i < products.size(); i++) {
            // Loop through all product names in machine to see if it matches given p name
            if (p.name.equals(products.get(i).name)) {
                // If user inserted exact change
                if (p.price == userCoins.getValue()) {
                    products.remove(i);
                    System.out.println("Purchased " + p.toString());
                    // add inserted coins into the vending machine coinSet
                    for (int j = 0; j < userCoins.set.size(); j++) {
                        vendingCoins.addCoin(userCoins.set.get(j));
                    }
                    // Once the userCoins is transferred to the machine, remove all userCoins
                    userCoins.removeAllCoins();
                    // break to make sure iteration stops after item has been purchased
                    break;
                }
                // If user inserted more than the item costs
                else if (p.price < userCoins.getValue()) {
                    products.remove(i);
                    System.out.println("Purchased " + p.toString());
                    // Get user change
                    String formattedChange = String.format("%.2f", userCoins.getValue() - p.price);
                    userCoins.removeAllCoins();
                    System.out.println("Your change: $" + formattedChange);
                    // Get vending machine change
                    vendingCoins = getChange(vendingCoins. getValue() + p.price, vendingCoins);
                    break;
                }
                // If user hasn't inserted enough money
                else {
                    System.out.println("Insufficient funds");
                    // break to make sure iteration stops after machine finds your item and knows you don't
                    // have enough money
                    break;
                }
            }
        }
    }
}
