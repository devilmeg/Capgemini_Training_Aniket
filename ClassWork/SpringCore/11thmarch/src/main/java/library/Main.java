package library;
import library.Library;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(String[] args){
        ApplicationContext context=new ClassPathXmlApplicationContext("lib.xml");

        Library l=context.getBean("library",Library.class);
        l.showBooks();
    }
}
