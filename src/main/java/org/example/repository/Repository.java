package org.example.repository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Repository {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("jpa");

    public static EntityManagerFactory getEmf(){
        return emf;
    }
}