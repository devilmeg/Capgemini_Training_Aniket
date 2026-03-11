package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pan {

    @Id
    private int panNumber;

    private String panAddress;

    @OneToOne(mappedBy = "pan")
    private Person person;
}