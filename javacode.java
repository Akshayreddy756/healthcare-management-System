
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Patient {
    private String name;
    private int age;
    private String gender;
    private String medicalHistory;
    private String username;
    private String password;
    private MedicalRecord medicalRecord;

    public Patient(String name, int age, String gender, String medicalHistory, String username, String password) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.medicalHistory = medicalHistory;
        this.username = username;
        this.password = password;
        this.medicalRecord = new MedicalRecord();
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nGender: " + gender + "\nMedical History: " + medicalHistory;
    }
}

class Doctor {
    private String name;
    private String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }
    public String toString() {
        return "Name: " + name + "\nSpecialization: " + specialization;
    }
}

class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }
    public String toString() {
        return "Patient: " + patient.getName() + "\nDoctor: " + doctor.getName() + "\nDate: " + date;
    }
}

class Billing {
    private Patient patient;
    private double amount;
    private String billingDate;

    public Billing(Patient patient, double amount, String billingDate) {
        this.patient = patient;
        this.amount = amount;
        this.billingDate = billingDate;
    }
    public String toString() {
        return "Patient: " + patient.getName() + "\nAmount: $" + amount + "\nBilling Date: " + billingDate;
    }
}

class MedicalRecord {
    private List<String> records;

    public MedicalRecord() {
        this.records = new ArrayList<>();
    }

    public void addRecord(String record) {
        records.add(record);
    }

    public List<String> getRecords() {
        return records;
    }
}

class HealthcareSystem {
    private Map<String, Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;
    private List<Billing> billings;
    private Scanner scanner;

    public HealthcareSystem() {
        patients = new HashMap<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
        billings = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    addDoctor();
                    break;
                case 4:
                    viewDoctors();
                    break;
                case 5:
                    scheduleAppointment();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 7:
                    addBilling();
                    break;
                case 8:
                    viewBillings();
                    break;
                case 9:
                    addMedicalRecord();
                    break;
                case 10:
                    viewMedicalRecords();
                    break;
                case 11:
                    patientPortal();
                    break;
                case 12:
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("Healthcare Management System");
        System.out.println("1. Add Patient");
        System.out.println("2. View Patients");
        System.out.println("3. Add Doctor");
        System.out.println("4. View Doctors");
        System.out.println("5. Schedule Appointment");
        System.out.println("6. View Appointments");
        System.out.println("7. Add Billing");
        System.out.println("8. View Billings");
        System.out.println("9. Add Medical Record");
        System.out.println("10. View Medical Records");
        System.out.println("11. Patient Portal");
        System.out.println("12. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addPatient() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter patient gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter patient medical history: ");
        String medicalHistory = scanner.nextLine();
        System.out.print("Set a username for the patient: ");
        String username = scanner.nextLine();
        System.out.print("Set a password for the patient: ");
        String password = scanner.nextLine();

        Patient patient = new Patient(name, age, gender, medicalHistory, username, password);
        patients.put(username, patient);

        System.out.println("Patient added successfully!");
    }

    private void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients in the system.");
        } else {
            System.out.println("List of Patients:");
            for (Patient patient : patients.values()) {
                System.out.println(patient);
            }
        }
    }

    private void addDoctor() {
        System.out.print("Enter doctor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter doctor specialization: ");
        String specialization = scanner.nextLine();

        Doctor doctor = new Doctor(name, specialization);
        doctors.add(doctor);

        System.out.println("Doctor added successfully!");
    }

    private void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors in the system.");
        } else {
            System.out.println("List of Doctors:");
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
            }
        }
    }

    private void scheduleAppointment() {
        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println("You must have patients and doctors to schedule an appointment.");
        } else {
            System.out.println("Available Patients:");
            for (Patient patient : patients.values()) {
                System.out.println(patient.getUsername() + ". " + patient.getName());
            }

class Patient {
    private String name;
    private int age;
    private String gender;
    private String medicalHistory;
    private String username;
    private String password;
    private MedicalRecord medicalRecord;

    public Patient(String name, int age, String gender, String medicalHistory, String username, String password) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.medicalHistory = medicalHistory;
        this.username = username;
        this.password = password;
        this.medicalRecord = new MedicalRecord();
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nGender: " + gender + "\nMedical History: " + medicalHistory;
    }
}

