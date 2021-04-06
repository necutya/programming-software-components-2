package Controller;

import Model.StudentDecorator;
import View.View;

import java.util.ArrayList;

public class DetailedCommand extends Command{

    public DetailedCommand(View view, StudentDecorator student) {
        super(view, student);
    }

    public String execute() {
        if (student.getName().equals("")) {
            return view.getStudentDoesNotExistErrorString();
        }
        return new View().getStudentInfoString(student.getId(), student.getName(), student.getCourse(),
                student.getAvg_mark(), student.isBudget_basis());
    }

    @Override
    public void writeData(ArrayList<String> data) throws Exception{
        throw new Exception("Not implemented");
    }
}
