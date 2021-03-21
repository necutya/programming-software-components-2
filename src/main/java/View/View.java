package View;

public class View {

    public void printHelp() {
        System.out.println("Menu:");
        System.out.println("1. Create student");
        System.out.println("2. See user detailed info (only if student has been created)");
        System.out.println("3. Calculate user scholarship (only if student has been created)");
    }

    public void printInputError() {
        System.out.println("Input only numbers!");
    }

    public void printInvalidItemError() {
        System.out.println("Create user or check your inputs (only numbers are available)!");
    }

    public void printStudentCreationSuccess() {
        System.out.println("User was created successfully!");

    }

    public void printStudentCreationError() {
        System.out.println("Invalid data!");
        System.out.println("Try again?(1 - yes, 0 - no)");
    }

    public void printStudentDoesNotHaveScholarship() {
        System.out.println("This user does not have a scholarship!");
    }

    public void printStudentInfo(int id, String name, int course, float avg_mark, boolean budget) {
        System.out.println("Model.Student Info:");
        System.out.println("\tID: " + id);
        System.out.println("\tName: " + name);
        System.out.println("\tCourse: " + course);
        System.out.println("\tName: " + avg_mark);
        System.out.println("\tBudget basis: " + (budget ? '+' : '-'));
    }

    public void printStudentScholarship(float scholarship) {
        System.out.println("Student scholarship is: " + scholarship + " $.");
    }
}
