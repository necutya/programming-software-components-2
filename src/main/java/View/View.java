package View;

public class View {

    public String getFieldsErrorString() {
        return "Enter all available fields";
    }

    public String getStudentCreationSuccessString() {
        return "User was created successfully!";
    }

    public String getStudentCreationErrorString() {
         return "Invalid data!";
    }

    public String getStudentDoesNotExistErrorString() {
        return "Firstly, create a student";
    }

    public String getStudentDoesNotHaveScholarshipString() {
        return  "This user does not have a scholarship!";
    }

    public String getStudentInfoString(int id, String name, int course, float avg_mark, boolean budget) {
        return "Model.Student Info:" + "\n\tID: " + id + "\n\tName: " + name + "\n\tCourse: " + course +
                "\n\tName: " + avg_mark + "\n\tBudget basis: " + (budget ? '+' : '-');
    }

    public String getStudentScholarshipString(float scholarship) {
        return "Student scholarship is: " + scholarship + " $.";
    }
}
