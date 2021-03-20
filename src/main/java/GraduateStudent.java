public class GraduateStudent extends Student implements GraduateInterface {

    private String diploma_topic;


    public GraduateStudent(String name, int course, int id, float avg_mark, boolean budget_basis, String diploma_topic) {
        super(name, course, id, avg_mark, budget_basis);
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
        String res = super.toString();
        if (!diploma_topic.trim().isEmpty() && diploma_topic != null) {
            res = res + " - " + diploma_topic.substring(0, 1).toUpperCase() + diploma_topic.substring(1);
        }
        return res;
    }

    @Override
    @MethodAnn
    public boolean has_scholarship() {
        return super.has_scholarship() && diploma_topic != null && !diploma_topic.trim().isEmpty();
    }
}
