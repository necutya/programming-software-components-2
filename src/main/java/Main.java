import Controller.StudentControllerProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        // Read xml configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationConfiguration.xml");

        // Useless
        // View view = context.getBean("view", View.class);
        // StudentController studentController = context.getBean("controller", StudentController.class);

        // Get proxy bean and use it
        StudentControllerProxy proxyLogger = context.getBean("proxyController", StudentControllerProxy.class);
        proxyLogger.createUI();
        proxyLogger.show();
    }
}
