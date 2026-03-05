package org.example;
import java.util.*;
/**
 * Hello world!
 *
 */
import org.example.service.LibraryService;

public class App {

    public static void main(String[] args) {

        LibraryService service = new LibraryService();

        // .......Create Author with Books
        service.createAuthorWithBooks(
                "Raushan",
                Arrays.asList( "Spring Boot Guide")
        );

//
//        //................ Add new Book to existing Author
//        service.addBook(1L, "Microservices Architecture");
//
//
//        // 3.........................Fetch Books by Author
//        service.fetchBooksByAuthor(1L);
//
//
//        // ..................Fetch Author by Book
//        service.fetchAuthorByBook(1L);
//
//
//        // ..................................... Delete Book
//        service.deleteBook(2L);

    }
}
