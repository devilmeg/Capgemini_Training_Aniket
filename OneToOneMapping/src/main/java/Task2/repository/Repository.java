package Task2.repository;
import jakarta.persistence.*;
public class Repository {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("jpa");

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}
