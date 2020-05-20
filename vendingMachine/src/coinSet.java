import java.util.ArrayList;

public class coinSet {
    public ArrayList<Coin> set = new ArrayList<>();

    // Add one given coin
    public void addCoin(Coin c) {
        set.add(c);
    }

    // Add a set of given coins
    public void addCoins(coinSet s) {
        // for the size of the given s, add the items to the current set
        for (int i = 0; i < s.set.size(); i++) {
            set.add(s.set.get(i));
        }
    }

    public double getValue() {
        double value = 0.0;
        if (set == null) {
            return value;
        }
        for(Coin c: set) {
            value += c.value;
        }
        return value;
    }

    public void removeAllCoins() {
        set.clear();
    }
}