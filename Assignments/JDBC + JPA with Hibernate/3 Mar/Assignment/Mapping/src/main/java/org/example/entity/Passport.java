package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "passport")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passport {

    @Id
    private int passportNumber;

    private String country;

    @OneToOne
    @JoinColumn(name = "human_id", unique = true)
    private Human human;
}