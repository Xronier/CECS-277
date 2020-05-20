import java.text.DecimalFormat;
import java.util.Calendar;

public class Faculty extends Employee{
    // Create df object to round decimals two places
    DecimalFormat df = new DecimalFormat("#.00");
    Level position;
    Education education;

    // Default constructor
    public Faculty() {
        lastName = "";
        firstName = "";
        ID = "";
        sex = "";
        birthDay.set(Calendar.MONTH, 0);
        birthDay.set(Calendar.DAY_OF_MONTH, 0);
        birthDay.set(Calendar.YEAR, 0);
        position = Level.FullTime;
        education.major = "";
        education.degree = "";
        education.research = 0;
    }
    // Argument constructor
    public Faculty(String lastName, String firstName, String ID, String sex, int month, int day, int year, Level position,
                   String degree, String major, int research) {
        // Use Employee.java's constructor
        super(lastName, firstName, ID, sex, month, day, year);
        this.position = position;
        education = new Education(degree, major, research);
    }

    //Setters
    public void setPosition(Level position) {
        this.position = position;
    }

    public void setEducation(Education education){
        this.education = education;
    }

    // Getters
    public Level getPosition() {
        return position;
    }

    public Education getEducation() {
        return education;
    }

    public double monthlyEarning() {
        // Depending on employee's Level, return their salary
        if (position == Level.Assistant) {
            return EmployeeInfo.FACULTY_MONTHLY_SALARY;
        }
        else if(position == Level.Associate) {
            return EmployeeInfo.FACULTY_MONTHLY_SALARY * 1.5;
        }
        else if(position == Level.FullTime) {
            return EmployeeInfo.FACULTY_MONTHLY_SALARY * 2;
        }
        else {
            return 0.0;
        }
    }

    public String toString() {
        return super.toString() + "Level: " + position + "\n" + "Degree: " + education.getDegree() + "\n" + "Major: " + education.getMajor()
                + "\n" + "Research: " + education.research + "\n" + "Monthly Earning: $" + df.format(monthlyEarning());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Faculty f = (Faculty)super.clone();
        education = (Education)education.clone();
        f.setEducation(education);
        return f;
    }
}
