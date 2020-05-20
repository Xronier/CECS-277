public class Product {
    String name;
    double price;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        Product p = (Product) o;
        return (name.equals(p.name)) && (Double.compare(price, p.price) == 0);
    }

    public String toString() {
        String formatPrice = String.format("%.2f", price);
        return "Product: " + name + " @ $" + formatPrice;
    }
}
