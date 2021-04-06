package Controller;

import Model.StudentDecorator;
import UI.UI;
import View.View;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class StudentController implements StudentControllerInterface {
    private static StudentController instance;

    private UI ui;
    private View view;
    private StudentDecorator model = new StudentDecorator("", 0, 0, 0, false);



    private StudentController(View v, BufferedReader reader) {
        this.view = v;
    }

    // Singleton
    public static StudentController getInstance(View v, BufferedReader reader) {
        if (instance == null) {
            instance = new StudentController(v, reader);
        }
        return instance;
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
