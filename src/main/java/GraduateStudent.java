public class GraduateStudent extends Student implements GraduateInterface {

    private String diploma_topic;


    public GraduateStudent(String name, int course, int id, String diploma_topic) {
        super(name, course, id);
        this.diploma_topic = diploma_topic;
    }

    @Override
    public String getDiploma_topic() {
        return diploma_topic;
    }

    @Override
    public void setDiploma_topic(String diploma_topic) {
        this.diploma_topic = diploma_topic;
    }

    @Override
    @MethodAnn
    public String toString() {
        return "GraduateStudent{" +
                "diploma_topic='" + diploma_topic + '\'' +
                '}';
    }
}
