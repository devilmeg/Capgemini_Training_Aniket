package ManyToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ManyToOne.entity.Author;
import ManyToOne.entity.Book;
import ManyToOne.repository.Repository;

public class Main {

    public static void main(String[] args){

        EntityManager em = Repository.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Author a = new Author();
        a.setName("Aniket");
        em.persist(a);

        Author a1 = new Author();
        a1.setName("Divya");
        em.persist(a1);

        Book b1 = new Book();
        b1.setTitle("C++");
        b1.setAuthor(a);

        Book b2 = new Book();
        b2.setTitle("Java");
        b2.setAuthor(a);

        Book b3 = new Book();
        b3.setTitle("FairyTale");
        b3.setAuthor(a1);

        em.persist(b1);
        em.persist(b2);
        em.persist(b3);

        tx.commit();
        em.close();
    }
}