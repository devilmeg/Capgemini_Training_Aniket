package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entity.Person;

import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aman");
        EntityManager em = emf.createEntityManager();

        // EntityTransaction entityTransaction = em.getTransaction();
        // entityTransaction.begin();

        // in nested form we write
        em.getTransaction().begin();

        // Person p1 = new Person();
        // p1.setId(1);
        // p1.setName("Ritul Raj");
        // em.persist(p1);

        Person person = em.find(Person.class, 1);
        System.out.println(person);

        // IMPORTANT: JPQL uses entity name, not table name
//        List<Person> list = em.createQuery("from Person", Person.class)
//                .getResultList();
//
//        for (Person person1 : list) {
//            System.out.println(person1);
//        }

//        person.setName("Priyanshu Kumar");
//        em.merge(person);

        em.remove(person);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}