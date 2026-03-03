package Task2.dao;

public interface StudentDao {
   void saveData();
   void fetchLaptopFromStudent(int studentId);
    void fetchStudentFromLaptop(int laptopId);


    void updateLaptopBrand(int laptopId, String newBrand);
    void updateStudentCourse(int studentId, String newCourse);

    void changeLaptopForStudent(int studentId,int newLaptopId);
    void removeLaptopFromStudent(int student_id);
    void deleteStudentAndLaptop(int studentId);
}
