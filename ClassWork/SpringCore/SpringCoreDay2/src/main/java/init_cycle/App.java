package init_cycle;

import init_cycle.dao.StudentDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring_db.xml");

        StudentDao dao = context.getBean("studentDao", StudentDao.class);

        dao.showStudents();

        context.close();
    }
}