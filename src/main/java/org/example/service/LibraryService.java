package org.example.service;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.repository.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class LibraryService {

    // *********************************** CREATE AUTHOR WITH BOOKS***********************************
    public void createAuthorWithBooks(String authorName, List<String> titles) {

        EntityManager em = Repository.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            if (authorName == null || authorName.isBlank()) {
                System.out.println("Author name cannot be empty");
                return;
            }

            tx.begin();

            Author author = new Author();
            author.setName(authorName);

            for (String title : titles) {

                if (title == null || title.isBlank()) continue;

                Book book = new Book();
                book.setTitle(title);

                author.addBook(book); // helper method
            }

            em.persist(author);

            tx.commit();

            System.out.println("Author and books created successfully.");

        } catch (Exception e) {

            if (tx.isActive()) tx.rollback();
            System.out.println("Error creating author: " + e.getMessage());
        } finally {
            em.close();
        }
    }


    // ADD BOOK TO EXISTING AUTHOR
    public void addBook(Long authorId, String title) {

        EntityManager em = Repository.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            if (authorId == null) {
                System.out.println("Author ID cannot be null");
                return;
            }

            if (title == null || title.isBlank()) {
                System.out.println("Book title cannot be empty");
                return;
            }

            tx.begin();

            Author author = em.find(Author.class, authorId);

            if (author == null) {
                System.out.println("Author not found with id: " + authorId);
                return;
            }

            Book book = new Book();
            book.setTitle(title);

            author.addBook(book); // helper method

            em.persist(book);

            tx.commit();

            System.out.println("Book added successfully.");

        } catch (Exception e) {

            if (tx.isActive()) tx.rollback();
            System.out.println("Error adding book: " + e.getMessage());
        } finally {
            em.close();
        }
    }


    // DELETE BOOK
    public void deleteBook(Long bookId) {

        EntityManager em = Repository.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            if (bookId == null) {
                System.out.println("Book ID cannot be null");
                return;
            }

            tx.begin();

            Book book = em.find(Book.class, bookId);

            if (book == null) {
                System.out.println("Book not found with id: " + bookId);
                return;
            }

            Author author = book.getAuthor();

            if (author != null) {
                author.removeBook(book); // helper method
            }

            em.remove(book);

            tx.commit();

            System.out.println("Book deleted successfully.");

        } catch (Exception e) {

            if (tx.isActive()) tx.rollback();
            System.out.println("Error deleting book: " + e.getMessage());
        } finally {
            em.close();
        }
    }


    // FETCH BOOKS BY AUTHOR
    public void fetchBooksByAuthor(Long authorId) {

        EntityManager em = Repository.getEmf().createEntityManager();

        try {

            if (authorId == null) {
                System.out.println("Author ID cannot be null");
                return;
            }

            Author author = em.find(Author.class, authorId);

            if (author == null) {
                System.out.println("Author not found with id: " + authorId);
                return;
            }

            List<Book> books = author.getBooks();

            if (books.isEmpty()) {
                System.out.println("No books found for author: " + author.getName());
                return;
            }

            System.out.println("Books by " + author.getName() + ":");

            for (Book b : books) {
                System.out.println(b.getId() + " - " + b.getTitle());
            }

        } catch (Exception e) {

            System.out.println("Error fetching books: " + e.getMessage());
        } finally {
            em.close();
        }
    }


    // FETCH AUTHOR BY BOOK
    public void fetchAuthorByBook(Long bookId) {

        EntityManager em = Repository.getEmf().createEntityManager();

        try {

            if (bookId == null) {
                System.out.println("Book ID cannot be null");
                return;
            }

            Book book = em.find(Book.class, bookId);

            if (book == null) {
                System.out.println("Book not found with id: " + bookId);
                return;
            }

            Author author = book.getAuthor();

            if (author == null) {
                System.out.println("Book exists but has no author.");
                return;
            }

            System.out.println("Book: " + book.getTitle());
            System.out.println("Author: " + author.getName());

        } catch (Exception e) {

            System.out.println("Error fetching author: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}