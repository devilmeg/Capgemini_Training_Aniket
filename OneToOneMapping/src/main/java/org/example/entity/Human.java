package org.example.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "humans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @OneToOne(mappedBy = "human",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private Passport passport;
}