class Doctor {
    private String name;
    private String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }
    public String toString() {
        return "Name: " + name + "\nSpecialization: " + specialization;
    }
}

class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }
    public String toString() {
        return "Patient: " + patient.getName() + "\nDoctor: " + doctor.getName() + "\nDate: " + date;
    }
}

class Billing {
    private Patient patient;
    private double amount;
    private String billingDate;

    public Billing(Patient patient, double amount, String billingDate) {
        this.patient = patient;
        this.amount = amount;
        this.billingDate = billingDate;
    }
    public String toString() {
        return "Patient: " + patient.getName() + "\nAmount: $" + amount + "\nBilling Date: " + billingDate;
    }
}

class MedicalRecord {
    private List<String> records;

    public MedicalRecord() {
        this.records = new ArrayList<>();
    }

    public void addRecord(String record) {
        records.add(record);
    }

    public List<String> getRecords() {
        return records;
    }
}

class HealthcareSystem {
    private Map<String, Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;
    private List<Billing> billings;
    private Scanner scanner;

    public HealthcareSystem() {
        patients = new HashMap<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
        billings = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    addDoctor();
                    break;
                case 4:
                    viewDoctors();
                    break;
                case 5:
                    scheduleAppointment();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 7:
                    addBilling();
                    break;
                case 8:
                    viewBillings();
                    break;
                case 9:
                    addMedicalRecord();
                    break;
                case 10:
                    viewMedicalRecords();
                    break;
                case 11:
                    patientPortal();
                    break;
                case 12:
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("Healthcare Management System");
        System.out.println("1. Add Patient");
        System.out.println("2. View Patients");
        System.out.println("3. Add Doctor");
        System.out.println("4. View Doctors");
        System.out.println("5. Schedule Appointment");
        System.out.println("6. View Appointments");
        System.out.println("7. Add Billing");
        System.out.println("8. View Billings");
        System.out.println("9. Add Medical Record");
        System.out.println("10. View Medical Records");
        System.out.println("11. Patient Portal");
        System.out.println("12. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addPatient() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter patient gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter patient medical history: ");
        String medicalHistory = scanner.nextLine();
        System.out.print("Set a username for the patient: ");
        String username = scanner.nextLine();
        System.out.print("Set a password for the patient: ");
        String password = scanner.nextLine();

        Patient patient = new Patient(name, age, gender, medicalHistory, username, password);
        patients.put(username, patient);

        System.out.println("Patient added successfully!");
    }

