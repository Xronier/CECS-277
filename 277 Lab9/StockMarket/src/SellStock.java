public class SellStock implements Order
{
    private Stock s;
    int quantity;

    public SellStock(Stock s, int quantity)
    {
        super();
        this.s = s;
        this.quantity = quantity;
    }

    public void execute()
    {
        s.sell(quantity);
    }
}
