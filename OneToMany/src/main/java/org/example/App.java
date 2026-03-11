package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entity.Department;
import org.example.entity.Employee;
import org.example.repository.Repository;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        EntityManager em = Repository.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Employee e1 = new Employee();
        e1.setName("Aniket");

        Employee e2 = new Employee();
        e2.setName("Rahul");

        Department dept = new Department();
        dept.setName("IT");

        dept.setEmployees(Arrays.asList(e1, e2));

        em.persist(dept);

        tx.commit();

        em.close();
    }
}