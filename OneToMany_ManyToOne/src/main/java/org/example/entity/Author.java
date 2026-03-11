package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "books")

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author",
            cascade = CascadeType.ALL,
            orphanRemoval = true)

    private List<Book> books = new ArrayList<>();

    // helper method
    public void addBook(Book book){
        books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book){
        books.remove(book);
        book.setAuthor(null);
    }
}