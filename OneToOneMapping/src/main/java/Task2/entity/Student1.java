package Task2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "laptop")
public class Student1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String course;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "laptop_id", unique = true)
    private Laptop laptop;

    // ---------------Helper method
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
        if (laptop != null) {
            laptop.setStudent(this);
        }
    }
}