package org.example;


import org.example.dao.StudentDAO;
import org.example.dao.StudentDAOImpl;
import org.example.entity.Student;

public class App {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAOImpl();

        dao.save(new Student("Aman Kumar", "CS", 22, 85));
        dao.save(new Student("Aniket Raj", "CS", 23, 90));
        dao.save(new Student("Satyam Kumar", "IT", 23, 82));

        System.out.println("---- FETCH ALL ----");
        dao.fetchAll().forEach(System.out::println);

        System.out.println("---- FETCH BY ID ----");
        System.out.println(dao.fetchById(1));

        System.out.println("---- UPDATE MARKS ----");
        dao.updateMarks(1, 95);

        System.out.println("---- SORT BY MARKS ----");
        dao.sortByMarks().forEach(System.out::println);

        System.out.println("---- FILTER BY DEPT ----");
        dao.filterByDept("IT").forEach(System.out::println);

        System.out.println("---- NATIVE FETCH ----");
        dao.nativeFetch().forEach(System.out::println);
    }
}

















//package org.example;
//
//import org.example.entity.Person;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import java.util.List;
//
//public class App {
//
//    public static void main(String[] args) {
//
//        // Create SessionFactory
//        SessionFactory sessionFactory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Person.class)
//                .buildSessionFactory();
//
//        Session session = null;
//        Transaction tx = null;
//
//        try {
//            session = sessionFactory.openSession();
//            tx = session.beginTransaction();
//
//            // -------- UPDATE --------
//            Person p = session.get(Person.class, 16);
//            if (p != null) {
//                p.setName("Aman Raj");
//            }
//
//            // -------- FETCH ALL --------
//            List<Person> persons = session
//                    .createQuery("from Person", Person.class)
//                    .getResultList();
//
//            for (Person person : persons) {
//                System.out.println(person);
//            }
//
////            tx.commit();
//
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            if (session != null) session.close();
//            sessionFactory.close();
//        }
//    }
//}


