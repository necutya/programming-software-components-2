package Controller;

import Model.Student;
import View.View;

import java.io.*;

public class StudentController {
    private View view;
    private Student model;
    private BufferedReader reader;

    public StudentController(View v, BufferedReader reader) {
        this.view = v;
        this.reader = reader;
    }


    public void processUserInput() throws Exception {
        view.printHelp();
        try {
            while (true) {
                String userLine = reader.readLine();
                int userChoice = Integer.parseInt(userLine);
                switch (userChoice) {
                    case 1:
                        model = this.createStudent(reader);
                        view.printStudentCreationSuccess();
                        break;
                    case 2:
                        view.printStudentInfo(model.getId(), model.getName(), model.getCourse(),
                                model.getAvg_mark(), model.isBudget_basis());
                        break;
                    case 3:
                        view.printStudentScholarship(model.calc_scholarship());
                        break;
                    default:
                        view.printInvalidItemError();
                        return;
                }
            }
        } catch (NumberFormatException e) {
            view.printInputError();
        } catch (RuntimeException re) {
            view.printStudentDoesNotHaveScholarship();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student createStudent(BufferedReader reader) throws IOException {
        try {
            System.out.print("Student name: ");
            String name = reader.readLine();
            System.out.print("Student group: ");
            int group = Integer.parseInt(reader.readLine());
            System.out.print("Student id: ");
            int id = Integer.parseInt(reader.readLine());
            System.out.print("Average mark: ");
            float avg = Float.parseFloat(reader.readLine());
            System.out.print("Budget basis: ");
            boolean budget = Boolean.parseBoolean(reader.readLine());
            return new Student(name, group, id, avg, budget);
        }
        catch (NumberFormatException e) {
            view.printStudentCreationError();
            int choice = Integer.parseInt(reader.readLine());
            if (choice == 1) {
                return createStudent(reader);
            }
            else if(choice == 2) {
                return null;
            }
        }
        return null;
    }
}
