package Callable_Statements;

public class MainApp {
    public static void main(String[] args) throws Exception {
        EmployeeService service = new EmployeeService();
        service.insertEmployee( 1, "veer" , "job");
    }
}
