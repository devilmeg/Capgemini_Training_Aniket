package org.example.dao;
import org.example.entity.Student;
import java.util.List;
//import org.example.config.HibernateUtil;//
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.repository.StudentRepository;


public class StudentDaoImpl implements StudentDao {

    @Override
    public void save(Student student) {
        Session session = StudentRepository.getSession();
        Transaction tx = session.beginTransaction();
        session.persist(student);
        tx.commit();
        session.close();
    }

    @Override
    public Student findById(Long id) {
        Session session = StudentRepository.getSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    @Override
    public List<Student> findAll() {
        Session session = StudentRepository.getSession();
        List<Student> list =
                session.createQuery("from Student", Student.class).list();
        session.close();
        return list;
    }
    @Override
    public void updateCgpaById(Long id, double newCgpa) {

        Session session = StudentRepository.getSession();
        Transaction tx = session.beginTransaction();

        int rows = session.createQuery(
                        "update Student s set s.cgpa = :cgpa where s.id = :id")
                .setParameter("cgpa", newCgpa)
                .setParameter("id", id)
                .executeUpdate();

        tx.commit();
        session.close();

        if (rows > 0) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
    @Override
    public List<Student> sortByAgeDesc() {

        Session session = StudentRepository.getSession();

        List<Student> list = session.createQuery(
                        "from Student s order by s.age desc",
                        Student.class)
                .getResultList();

        session.close();
        return list;
    }
    @Override
    public List<Student> sortByCgpa() {
        Session session=StudentRepository.getSession();
        List<Student>list=session.createQuery("from Student s order by desc s.cgpa",Student.class)
                .getResultList();
        session.close();
        return list;
    }
    @Override
    public List<Student> sortByAgeNative() {
        Session session = StudentRepository.getSession();
        List<Student> list = session.createNativeQuery(
                        "SELECT * FROM students ORDER BY age DESC",
                        Student.class)
                .getResultList();
        session.close();
        return list;
    }
    @Override
    public List<Student> findByDepartment(String dept) {
        Session session = StudentRepository.getSession();
        List<Student> list =
                session.createQuery("from Student where department = :dept", Student.class)
                        .setParameter("dept", dept)
                        .list();
        session.close();
        return list;
    }

    @Override
    public List<Student> findByCGPAGreaterThan(double cgpa) {
        Session session = StudentRepository.getSession();
        List<Student> list =
                session.createQuery("from Student where cgpa > :cgpa", Student.class)
                        .setParameter("cgpa", cgpa)
                        .list();
        session.close();
        return list;
    }

    @Override
    public void update(Student student) {
        Session session = StudentRepository.getSession();
        Transaction tx = session.beginTransaction();
        session.merge(student);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
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
    public Long countStudent() {
        Session session = StudentRepository.getSession();
        Long count = session.createQuery(
                        "select count(s) from Student s", Long.class)
                .uniqueResult();
        session.close();
        return count;
    }
}