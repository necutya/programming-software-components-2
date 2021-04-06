package Controller;

import Model.StudentDecorator;
import View.View;

import java.util.ArrayList;

public abstract class Command {
    protected StudentDecorator student;
    protected View view;

    public Command(View view, StudentDecorator student) {
        this.student = student;
        this.view = view;
    }

    public abstract String execute();
    public abstract void writeData(ArrayList<String> data) throws Exception;
}
