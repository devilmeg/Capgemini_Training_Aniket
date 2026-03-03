package org.example;

import jakarta.persistence.*;
import org.example.entity.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpa");

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

//            Person p1 = new Person();
//            p1.setName("Aniket");
//            p1.setEmail("ak1046@gmail.com");
//
//            Pan pan1 = new Pan();
//            pan1.setPanNumber("ABCDE1234F");
//
//            // Set relationship both sides
//            p1.setPan(pan1);
//            pan1.setPerson(p1);
//
//            em.persist(p1);   // Cascade saves PAN also

            Human h1 = new Human();
            h1.setName("Aniket");
            h1.setAddress("Pune");

            Passport p=new Passport();
            p.setPassportNumber("M1234567");
            p.setCountry("India");

            // Set relationship both sides
            h1.setPassport(p);
            p.setHuman(h1);

            em.persist(h1);

            em.getTransaction().commit();

            System.out.println("Saved successfully!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}