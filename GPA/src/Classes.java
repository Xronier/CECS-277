import java.util.ArrayList;
public class Classes {
    ArrayList<Classes> classes; // check
    String className;
    char grade;
    double units;

    /**
     * @param className Class student has taken
     * @param grade Grade student got in said class
     * @param units Amount of units said class is worth
     */
    public Classes(String className, char grade, double units) {
        this.className = className;
        this.grade = grade;
        this.units = units;
    }

    public String toString() {
       return (this.className + " " + this.grade + " " + this.units + " \n");
    }
}
