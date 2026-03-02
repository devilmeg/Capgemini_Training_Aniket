package org.example.dao;

import org.example.entity.Student;
import java.util.List;
public interface StudentDao {
    void save(Student student);
    Student findById(Long id);
    List<Student> findAll();
    List<Student> findByDepartment(String dept);
    void update(Student student);
    void delete(Long id);
    Long countStudent();
    List<Student> findByCGPAGreaterThan(double cgpa);
    void updateCgpaById(Long id, double newCgpa);
    List<Student> sortByAgeDesc();
    List<Student> sortByCgpa();
    List<Student> sortByAgeNative();
}
