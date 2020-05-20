import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Employee implements Comparable, Cloneable{
    String lastName;
    String firstName;
    String ID;
    String sex;
    Calendar birthDay = new GregorianCalendar();

    // Default constructor
    public Employee() {
        lastName = "";
        firstName = "";
        ID = "";
        sex = "";
        birthDay.set(Calendar.MONTH, 0);
        birthDay.set(Calendar.DAY_OF_MONTH, 0);
        birthDay.set(Calendar.YEAR, 0);
    }
    // Argument constructor
    public Employee(String lastName, String firstName, String ID, String sex, int month, int day, int year) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.ID = ID;
        this.sex = sex;
        birthDay.set(Calendar.MONTH, month);
        birthDay.set(Calendar.DAY_OF_MONTH, day);
        birthDay.set(Calendar.YEAR, year);
    }
    // Setters
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDay() {
        int month = birthDay.get(Calendar.MONTH);
        int day = birthDay.get(Calendar.DAY_OF_MONTH);
        int year = birthDay.get(Calendar.YEAR);
        return Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getID() {
        return ID;
    }

    public String getSex() {
        return sex;
    }

    public void setBirthDay(int month, int day, int year) {
        birthDay.set(Calendar.MONTH, month);
        birthDay.set(Calendar.DAY_OF_MONTH, day);
        birthDay.set(Calendar.YEAR, year);
    }

    public String toString() {
        return "Last name: " + lastName + "\nFirst name: " + firstName + "\n" +
                "ID: " + ID + "\n" +
                "Birth date: " + birthDay.get(Calendar.MONTH) + "/" + birthDay.get(Calendar.DAY_OF_MONTH) + "/" + birthDay.get(Calendar.YEAR) + "\n";
    }

    public abstract double monthlyEarning();

    public int compareTo(Object o) {
        Employee e = (Employee) o;
        if (lastName.equals(e.lastName)) {
            return 0;
        }
        if (lastName.compareTo(e.lastName) < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}

