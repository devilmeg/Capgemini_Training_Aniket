package Task2.dao;
import Task2.repository.Repository;
import Task2.entity.Student1;
import Task2.entity.Laptop;
import jakarta.persistence.*;

public class StudentDaoImpl implements StudentDao{

    @Override
    public void saveData(){
        EntityManager em = Repository.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // 1
        Laptop laptop1 = new Laptop();
        laptop1.setBrand("HP");
        laptop1.setModel("Pavilion");

        Student1 st1 = new Student1();
        st1.setName("Aniket");
        st1.setCourse("CSE");
        st1.setLaptop(laptop1);
        em.persist(st1);

        // 2
        Laptop laptop2 = new Laptop();
        laptop2.setBrand("Dell");
        laptop2.setModel("Inspiron");

        Student1 st2 = new Student1();
        st2.setName("Rahul");
        st2.setCourse("IT");
        st2.setLaptop(laptop2);
        em.persist(st2);

        // 3
        Laptop laptop3 = new Laptop();
        laptop3.setBrand("Lenovo");
        laptop3.setModel("ThinkPad");

        Student1 st3 = new Student1();
        st3.setName("Priya");
        st3.setCourse("ECE");
        st3.setLaptop(laptop3);
        em.persist(st3);

        // 4
        Laptop laptop4 = new Laptop();
        laptop4.setBrand("Asus");
        laptop4.setModel("Vivobook");

        Student1 st4 = new Student1();
        st4.setName("Karan");
        st4.setCourse("ME");
        st4.setLaptop(laptop4);
        em.persist(st4);

        // 5
        Laptop laptop5 = new Laptop();
        laptop5.setBrand("Acer");
        laptop5.setModel("Aspire");

        Student1 st5 = new Student1();
        st5.setName("Sneha");
        st5.setCourse("CSE");
        st5.setLaptop(laptop5);
        em.persist(st5);

        // 6
        Laptop laptop6 = new Laptop();
        laptop6.setBrand("Apple");
        laptop6.setModel("MacBook Air");

        Student1 st6 = new Student1();
        st6.setName("Vikram");
        st6.setCourse("AI");
        st6.setLaptop(laptop6);
        em.persist(st6);

        tx.commit();
        em.close();

        System.out.println("6 Records Saved Successfully");
    }

    //2.------- Fetch laptop using student
    @Override
    public void fetchLaptopFromStudent(int StudentId){
        EntityManager em = Repository.getEmf().createEntityManager();
        Student1 s = em.find(Student1.class,(long)StudentId);

        if(s!=null){
            System.out.println(s.getLaptop());
        }
        em.close();
    }

    //3....fetch Student From Laptop
    @Override
    public void fetchStudentFromLaptop(int laptopId) {

        EntityManager em = Repository.getEmf().createEntityManager();

        Laptop laptop = em.find(Laptop.class, (long) laptopId);

        if (laptop != null) {
            System.out.println(laptop.getStudent());
        }

        em.close();
    }

    //  updateLaptopBrand
    @Override
    public void updateLaptopBrand(int laptopId, String newBrand) {

        EntityManager em = Repository.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Laptop laptop = em.find(Laptop.class, (long) laptopId);

        if (laptop != null) {
            laptop.setBrand(newBrand);
        }

        tx.commit();
        em.close();

        System.out.println("Laptop brand updated!");
    }

    //updateStudentCourse
    @Override
    public void updateStudentCourse(int studentId, String newCourse) {

        EntityManager em = Repository.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Student1 student = em.find(Student1.class, (long) studentId);

        if (student != null) {
            student.setCourse(newCourse);
        }

        tx.commit();
        em.close();

        System.out.println("Student course updated!");
    }

    //............ changeLaptopForStudent..
    @Override
    public void changeLaptopForStudent(int studentId, int newLaptopId) {

        EntityManager em = Repository.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Student1 student = em.find(Student1.class, (long) studentId);

        if (student == null) {
            System.out.println("Student Not Found");
            tx.rollback();
            em.close();
            return;
        }

        Laptop newLaptop = em.find(Laptop.class, (long) newLaptopId);

        if (newLaptop == null) {

            newLaptop = new Laptop();
            newLaptop.setBrand("RandomBrand_" + newLaptopId);
            newLaptop.setModel("Model_" + newLaptopId);

            em.persist(newLaptop);

            System.out.println("New Laptop Created and Saved");
        }

        // Remove old relationship properly
        Laptop oldLaptop = student.getLaptop();

        if (oldLaptop != null) {
            oldLaptop.setStudent(null);
        }

        // Set new relationship on both sides
        student.setLaptop(newLaptop);
        newLaptop.setStudent(student);

        tx.commit();
        em.close();

        System.out.println("Laptop Changed Successfully");
    }
    @Override
    public void removeLaptopFromStudent(int studentId) {

        EntityManager em = Repository.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Student1 student = em.find(Student1.class, (long) studentId);

            if (student == null) {
                System.out.println("Student Not Found");
                tx.rollback();
                return;
            }

            Laptop laptop = student.getLaptop();

            if (laptop == null) {
                System.out.println("Student does not have any laptop assigned.");
                tx.rollback();
                return;
            }

            // break bidirectional relationship
            laptop.setStudent(null);
            student.setLaptop(null);

            tx.commit();
            System.out.println("Laptop removed successfully!");

        } catch (Exception e) {

            if (tx.isActive()) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {
            em.close();
        }
    }

    //**********deleteStudentAndLaptop
    @Override
    public void deleteStudentAndLaptop(int studentId) {

        EntityManager em = Repository.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Student1 student = em.find(Student1.class, (long) studentId);

        if (student != null) {
            em.remove(student);  // Cascade removal work here
        }

        tx.commit();
        em.close();

        System.out.println("Student and laptop deleted!");
    }

}