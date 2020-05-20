import java.util.*;
public class ascendingIDComparator implements Comparator{
    // Compare 2 objects
    public int compare(Object o1, Object o2) {
        Employee e1 = (Employee)o1;
        Employee e2 = (Employee)o2;

        if (Integer.parseInt(e1.getID()) == Integer.parseInt(e2.getID())) {
            return 0;
        }
        else if (Integer.parseInt(e1.getID()) < Integer.parseInt(e2.getID())) {
            return -1;
        }
        else {
            return 1;
        }
    }
}
