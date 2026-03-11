package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "human")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Human {

    @Id
    private int id;

    private String name;

    @OneToOne(mappedBy = "human")
    private Passport passport;
}