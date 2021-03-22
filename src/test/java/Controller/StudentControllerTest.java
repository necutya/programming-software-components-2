package Controller;

import Model.Student;
import View.View;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;

public class StudentControllerTest {

    @Test
    void processUserInputCalculateScholarship() throws Exception {
        Student student = mock(Student.class);
        View view = mock(View.class);
        BufferedReader reader = mock(BufferedReader.class);

        StudentController studentController = spy(new StudentController(view, reader));
        doReturn(student).when(studentController).createStudent(reader);

        when(reader.readLine()).thenReturn("1", "3", "quit");
        when(student.calc_scholarship()).thenReturn(1450f);

        studentController.processUserInput();

        verify(view).printHelp();
        verify(view).printStudentCreationSuccess();
        verify(view).printStudentScholarship(1450f);
    }


    @Test
    void processUserInputInvalidInput() throws Exception {
        Student student = mock(Student.class);
        View view = mock(View.class);
        BufferedReader reader = mock(BufferedReader.class);

        StudentController studentController = new StudentController(view, reader);

        when(reader.readLine()).thenReturn("raise error");

        studentController.processUserInput();

        verify(view).printHelp();
        verify(view).printInputError();
        verifyZeroInteractions(student);
    }
}
