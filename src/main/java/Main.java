import Controller.StudentController;
import Controller.StudentControllerProxy;
import View.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        View view = new View();
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in, "UTF-8"));
        StudentControllerProxy proxyLogger = new StudentControllerProxy(StudentController.getInstance(view, reader));
        proxyLogger.createUI();
        proxyLogger.show();
    }
}
