public class Stock
{
    private String name;
    private double price;

    public Stock(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public void buy(int quantity)
    {
        System.out.println("BOUGHT: " + name +"\nQuantity: " + quantity );
        System.out.println(price +" per share.");
        System.out.println("Total: "+ quantity * price);
    }

    public void sell(int quantity)
    {
        System.out.println("SOLD: " + name +"\nQuantity: " + quantity );
        System.out.println(price +" per share.");
        System.out.println("Total: "+ quantity * price);
    }

    public String toString()
    {
        return "Product [name=" + name + ", price=" + price + "]";
    }
}
