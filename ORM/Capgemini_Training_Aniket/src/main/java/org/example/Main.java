package org.example;
import java.time.LocalDate;
import org.example.dao.StudentDao;
import org.example.dao.StudentDaoImpl;
import org.example.entity.Student;
import org.example.repository.StudentRepository;
public class Main {
    public static void main(String args[]){
        StudentDao operation=new StudentDaoImpl();
        Student s1 = new Student(null, "Aniket", "aniket@gmail.com", 22, "CSE", 8.7, LocalDate.now());
        Student s2 = new Student(null, "Rohit", "rohit@gmail.com", 21, "ECE", 7.5, LocalDate.now());
        Student s3 = new Student(null, "Virat", "virat@gmail.com", 23, "CSE", 9.1, LocalDate.now());
        Student s4 = new Student(null, "Dhoni", "dhoni@gmail.com", 24, "MECH", 8.0, LocalDate.now());
        Student s5 = new Student(null, "Hardik", "hardik@gmail.com", 22, "CSE", 7.9, LocalDate.now());
        Student s6 = new Student(null, "KL Rahul", "rahul@gmail.com", 21, "IT", 8.4, LocalDate.now());

        operation.save(s1);
        operation.save(s2);
        operation.save(s3);
        operation.save(s4);
        operation.save(s5);
        operation.save(s6);



        System.out.println("All Students: "+operation.findAll());
        System.out.println("CSE Students: "+operation.findByDepartment("CSE"));
        System.out.println("High CGPA Students: "+operation.findByCGPAGreaterThan(8.0));
        System.out.println("Student with ID 1: "+operation.findById(1L));
        System.out.println("Total Students: "+operation.countStudent());

    }
}
