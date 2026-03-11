package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String panNumber;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false, unique = true)
    private Person person;
}