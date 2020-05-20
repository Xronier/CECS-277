import java.util.ArrayList;

public class GPA {
    /**
     *
     * @param c an ArrayList with classes, used to determine GPA
     * @return Returns the overall GPA of determined from c
     */
    public double calcGPA(ArrayList<Classes> c) {
        // (credit * grade weight) / credit
        double gradePointSum = 0;
        double gpa = 0;
        double units = 0;
        for (Classes cl : c) {
            if (cl.grade == 'A') {
                gradePointSum += 4 * cl.units;
                units += cl.units;
            } else if (cl.grade == 'B') {
                gradePointSum += 3 * cl.units;
                units += cl.units;
            } else if (cl.grade == 'C') {
                gradePointSum += 2 * cl.units;
                units += cl.units;
            } else if (cl.grade == 'D') {
                gradePointSum += 1 * cl.units;
                units += cl.units;
            } else {
                gradePointSum += 0 * cl.units;
                units += cl.units;
            }
        }
        gpa = gradePointSum / units;

        return gpa;
    }
}
