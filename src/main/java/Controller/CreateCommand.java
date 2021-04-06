package Controller;

import Model.StudentDecorator;
import View.View;

import java.util.ArrayList;

public class CreateCommand extends Command{
    private String name;
    private String course;
    private String id;
    private String avg_mark;
    private String budget_basis;

    public CreateCommand(View view, StudentDecorator student) {
        super(view, student);

    }

    public String execute() {
        if(name.isEmpty() || course.isEmpty() || id.isEmpty() ||
                avg_mark.isEmpty()) {
            return view.getFieldsErrorString();
        }
        try {
            student.setName(name);
            student.setCourse(Integer.parseInt(course));
            student.setId(Integer.parseInt(id));
            student.setAvg_mark(Float.parseFloat(avg_mark));
            student.setBudget_basis(Boolean.parseBoolean(budget_basis));
            return view.getStudentCreationSuccessString();

        }
        catch (NumberFormatException ex) {
            return view.getStudentCreationErrorString();
        }
    }

    public void writeData(ArrayList<String> data) throws Exception  {
        try {
            this.name = data.get(0);
            this.course = data.get(1);
            this.id = data.get(2);
            this.avg_mark = data.get(3);
            this.budget_basis = data.get(4);
        }
        catch (Exception ex) {
            throw new Exception(view.getFieldsErrorString());
        }
    }
}
