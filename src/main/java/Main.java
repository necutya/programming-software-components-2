import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1.1 Показати використання конструкторів похідного і базового класу.
        Student student = new Student("Artem Lebedev", 3, 321);
        GraduateStudent graduateStudent = new GraduateStudent(
                "Vasilii Pupkin",
                4,
                123,
                "Diplom Topic"
        );


        Class clazz = student.getClass();
        // 1.2 За допомогою рефлексії обійти методи класу і викликати відмічені анотацією методи за допомогою invoke()
        System.out.println("\t\n 1.2) Annotation");
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MethodAnn.class)) {
                System.out.println("Invocation(method=" + method.getName() + ")");
                System.out.println("Result:" + method.invoke(student));
            }
        }

        // 1.3
        // 1)За допомогою рефлексії вивести ім'я класу.
        System.out.println("\t\n 1.3) Reflation");
        System.out.println("Class name: " + clazz.getName());

        // 2) Список методів зі специфікатором доступу та типами параметрів.
        System.out.println("Methods: ");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.print("\tMethod<name=" + method.getName() +
                    ", spec=" + Modifier.toString(method.getModifiers()) + ", params(");
            for (Parameter parameter : method.getParameters())
                System.out.print(parameter.getName() + ": " + parameter.getType().getTypeName() + ", ");
            System.out.println(")>");
        }

        // 3) Список анотацій классу
        System.out.println("Annotations: ");
        for (Annotation annotation : clazz.getAnnotations()) {
            System.out.println("\tAnnotation<name=" + annotation.toString() + ">");
        }

        // 1.4 Зробити для класу проксі (для незмінності), який пропускає звернення до getter-ів,
        // там, де setter-и - породжує виключну ситуацію (Exception).
        System.out.println("\t\n 1.4) Proxy");
        GraduateInterface proxy = (GraduateInterface) Proxy.newProxyInstance(graduateStudent);
        System.out.println("Graduated student diploma topic: " + proxy.getDiploma_topic());
        System.out.println("Try to change diploma topic...");
        proxy.setDiploma_topic("Error...");

    }
}
