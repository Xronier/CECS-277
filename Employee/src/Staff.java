import java.text.DecimalFormat;
import java.util.Calendar;

public class Staff extends Employee {
    double hourlyRate;
    // Initialize df to round decimals two places
    DecimalFormat df = new DecimalFormat("#.00");

    public Staff() {
        lastName = "";
        firstName = "";
        ID = "";
        sex = "";
        birthDay.set(Calendar.MONTH, 0);
        birthDay.set(Calendar.DAY_OF_MONTH, 0);
        birthDay.set(Calendar.YEAR, 0);
        hourlyRate = 0.0;
    }

    public Staff(String lastName, String firstName, String ID, String sex, int month, int day, int year, double hourlyRate) {
        // Use employee's constructor
        super(lastName, firstName, ID, sex, month, day, year);
        this.hourlyRate = hourlyRate;
    }

    // Setter
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    // Getter
    public double getHourlyRate() {
        return hourlyRate;
    }

    public double monthlyEarning() {
        return hourlyRate * EmployeeInfo.STAFF_MONTHLY_HOURS_WORKED;
    }

    public String toString() {
        return super.toString() + "Monthly Salary: $" + df.format(monthlyEarning());
    }
}
