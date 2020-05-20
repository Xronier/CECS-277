import java.text.DecimalFormat;

public class createReportCard {
    DecimalFormat df = new DecimalFormat("#.00");
    Student st;

    /**
     *
     * @param st Used to create a report card for a given student st
     */
    public createReportCard(Student st) {
        this.st = st;
    }

    public String toString() {
        String reportCard = st.firstName + " " + st.lastName + "'s Report Card \n";
        for (Classes c : st.classes) {
            reportCard += "Class: " + c.className + ", Grade: " + c.grade + ", Units: " + c.units + "\n";
        }
        reportCard += "GPA: " + df.format(st.GPA);
        return reportCard;
    }
}
