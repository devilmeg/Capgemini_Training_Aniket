package org.example.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "passports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String passportNumber;
    private String country;
    @OneToOne
    @JoinColumn(name = "human_id",
            nullable = false,
            unique = true)
    private Human human;


}
