import java.util.Scanner;
class Patient { int patientId, age; String name, problem, doctorAssigned; double feePaid;
    Patient(int id, String name, int age, String problem, String doctor, double fee) { this.patientId=id; this.name=name; this.age=age; this.problem=problem; this.doctorAssigned=doctor; this.feePaid=fee; }
    void displayReport() { System.out.printf("Patient ID: %d%nName: %s%nAge: %d%nProblem: %s%nDoctor: %s%nFee Paid: %.2f%n--------------------------%n", patientId,name,age,problem,doctorAssigned,feePaid); }
    void updateDoctor(String doctor) { doctorAssigned=doctor; System.out.println("Doctor Updated!"); } void addFee(double amount) { feePaid+=amount; System.out.println("Fee Added: " + amount); }
}
public class Program3 { static Patient find(Patient[] patients,int count,int id){for(int i=0;i<count;i++)if(patients[i].patientId==id)return patients[i];return null;}
    public static void main(String[] args){ Scanner sc=new Scanner(System.in); Patient[] patients=new Patient[5];int count=0,choice;
        do {System.out.println("\n--- Hospital Menu ---\n1. Register Patient\n2. Update Doctor\n3. Add Fee\n4. Display Patients\n5. Exit");System.out.print("Enter choice: ");choice=sc.nextInt();sc.nextLine();
            if(choice==1){if(count==5){System.out.println("Patient List Full!");continue;}System.out.print("Enter ID: ");int id=sc.nextInt();sc.nextLine();System.out.print("Enter Name: ");String name=sc.nextLine();System.out.print("Enter Age: ");int age=sc.nextInt();sc.nextLine();System.out.print("Enter Problem: ");String problem=sc.nextLine();System.out.print("Enter Doctor: ");String doctor=sc.nextLine();System.out.print("Enter Fee Paid: ");double fee=sc.nextDouble();sc.nextLine();patients[count++]=new Patient(id,name,age,problem,doctor,fee);System.out.println("Patient Registered!");}
            else if(choice==2){System.out.print("Enter Patient ID: ");Patient p=find(patients,count,sc.nextInt());sc.nextLine();if(p!=null){System.out.print("Enter New Doctor: ");p.updateDoctor(sc.nextLine());}}
            else if(choice==3){System.out.print("Enter Patient ID: ");Patient p=find(patients,count,sc.nextInt());System.out.print("Enter Fee Amount: ");double fee=sc.nextDouble();sc.nextLine();if(p!=null)p.addFee(fee);}
            else if(choice==4){for(int i=0;i<count;i++)patients[i].displayReport();}else if(choice==5)System.out.println("Thank You!");else System.out.println("Invalid Choice!");
        }while(choice!=5);sc.close();}
}
