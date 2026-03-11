package factory_registry_pattern;

import factory_registry_pattern.factory.BookFactory;
import factory_registry_pattern.interfacee.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("map.xml");

        BookFactory factory=context.getBean("bookFactory",BookFactory.class);

        BookService service=factory.getService("spring");
                service.readBook();
    }
}
