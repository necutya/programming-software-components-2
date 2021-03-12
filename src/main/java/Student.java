@ClassAnn
public class Student {
    private String name;
    private int course;
    private int id;


    public Student(String name, int course, int id) {
        this.name = name;
        this.course = course;
        this.id = id;
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


    @Override
    @MethodAnn
    public String toString() {
        String[] credentials = this.name.split(" ");
        return credentials[0].toUpperCase() + " " + credentials[1].toUpperCase();
    }
}
