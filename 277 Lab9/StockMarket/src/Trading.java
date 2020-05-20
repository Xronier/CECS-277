import java.util.ArrayList;
import java.util.List;

public class Trading
{
    private List<Order> orders;

    public Trading()
    {
        orders = new ArrayList<>();
    }


    public void takeOrders(List<Order> list)
    {
        orders.addAll(list);
    }

    public void executeOrders()
    {
        for (Order order : orders) {
            order.execute();
        }
    }
}
