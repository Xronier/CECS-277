import java.util.Arrays;
/*
 This application allows you to create employee objects and organize them into smaller categories such as faculty, part time, etc.
 @author Elijah Espiritu
 */

public class LAB2Main {
    public static void main(String[] args) throws CloneNotSupportedException{
        Employee[] e = new Employee[9];
        // Create array with objects
        e[0] = new Staff("Paita", "Allen", "123", "M", 2, 23, 1959, 50.0);
        e[1] = new Staff("Zapata", "Steven", "456", "F", 7, 12, 1964, 35);
        e[2] = new Staff("Enrique", "Rios", "789", "M", 6, 2, 1970, 40);
        e[3] = new Faculty("Johnson", "Anne", "243", "F", 4, 27, 1962, Level.FullTime, "Ph.D", "Engineering", 3);
        e[4] = new Faculty("Bouris", "William", "791", "F", 3, 14, 1975, Level.Associate, "Ph.D", "English", 1);
        e[5] = new Faculty("Andrade", "Christopher", "623", "F", 5, 22, 1980, Level.Assistant, "MS", "Physical Education", 0);
        e[6] = new partTime("Guzman", "Augusto", "455", "F", 8, 10, 1977, 35, 30);
        e[7] = new partTime("Depirro", "Martin", "678", "F", 9, 15, 1987, 30, 15);
        e[8] = new partTime("Aldaco", "Marque", "945", "M", 11, 24, 1988, 20, 35);

        // Print employee information
        System.out.println("A. Print all employee information");
        for (int i = 0; i < 9; i++) {
            System.out.println(e[i].toString());
        }
        System.out.println("--------------------------------------");
        // Print total monthly salary for part time employees
        System.out.println("B. Print total salary for part time employees");
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (e[i] instanceof partTime) {
                sum += e[i].monthlyEarning();
            }
        }
        System.out.println("$" + sum + ".00");

        System.out.println("--------------------------------------");
        // Print total monthly salary for all employees
        System.out.println("C. Print total salary for all employees");
        sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += e[i].monthlyEarning();
        }
        System.out.println("$" + sum + ".00");
        System.out.println("--------------------------------------");
        // Print all employee info ascending based on employee id
        System.out.println("D. Print employee info in ascending order based on id");
        Arrays.sort(e, new ascendingIDComparator());
        for (int i = 0; i < 9; i++) {
            System.out.println(e[i]);
        }
        // Print all employee info descending based on employee last name
        System.out.println("--------------------------------------");
        System.out.println("E. Print all employee info in descending order based on last name");
        Arrays.sort(e);
        for (int i = e.length - 1; i >= 0; i--) {
            System.out.println(e[i]);
        }
        System.out.println("--------------------------------------");
        // Clone a faculty object
        System.out.println("F. Clone");
        Faculty fac = new Faculty("Johnson", "Anne", "243", "F", 4, 27, 1962, Level.FullTime, "Ph.D", "Engineering", 3);
        Education edu = new Education("BS", "Philosophy", 2);
        Faculty facClone = (Faculty)fac.clone();
        facClone.setEducation(edu);
        System.out.println("Original" + "\n" + fac.toString());
        System.out.println("Clone" + "\n" + facClone.toString());
    }
}
