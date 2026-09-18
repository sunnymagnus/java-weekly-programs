import java.util.Scanner;

class Student {
    // Attributes
    String name;
    int rollNo;
    int marks[];
    int total;
    double average;

    // Constructor (dynamic marks input)
    Student(int rollNo, String name, int n) {
        this.rollNo = rollNo;
        this.name = name;
        marks = new int[n];
    }

    // Input marks
    void inputMarks(Scanner sc) {
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter mark " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    // Compute total
    void computeTotal() {
        total = 0;
        for (int i = 0; i < marks.length; i++) {
            total = total + marks[i];
        }
    }

    // Compute average
    void computeAverage() {
        average = (double) total / marks.length;
    }

    // Grade method
    char grade() {
        if (average >= 90) return 'A';
        else if (average >= 75) return 'B';
        else if (average >= 60) return 'C';
        else if (average >= 50) return 'D';
        else return 'F';
    }

    // Display result
    void displayResult() {
        System.out.println("\nRoll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade());
        System.out.println("----------------------");
    }
}

public class Result {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] s = new Student[10]; // array of 10 students

        for (int i = 0; i < 10; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Enter Roll No: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter number of subjects: ");
            int n = sc.nextInt();

            s[i] = new Student(roll, name, n);
            s[i].inputMarks(sc);

            s[i].computeTotal();
            s[i].computeAverage();
        }

        // Display all results
        System.out.println("\n--- Student Results ---");
        for (int i = 0; i < 10; i++) {
            s[i].displayResult();
        }

        sc.close();
    }
}
