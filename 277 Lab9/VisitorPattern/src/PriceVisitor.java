public class PriceVisitor implements Visitor
{

    public double visit(Product product)
    {
        if(product instanceof LaptopComputer)
        {
            LaptopComputer lc = (LaptopComputer)product;
            if(lc.getBrand().equalsIgnoreCase("Microsoft Surface"))
                lc.setPrice(lc.getPrice()*80/100);
            return lc.getPrice()*lc.getQuantity();
        }

        else if (product instanceof MobilPhone) {
            MobilPhone mp = (MobilPhone)product;
            if (mp.getBrand().equalsIgnoreCase("Apple") && mp.getPrice() > 400.00) {
                mp.setPrice(mp.getPrice() - 30);
            }
            else if (mp.getBrand().equalsIgnoreCase("Samsung") && mp.getModel().equalsIgnoreCase("Galaxy S8")) {
                mp.setPrice(mp.getPrice()*80/100);
            }
            return mp.getPrice()*mp.getQuantity();
        }

        else if (product instanceof VideoGame) {
            VideoGame vg = (VideoGame)product;
            if (vg.getBrand().equalsIgnoreCase("Sony-Playstation")) {
                vg.setPrice(vg.getPrice()*80/100);
            }
            else if (vg.getBrand().equalsIgnoreCase("Microsoft Xbox One") && vg.getQuantity() == 2) {
                vg.setPrice(vg.getPrice()*70/100);
            }
        }

        return 0;
    }
}