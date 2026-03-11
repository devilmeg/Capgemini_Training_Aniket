package org.example.dao;


import org.example.entity.Student;
import org.example.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public void save(Student student) {
        Session session = StudentRepository.getSession();
        Transaction tx = session.beginTransaction();
        session.persist(student);
        tx.commit();
        session.close();
    }

    @Override
    public List<Student> fetchAll() {
        Session session = StudentRepository.getSession();
        List<Student> list =
                session.createQuery("from Student", Student.class).list();
        session.close();
        return list;
    }

    @Override
    public Student fetchById(int id) {
        Session session = StudentRepository.getSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    @Override
    public void updateMarks(int id, double marks) {
        Session session = StudentRepository.getSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class, id);
        if (student != null) {
            student.setMarks(marks);
        }
        tx.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = StudentRepository.getSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class, id);
        if (student != null) {
            session.remove(student);
        }
        tx.commit();
        session.close();
    }

    @Override
    public List<Student> sortByMarks() {
        Session session = StudentRepository.getSession();
        List<Student> list = session
                .createQuery("from Student order by marks", Student.class)
                .list();
        session.close();
        return list;
    }

    @Override
    public List<Student> sortByAgeDesc() {
        Session session = StudentRepository.getSession();
        List<Student> list = session
                .createQuery("from Student order by age desc", Student.class)
                .list();
        session.close();
        return list;
    }

    @Override
    public List<Student> filterByDept(String dept) {
        Session session = StudentRepository.getSession();
        List<Student> list = session
                .createQuery("from Student where dept = :d", Student.class)
                .setParameter("d", dept)
                .list();
        session.close();
        return list;
    }

    @Override
    public List<Student> nativeFetch() {
        Session session = StudentRepository.getSession();
        List<Student> list = session
                .createNativeQuery("select * from student", Student.class)
                .list();
        session.close();
        return list;
    }

    @Override
    public void nativeUpdateMarks(int id, double marks) {
        Session session = StudentRepository.getSession();
        Transaction tx = session.beginTransaction();
        session.createNativeQuery(
                        "update student set marks = :m where id = :i")
                .setParameter("m", marks)
                .setParameter("i", id)
                .executeUpdate();
        tx.commit();
        session.close();
    }
}
