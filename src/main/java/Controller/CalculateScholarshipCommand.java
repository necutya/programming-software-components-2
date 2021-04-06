package Controller;

import Model.StudentDecorator;
import View.View;

import java.util.ArrayList;

public class CalculateScholarshipCommand extends Command{
    public CalculateScholarshipCommand(View view, StudentDecorator student) {
        super(view, student);
    }

    public String execute() {
        if (student.getName().equals("")) {
            return view.getStudentDoesNotExistErrorString();
        }
        try {
            return new View().getStudentScholarshipString(student.calc_scholarship());
        }
        catch (RuntimeException e) {
            return e.getMessage();
        }

    }

    @Override
    public void writeData(ArrayList<String> data) throws Exception {
        throw new Exception("Not implemented");

    }
}
