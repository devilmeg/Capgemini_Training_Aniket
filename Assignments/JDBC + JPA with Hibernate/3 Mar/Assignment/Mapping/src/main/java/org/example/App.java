package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Human;
import org.example.entity.Passport;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("aman");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Create Human
            Human human = new Human();
            human.setId(1);
            human.setName("Aman");

            // Create Passport
            Passport passport = new Passport();
            passport.setPassportNumber(1001);
            passport.setCountry("India");

            // Set relationship (owning side controls FK)
            passport.setHuman(human);
            human.setPassport(passport);

            // Persist in correct order (no cascade)
            em.persist(human);      // parent first
            em.persist(passport);   // owning side

            em.getTransaction().commit();

            System.out.println("Human and Passport saved successfully.");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}


//package org.example;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import org.example.entity.Pan;
//import org.example.entity.Person;
//
//public class App {
//
//    public static void main(String[] args) {
//
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("aman");
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            em.getTransaction().begin();
//
//            // Create PAN
//            Pan pan = new Pan();
//            pan.setPanNumber(101);
//            pan.setPanAddress("Mumbai");
//
//            // Create Person
//            Person person = new Person();
//            person.setId(1);
//            person.setName("Aman");
//            person.setPan(pan);
//
//            // Set reverse side (important for bidirectional mapping)
//            pan.setPerson(person);
//
//            // Persist (cascade saves PAN automatically)
//            em.persist(person);
//
//            em.getTransaction().commit();
//
//            System.out.println("Person and PAN saved successfully.");
//
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//            e.printStackTrace();
//        } finally {
//            em.close();
//            emf.close();
//        }
//    }
//}