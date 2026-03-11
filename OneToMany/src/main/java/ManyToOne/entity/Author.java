package ManyToOne.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "authors")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}