package org.example;
import jakarta.persistence.*;
import java.util.List;
import org.example.entity.Student;
import org.example.entity.Gender;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

        EntityManager em=emf.createEntityManager();

        try{
            em.getTransaction().begin();

//            Student s1=new Student(null,"Anket","akdsa@gmail.com",22,Gender.MALE,null);
//            Student s2 = new Student(null, "Priya Sharma",
//                    "priya@example.com", 21, Gender.FEMALE, null);
//
//            Student s3 = new Student(null, "Rahul Verma",
//                    "rahul@example.com", 23, Gender.MALE, null);
//
//            Student s4 = new Student(null, "Sneha Gupta",
//                    "sneha@example.com", 22, Gender.FEMALE, null);
//
//            Student s5 = new Student(null, "Aman Singh",
//                    "aman@example.com", 24, Gender.MALE, null);
//
//
//            em.persist(s1);
//            em.persist(s2);
//            em.persist(s3);
//            em.persist(s4);
//            em.persist(s5);

            em.getTransaction().commit();
            System.out.println("Students saved successfully!");
//-----------update student------------------
            em.getTransaction().begin();
            Student studentToUpdate = em.find(Student.class, 1L);
            if (studentToUpdate != null) {
                studentToUpdate.setEmail("ak10467@gamil.com");
                em.merge(studentToUpdate);
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found for update.");
            }
            em.getTransaction().commit();
            /// -----------delete student------------------
            em.getTransaction().begin();
            Student studentToDelete = em.find(Student.class, 2L);
            if (studentToDelete != null) {
                em.remove(studentToDelete);
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found for deletion.");

            }
            em.getTransaction().commit();

            //Fetch all students
            List<Student>st=em.createQuery("Select s from Student s",Student.class).getResultList();
            System.out.println("All Students:");
            st.forEach(System.out::println);
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            em.close();
            emf.close();
        }

    }
}
