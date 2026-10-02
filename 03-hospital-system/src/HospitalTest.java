// An abstract superclass representing a general person in the hospital.
abstract class Person {
    private String name;
    private int age;

    // Constructor that receives common data of every person (inside the general person).
    public Person(String nameP, int ageP) {
        name = nameP;
        age = ageP;
    }

    // Returns the person's name.
    public String getName() {
        return name;
    }

    // Returns the person's age.
    public int getAge() {
        return age;
    }

    // Method to register something, and each subclass must implement.
    public abstract void register();
}

// It's a subclass of person.
class Doctor extends Person {
    private String department;

    // Constructor that creates a doctor with specific data: name, age, and work area (department).
    public Doctor(String nameD, int ageD, String departmentD) {
        super(nameD, ageD);
        department = departmentD;
    }

    // Returns the doctor's department.
    public String getDepartment() {
        return department;
    }

    // Register and prints the registration message for doctors.
    @Override
    public void register() {
        System.out.println("Welcome Doctor!");
    }
}

// It's a subclass of person.
class Patient extends Person {
    private String illness;

    // Constructor that creates a patient with their data: name, age, and illness.
    public Patient(String nameP, int ageP, String illnessP) {
        super(nameP, ageP);
        illness = illnessP;
    }

    // Returns the patient's illness.
    public String getIllness() {
        return illness;
    }

    // Register and prints the registration message for patients.
    @Override
    public void register() {
        System.out.println("Welcome Patient!");
    }
}

// It's also a subclass of person. It will be used for guards.
class Guard extends Person {
    private String shift;
    private String phone;

    // Constructor that creates guards with their data: name, age, shift.
    public Guard(String nameG, int ageG, String shiftG) {
        this(nameG, ageG, shiftG, "No phone registered");
    }

    // Constructor for guard, but this includes phone number.
    public Guard(String nameG, int ageG, String shiftG, String phoneG) {
        super(nameG, ageG);
        shift = shiftG;
        phone = phoneG;
    }

    // Returns the guard's shift.
    public String getShift() {
        return shift;
    }

    // Return the guard's phone.
    public String getPhone() {
        return phone;
    }

    // Prints the registration message for guards.
    @Override
    public void register() {
        System.out.println("Welcome Guard!");
    }
}

// Main class to test the program.
public class HospitalTest {
    public static void main(String[] args) {
        // In this section, objects are created with the provided data.
        Doctor doctor = new Doctor("Joseph", 41, "Neurologist");
        Patient patient = new Patient("Richard", 78, "Chronic Headache");
        Guard guard1 = new Guard("John", 39, "Morning");
        Guard guard2 = new Guard("Kevin", 43, "Afternoon", "+52 232 456345");

        // Tests the register method of each object through Person references.
        Person[] people = {doctor, patient, guard1, guard2};

        System.out.println("Registration messages:");
        for (Person person : people) {
            person.register();
        }

        // Displays the information stored in each object.
        System.out.println("\nDoctor information:");
        System.out.println("Name: " + doctor.getName());
        System.out.println("Age: " + doctor.getAge());
        System.out.println("Department: " + doctor.getDepartment());

        System.out.println("\nPatient information:");
        System.out.println("Name: " + patient.getName());
        System.out.println("Age: " + patient.getAge());
        System.out.println("Illness: " + patient.getIllness());

        System.out.println("\nGuard 1 information:");
        System.out.println("Name: " + guard1.getName());
        System.out.println("Age: " + guard1.getAge());
        System.out.println("Shift: " + guard1.getShift());
        System.out.println("Phone: " + guard1.getPhone());

        System.out.println("\nGuard 2 information:");
        System.out.println("Name: " + guard2.getName());
        System.out.println("Age: " + guard2.getAge());
        System.out.println("Shift: " + guard2.getShift());
        System.out.println("Phone: " + guard2.getPhone());
    }
}