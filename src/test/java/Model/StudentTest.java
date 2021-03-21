package Model;

import Model.Student;
import org.junit.*;

import static junit.framework.TestCase.*;


public class StudentTest {
    private Student student;

    @Before
    public void setUp() {
        student = new Student("artem lebedev", 3, 123, 75.5f, false);
    }

    @Test
    public void testToString() {
        assertEquals(student.toString(), "Artem Lebedev (3 course)");
    }

    @Test
    public void testHasScholarship() {
        assertFalse(student.has_scholarship());
    }
}
