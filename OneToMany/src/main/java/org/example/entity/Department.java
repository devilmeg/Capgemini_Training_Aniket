package org.example.entity;

//package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "departments")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)

    @JoinColumn(name = "department_id")

    private List<Employee> employees;
}