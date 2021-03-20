@ClassAnn
public class Student {
    private String name;
    private int course;
    private int id;
    private float avg_mark;
    private boolean budget_basis;

    public Student(String name, int course, int id, float avg_mark, boolean budget_basis) {
        this.name = name;
        this.course = course;
        this.id = id;
        this.avg_mark = avg_mark;
        this.budget_basis = budget_basis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAvg_mark() {
        return avg_mark;
    }

    public void setAvg_mark(float avg_mark) {
        this.avg_mark = avg_mark;
    }

    @Override
    @MethodAnn
    public String toString() {
        String[] credentials = this.name.split(" ");
        String name = credentials[0].substring(0, 1).toUpperCase() + credentials[0].substring(1);
        String surname = credentials[1].substring(0, 1).toUpperCase() + credentials[1].substring(1);
        return name + " " + surname + " (" + this.course + " course)";
    }

    public boolean has_scholarship() {
        return this.avg_mark > 75.5 && this.budget_basis;
    }
}
