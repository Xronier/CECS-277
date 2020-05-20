import java.util.Calendar;

public class partTime extends Staff {
    int weeklyHours;

    // Default constructor
    public partTime() {
        lastName = "";
        firstName = "";
        ID = "";
        sex = "";
        birthDay.set(Calendar.MONTH, 0);
        birthDay.set(Calendar.DAY_OF_MONTH, 0);
        birthDay.set(Calendar.YEAR, 0);
        hourlyRate = 0.0;
        weeklyHours = 0;
    }

    // Argument constructor
    public partTime(String lastName, String firstName, String ID, String sex, int month, int day, int year, double hourlyRate, int weeklyHours) {
        // Use staff's constructor
        super(lastName, firstName, ID, sex, month, day, year, hourlyRate);
        this.weeklyHours = weeklyHours;
    }

    //Setter
    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    // Getter
    public int getWeeklyHours() {
        return weeklyHours;
    }


    public double monthlyEarning() {
        return weeklyHours * super.hourlyRate * 4;
    }

    public String toString() {
        return super.toString() + "\n" + "Hours worked per week: " + weeklyHours;
    }
}

