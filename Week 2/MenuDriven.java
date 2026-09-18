import java.util.Scanner;

class Patient {
    // Attributes
    int patientId;
    String name;
    int age;
    String problem;
    String doctorAssigned;
    double feePaid;

    // Parameterized Constructor using 'this'
    Patient(int patientId, String name, int age, String problem, String doctorAssigned, double
feePaid) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.problem = problem;
        this.doctorAssigned = doctorAssigned;
        this.feePaid = feePaid;
    }

    // Display Report
    void displayReport() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Problem: " + problem);
        System.out.println("Doctor: " + doctorAssigned);
        System.out.println("Fee Paid: " + feePaid);
        System.out.println("--------------------------");
    }

    // Update Doctor
    void updateDoctor(String doctor) {
        doctorAssigned = doctor;
        System.out.println("Doctor Updated!");
    }

    // Add Fee
    void addFee(double amount) {
        feePaid = feePaid + amount;
        System.out.println("Fee Added: " + amount);
    }
}

public class MenuDriven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Patient[] p = new Patient[5]; // store up to 5 patients
        int count = 0;
        int choice;

        do {
            System.out.println("\n--- Hospital Menu ---");
            System.out.println("1. Register Patient");
            System.out.println("2. Update Doctor");
            System.out.println("3. Add Fee");
            System.out.println("4. Display Patients");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            int id, age;
            String name, problem, doctor;
            double fee;

            switch (choice) {

                case 1:
                    if (count < 5) {
                        System.out.print("Enter ID: ");
                        id = sc.nextInt();
                        sc.nextLine();

                        boolean duplicate = false;
                        for (int i = 0; i < count; i++) {
                            if (p[i].patientId == id) duplicate = true;
                        }
                        if (duplicate) {
                            System.out.println("Patient ID already exists!");
                            break;
                        }

                        System.out.print("Enter Name: ");
                        name = sc.nextLine();

                        System.out.print("Enter Age: ");
                        age = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Problem: ");
                        problem = sc.nextLine();

                        System.out.print("Enter Doctor: ");
                        doctor = sc.nextLine();

                        System.out.print("Enter Fee Paid: ");
                        fee = sc.nextDouble();

                        if (fee < 0) {
                            System.out.println("Fee cannot be negative!");
                            break;
                        }

                        p[count] = new Patient(id, name, age, problem, doctor, fee);
                        count++;

                        System.out.println("Patient Registered!");
                    } else {
                        System.out.println("Patient List Full!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Patient ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    boolean doctorFound = false;
                    for (int i = 0; i < count; i++) {
                        if (p[i].patientId == id) {
                            System.out.print("Enter New Doctor: ");
                            doctor = sc.nextLine();
                            p[i].updateDoctor(doctor);
                            doctorFound = true;
                        }
                    }
                    if (!doctorFound) System.out.println("Patient not found!");
                    break;

                case 3:
                    System.out.print("Enter Patient ID: ");
                    id = sc.nextInt();

                    System.out.print("Enter Fee Amount: ");
                    fee = sc.nextDouble();

                    if (fee < 0) {
                        System.out.println("Fee cannot be negative!");
                        break;
                    }

                    boolean feeFound = false;
                    for (int i = 0; i < count; i++) {
                        if (p[i].patientId == id) {
                            p[i].addFee(fee);
                            feeFound = true;
                        }
                    }
                    if (!feeFound) System.out.println("Patient not found!");
                    break;

                case 4:
                    for (int i = 0; i < count; i++) {
                        p[i].displayReport();
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
