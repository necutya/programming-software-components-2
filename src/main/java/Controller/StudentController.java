package Controller;

import Model.StudentDecorator;
import UI.UI;
import View.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component("controller")
@Scope("prototype")
public class StudentController implements StudentControllerInterface {
    private static StudentController instance;

    private UI ui;
    private View view;
    private StudentDecorator model = new StudentDecorator("", 0, 0, 0, false);

    @Autowired
    public StudentController(View v) {
        this.view = v;
    }


    public void createUI() {
        ui = new UI("Student App");

        // Commands and builder
        ui.addLabel("Enter student info:");
        ui.addEnterField("Name").addEnterField("Course").addEnterField("ID")
          .addEnterField("Average mark").addDropDownMenu("Basis", new String[] {"true", "false"});


        ui.addButton("Create student", new CreateCommand(view, model), true)
          .addButton("Student Detailed Info", new DetailedCommand(view, model), false)
          .addButton("Calculate scholarship", new CalculateScholarshipCommand(view, model), false);


        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
    }

    public void show() {
        ui.show();
    }
}
