import org.junit.*;

import static junit.framework.TestCase.assertEquals;


public class StudentTest {
    private Student student;

    @Before
    public void setUp() {
        student = new Student("Artem Lebedev", 3, 123);
    }
    @Test
    public void testToString() {
        assertEquals(student.toString(), "ARTEM LEBEDEV");
    }
}
