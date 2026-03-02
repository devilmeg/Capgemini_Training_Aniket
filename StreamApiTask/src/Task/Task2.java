package Task;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
public class Task2 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Aniket", "IT", "Manager", 25, 2, 100000, 7),
                new Employee(2, "Rahul", "IT", "Developer", 28, 4, 80000, 6),
                new Employee(3, "Aman", "HR", "Manager", 30, 6, 90000, 9),
                new Employee(4, "Priya", "IT", "Developer", 26, 3, 70000, 5),
                new Employee(5, "Neha", "Finance", "Analyst", 29, 1, 110000, 7)
        );

        List<Integer> result = employees.stream()

                // Step 1: Filter
                .filter(e -> e.getYearsOfExperience() <= 5
                        && e.getPerformanceRating() < 8
                        && e.getSalary() >= 60000
                        && e.getSalary() <= 120000)

                // Step 2: Sort
                .sorted(
                        Comparator.comparing(Employee::getSalary)
                                .thenComparing(
                                        Comparator.comparing(Employee::getYearsOfExperience)
                                                .reversed()
                                )
                )

                // Step 3: Multiply ID by 10
                .map(e -> e.getId() * 10)

                // Step 4: Collect
                .collect(Collectors.toList());

        System.out.println(result);

    }
}
