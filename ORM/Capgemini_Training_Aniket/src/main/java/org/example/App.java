package org.example;

/**
 * Hello world!
 *
 */

import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        // ==============================
        // STEP 1: Create Student Object
        // ==============================
//        Student student = new Student();
//
//        // ==============================
//        // STEP 2: Set Values
//        // ==============================
//        student.setName("Divya");
//        student.setEmail("akaf3asda21@gmail.com");
//        student.setAge(23);


        // ==============================
        // STEP 3: Configure Hibernate
        // ==============================
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);

        SessionFactory factory = configuration.buildSessionFactory();


        // ==============================
        // STEP 4: Open Session
        // ==============================
        Session session = factory.openSession();


        // ==============================
        // STEP 5: Begin Transaction
        // ==============================
        session.beginTransaction();


        // ==============================
        // STEP 6: Save Object
        // ==============================
//        session.persist(student);//
        Student st=session.get(Student.class, 4L);
        System.out.println(st);
//        st.setName("Aniket Updated");
//        st.setAge(26);

        //for remove
        if(st!=null){
            session.remove(st);
            System.out.println("Student removed successfully!");
        }else{
            System.out.println("Student not found!");
        }

  //we alse use below merge concept to update the data but it will return the updated object
//        Student student = new Student();
//        student.setId(1L);
//        student.setName("Merged Name");
//
//        session.beginTransaction();
//        session.merge(student);
//        session.getTransaction().commit();
        // ==============================
        // STEP 7: Commit Transaction
        // ==============================
        session.getTransaction().commit();


        // ==============================
        // STEP 8: Close Resources
        // ==============================
        session.close();
        factory.close();

        System.out.println("Student saved successfully!");
    }
}
