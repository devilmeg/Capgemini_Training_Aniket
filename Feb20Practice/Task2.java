package Feb20Practice;

public class Task2 {

    public static void checkSalary(double salary) throws LowSalaryException {

        if (salary < 5000) {
            throw new LowSalaryException("Salary is too low!");
        }

        System.out.println("Salary accepted.");
    }

    public static void main(String[] args) {

        try {
            checkSalary(5000);   
        } catch (LowSalaryException e) {
            System.out.println(e.getMessage());
        }
    }
}