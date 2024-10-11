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
    private String allergies;
    private String medications;
    private String username;
    private String password;
    private MedicalRecord medicalRecord;

    public Patient(String name, int age, String gender, String medicalHistory, String allergies, String medications, String username, String password) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.medicalHistory = medicalHistory;
        this.allergies = allergies;
        this.medications = medications;
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

    public String getAllergies() {
        return allergies;
    }

    public String getMedications() {
        return medications;
    }

    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nGender: " + gender + "\nMedical History: " + medicalHistory + "\nAllergies: " + allergies + "\nMedications: " + medications;
    }
}

class Doctor {
    private String name;
    private String specialization;
    private List<Appointment> appointments;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.appointments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public String toString() {
        return "Name: " + name + "\nSpecialization: " + specialization + "\nAppointments: " + appointments.size();
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
            scanner.nextLine(); 

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
                    searchPatientByName();
                    break;
                case 12:
                    searchDoctorByName();
                    break;
                case 13:
                    patientPortal();
                    break;
                case 14:
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
        System.out.println("11. Search Patient by Name");
        System.out.println("12. Search Doctor by Name");
        System.out.println("13. Patient Portal");
        System.out.println("14. Exit");
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
        System.out.print("Enter patient allergies: ");
        String allergies = scanner.nextLine();
        System.out.print("Enter patient medications: ");
        String medications = scanner.nextLine();
        System.out.print("Set a username for the patient: ");
        String username = scanner.nextLine();
        System.out.print("Set a password for the patient: ");
        String password = scanner.nextLine();

        Patient patient = new Patient(name, age, gender, medicalHistory, allergies, medications, username, password);
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

    private void searchPatientByName() {
        System.out.print("Enter patient name to search: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Patient patient : patients.values()) {
            if (patient.getName().equalsIgnoreCase(name)) {
                System.out.println(patient);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Patient not found.");
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

    private void searchDoctorByName() {
        System.out.print("Enter doctor name to search: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                System.out.println(doctor);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Doctor not found.");
        }
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

            System.out.print("Enter patient username: ");
            String patientUsername = scanner.nextLine();
            Patient patient = patients.get(patientUsername);

            if (patient == null) {
                System.out.println("Invalid patient username.");
                return;
            }

            System.out.print("Enter doctor number: ");
            int doctorNumber = scanner.nextInt();
            scanner.nextLine();

            if (doctorNumber <= 0 || doctorNumber > doctors.size()) {
                System.out.println("Invalid doctor number.");
                return;
            }

            Doctor doctor = doctors.get(doctorNumber - 1);

            System.out.print("Enter appointment date (YYYY-MM-DD): ");
            String date = scanner.nextLine();

            Appointment appointment = new Appointment(patient, doctor, date);
            appointments.add(appointment);
            doctor.addAppointment(appointment);

            System.out.println("Appointment scheduled successfully!");
        }
    }

    private void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            System.out.println("List of Appointments:");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    private void addBilling() {
        System.out.print("Enter patient username: ");
        String username = scanner.nextLine();

        Patient patient = patients.get(username);
        if (patient == null) {
            System.out.println("Invalid patient username.");
            return;
        }

        System.out.print("Enter billing amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter billing date (YYYY-MM-DD): ");
        String billingDate = scanner.nextLine();

        Billing billing = new Billing(patient, amount, billingDate);
        billings.add(billing);

        System.out.println("Billing added successfully!");
    }

    private void viewBillings() {
        if (billings.isEmpty()) {
            System.out.println("No billings in the system.");
        } else {
            System.out.println("List of Billings:");
            for (Billing billing : billings) {
                System.out.println(billing);
            }
        }
    }

    private void addMedicalRecord() {
        System.out.print("Enter patient username: ");
        String username = scanner.nextLine();

        Patient patient = patients.get(username);
        if (patient == null) {
            System.out.println("Invalid patient username.");
            return;
        }

        System.out.print("Enter medical record entry: ");
        String record = scanner.nextLine();

        patient.getMedicalRecord().addRecord(record);
        System.out.println("Medical record added successfully!");
    }

    private void viewMedicalRecords() {
        System.out.print("Enter patient username: ");
        String username = scanner.nextLine();

        Patient patient = patients.get(username);
        if (patient == null) {
            System.out.println("Invalid patient username.");
            return;
        }

        List<String> records = patient.getMedicalRecord().getRecords();
        if (records.isEmpty()) {
            System.out.println("No medical records for this patient.");
        } else {
            System.out.println("Medical Records for " + patient.getName() + ":");
            for (String record : records) {
                System.out.println("- " + record);
            }
        }
    }

    private void patientPortal() {
        System.out.print("Enter patient username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Patient patient = patients.get(username);
        if (patient == null || !patient.getPassword().equals(password)) {
            System.out.println("Invalid username or password.");
            return;
        }

        System.out.println("Welcome, " + patient.getName());
        System.out.println("Medical History: " + patient.getMedicalHistory());
        System.out.println("Allergies: " + patient.getAllergies());
        System.out.println("Medications: " + patient.getMedications());
        System.out.println("Medical Records: " + patient.getMedicalRecord().getRecords());
    }

    private void exit() {
        System.out.println("Exiting the system. Goodbye!");
        System.exit(0);
    }


        
    public void setDoctorAvailability() {
        System.out.print("Enter doctor name to update availability: ");
        String doctorName = scanner.nextLine();
        
        Doctor selectedDoctor = null;
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(doctorName)) {
                selectedDoctor = doctor;
                break;
            }
        }

        if (selectedDoctor != null) {
            System.out.print("Is the doctor available? (yes/no): ");
            String availability = scanner.nextLine();
            selectedDoctor.setAvailable(availability.equalsIgnoreCase("yes"));
            System.out.println("Doctor availability updated.");
        } else {
            System.out.println("Doctor not found.");
        }
    }

   
    public void viewDoctorAvailability() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors in the system.");
        } else {
            System.out.println("Doctor Availability:");
            for (Doctor doctor : doctors) {
                System.out.println(doctor.getName() + " - Available: " + (doctor.isAvailable() ? "Yes" : "No"));
            }
        }
    }

}

public class Main {
    public static void main(String[] args) {
        HealthcareSystem healthcareSystem = new HealthcareSystem();
        healthcareSystem.run();
    }
}
