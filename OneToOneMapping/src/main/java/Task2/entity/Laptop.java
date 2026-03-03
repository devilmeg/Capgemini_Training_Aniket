package Task2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "laptops")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "student")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;

    @OneToOne(mappedBy = "laptop",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private Student1 student;
}
