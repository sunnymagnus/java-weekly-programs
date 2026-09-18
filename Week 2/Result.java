import java.util.Scanner;
class Student { String name; int rollNo; int[] marks; int total; double average;
    Student(int rollNo,String name,int subjects){this.rollNo=rollNo;this.name=name;marks=new int[subjects];}
    void inputMarks(Scanner sc){for(int i=0;i<marks.length;i++){System.out.print("Enter mark "+(i+1)+": ");marks[i]=sc.nextInt();}}
    void computeTotal(){total=0;for(int mark:marks)total+=mark;} void computeAverage(){average=(double)total/marks.length;}
    char grade(){return average>=90?'A':average>=75?'B':average>=60?'C':average>=50?'D':'F';}
    void displayResult(){System.out.printf("%nRoll No: %d%nName: %s%nTotal: %d%nAverage: %.2f%nGrade: %c%n----------------------%n",rollNo,name,total,average,grade());}
}
public class Result { public static void main(String[] args){Scanner sc=new Scanner(System.in);Student[] students=new Student[10];for(int i=0;i<students.length;i++){System.out.println("\nEnter details for Student "+(i+1));System.out.print("Enter Roll No: ");int roll=sc.nextInt();sc.nextLine();System.out.print("Enter Name: ");String name=sc.nextLine();System.out.print("Enter number of subjects: ");int count=sc.nextInt();while(count<=0){System.out.print("Enter a positive number of subjects: ");count=sc.nextInt();}students[i]=new Student(roll,name,count);students[i].inputMarks(sc);students[i].computeTotal();students[i].computeAverage();}System.out.println("\n--- Student Results ---");for(Student student:students)student.displayResult();sc.close();} }
