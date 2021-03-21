package Model;

import Model.GraduateStudent;
import org.junit.*;

import static junit.framework.TestCase.*;


public class GraduateStudentTest {
    private GraduateStudent graduated_student;

    @Before
    public void setUp() {
        graduated_student = new GraduateStudent("artem lebedev", 3, 123, 75.5f, true, "");
    }

    @Test
    public void testToString() {
        assertEquals(graduated_student.toString(), "Artem Lebedev (3 course)");
    }

    @Test
    public void testHasScholarship() {
        assertFalse(graduated_student.has_scholarship());
    }
}
