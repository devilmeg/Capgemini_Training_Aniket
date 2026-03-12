package annotation_configuration.post_pre_using_annotation;

import annotation_configuration.configuration.AppConfig;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Student1 {

    private int id;
    private String name;

    public Student1() {
        System.out.println("Constructor called");
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct method executed");
        id = 101;
        name = "Aniket";
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PreDestroy method executed");
    }

    public void display() {
        System.out.println(id + " " + name);
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Student1 student = context.getBean(Student1.class);

        student.display();

        context.close();
    }
}