package Task;

import java.util.*;
import java.util.stream.Collectors;

class Employee {

    private int id;
    private String name;
    private String department;
    private String jobTitle;
    private int age;
    private int yearsOfExperience;
    private double salary;
    private int performanceRating;

    public Employee(int id, String name, String department,
                    String jobTitle, int age,
                    int yearsOfExperience, double salary,
                    int performanceRating) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.jobTitle = jobTitle;
        this.age = age;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
        this.performanceRating = performanceRating;
    }

    // Getters
    public String getName() { return name; }
    public String getJobTitle() { return jobTitle; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public double getSalary() { return salary; }
    public int getPerformanceRating() { return performanceRating; }

    public Integer getId() {
        return id;
    }
}

