package Task;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public class StreamApiTaskOne {


        public static void main(String[] args) {

            List<Employee> employees = new ArrayList<>();

            employees.add(new Employee(1, "Aniket", "IT", "Manager", 25, 2, 120000, 4));
            employees.add(new Employee(2, "Rahul", "IT", "Developer", 28, 5, 90000, 3));
            employees.add(new Employee(3, "Aman", "HR", "Manager", 30, 4, 150000, 5));
            employees.add(new Employee(4, "Priya", "IT", "Manager", 26, 1, 110000, 2));


            List<String>result=employees.stream().
                    //step1:Filter
            filter(e->e.getJobTitle().equalsIgnoreCase("Manager"))
                            .filter(e->e.getSalary()>100000)
                                    .filter(e-> e.getYearsOfExperience()<=3)
                                            .sorted(
                                                    Comparator.comparing(Employee::getYearsOfExperience).reversed()
                                                            .thenComparing(Employee::getPerformanceRating)
                                            ).map(e->{
                                                String reversed=new StringBuilder(e.getName()).reverse().toString().toUpperCase();
                                                return reversed;

                                            })
                            .collect(Collectors.toList());

            System.out.println(result);
        }

}