    private void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients in the system.");
        } else {
            System.out.println("List of Patients:");
            for (Patient patient : patients.values()) {
                System.out.println(patient);
            }
        }
    }

    private void addDoctor() {
        System.out.print("Enter doctor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter doctor specialization: ");
        String specialization = scanner.nextLine();

        Doctor doctor = new Doctor(name, specialization);
        doctors.add(doctor);

        System.out.println("Doctor added successfully!");
    }

    private void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors in the system.");
        } else {
            System.out.println("List of Doctors:");
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
            }
        }
    }

    private void scheduleAppointment() {
        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println("You must have patients and doctors to schedule an appointment.");
        } else {
            System.out.println("Available Patients:");
            for (Patient patient : patients.values()) {
                System.out.println(patient.getUsername() + ". " + patient.getName());
            }

            System.out.println("Available Doctors:");
            for (int i = 0; i < doctors.size(); i++) {
                System.out.println((i + 1) + ". " + doctors.get(i).getName());
            }

            System.out.print("Select a patient (enter the username): ");
            String patientUsername = scanner.nextLine();
            System.out.print("Select a doctor (enter the number): ");
            int doctorChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Patient selectedPatient = patients.get(patientUsername);

            if (selectedPatient != null && doctorChoice > 0 && doctorChoice <= doctors.size()) {
                Doctor selectedDoctor = doctors.get(doctorChoice - 1);
                System.out.print("Enter appointment date (e.g., DD/MM/YYYY): ");
                String date = scanner.nextLine();

                Appointment appointment = new Appointment(selectedPatient, selectedDoctor, date);
                appointments.add(appointment);

                System.out.println("Appointment scheduled successfully!");
            } else {
                System.out.println("Invalid patient or doctor selection.");
            }
        }
    }

    private void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            System.out.println("List of Appointments:");
            for (int i = 0; i < appointments.size(); i++) {
                System.out.println("Appointment " + (i + 1) + ":\n" + appointments.get(i));
            }
        }
    }

    private void addBilling() {
        if (patients.isEmpty()) {
            System.out.println("You must have patients to add billing information.");
        } else {
            System.out.println("Available Patients:");
            for (Patient patient : patients.values()) {
                System.out.println(patient.getUsername() + ". " + patient.getName());
            }

            System.out.print("Select a patient (enter the username): ");
            String patientUsername = scanner.nextLine();
            Patient selectedPatient = patients.get(patientUsername);

            if (selectedPatient != null) {
                System.out.print("Enter billing amount: $");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character

                System.out.print("Enter billing date (e.g., DD/MM/YYYY): ");
                String billingDate = scanner.nextLine();

                Billing billing = new Billing(selectedPatient, amount, billingDate);
                billings.add(billing);

                System.out.println("Billing information added successfully!");
            } else {
                System.out.println("Invalid patient selection.");
            }
        }
    }

    private void viewBillings() {
        if (billings.isEmpty()) {
            System.out.println("No billing information available.");
        } else {
            System.out.println("List of Billing Information:");
            for (int i = 0; i < billings.size(); i++) {
                System.out.println("Billing " + (i + 1) + ":\n" + billings.get(i));
            }
        }
    }

    private void addMedicalRecord() {
        System.out.print("Enter patient username to add a medical record: ");
        String patientUsername = scanner.nextLine();

        Patient patient = patients.get(patientUsername);
        if (patient != null) {
            System.out.print("Enter medical record description: ");
            String record = scanner.nextLine();
            patient.getMedicalRecord().addRecord(record);
            System.out.println("Medical record added successfully!");
        } else {
            System.out.println("Patient not found.");
        }
    }

    private void viewMedicalRecords() {
        System.out.print("Enter patient username: ");
        String patientUsername = scanner.nextLine();

        Patient patient = patients.get(patientUsername);

        if (patient != null) {
            System.out.print("Enter patient password: ");
            String patientPassword = scanner.nextLine();

            if (patient.getPassword().equals(patientPassword)) {
                List<String> records = patient.getMedicalRecord().getRecords();
                if (records.isEmpty()) {
                    System.out.println("No medical records available for this patient.");
                } else {
                    System.out.println("Medical Records for " + patient.getUsername() + ":");
                    for (int i = 0; i < records.size(); i++) {
                        System.out.println((i + 1) + ". " + records.get(i));
                    }
                }
            } else {
                System.out.println("Invalid password. Access denied.");
            }
        } else {
            System.out.println("Patient not found.");
        }
    }

    private void patientPortal() {
        System.out.println("Patient Portal");
        System.out.print("Enter patient username: ");
        String patientUsername = scanner.nextLine();
        System.out.print("Enter patient password: ");
        String patientPassword = scanner.nextLine();

        Patient patient = patients.get(patientUsername);
        if (patient != null && patient.getPassword().equals(patientPassword)) {
            System.out.println("Welcome, " + patient.getName() + "!");
            while (true) {
                displayPatientPortalMenu();
                int portalChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (portalChoice) {
                    case 1:
                        viewMedicalRecords();
                        break;
                    case 2:
                        return; // Return to the main menu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid credentials. Access denied.");
        }
    }

    private void displayPatientPortalMenu() {
        System.out.println("Patient Portal Menu");
        System.out.println("1. View Medical Records");
        System.out.println("2. Exit Patient Portal");
        System.out.print("Enter your choice: ");
    }
    private void exit() {
        System.out.println("Exiting...");
        System.exit(0);
    }
   public static void main(String[] args) {
        HealthcareSystem healthcareSystem = new HealthcareSystem();
        healthcareSystem.run();
    }
}
