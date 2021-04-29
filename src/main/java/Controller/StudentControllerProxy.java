package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component("proxyController")
@Scope("singleton")
public class StudentControllerProxy implements StudentControllerInterface {

    private StudentController realController;
    private Logger log;

    @Autowired
    public StudentControllerProxy (StudentController realController) {
        this.realController = realController;
        log  = Logger.getLogger(StudentControllerProxy.class.getName());
    }

    public void createUI() {
        log.logp(Level.INFO, StudentControllerProxy.class.getName(), "createUI", "Start createUI method");
        realController.createUI();
    }

    public void show() {
        log.logp(Level.INFO, StudentControllerProxy.class.getName(), "show", "Start show method");
        realController.show();
    }

}
