package org.example.repository;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentRepository {

    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}