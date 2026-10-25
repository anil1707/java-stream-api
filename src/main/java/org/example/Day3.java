package org.example;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day3 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "Anil", "IT", 70000),
                new Employee(2, "Rahul", "HR", 50000),
                new Employee(3, "Amit", "IT", 90000),
                new Employee(4, "Priya", "Finance", 80000),
                new Employee(5, "Neha", "HR", 60000),
                new Employee(6, "Ravi", "IT", 75000),
                new Employee(7, "Karan", "Finance", 90000),
                new Employee(8, "Sneha", "IT", 60000)
        );

//        Problem 1 — Partition Employees by Salary
//        Map<Boolean,List<Employee>> map = employees.stream()
//                .collect(Collectors.partitioningBy(emp -> emp.getSalary() >= 75000));
//
//        for(Map.Entry<Boolean, List<Employee>> entry : map.entrySet()){
//            System.out.println(entry.getKey() ? "High Salary Employee" : "Low Salary Employee: ");
//            for(Employee emp : entry.getValue()){
//                System.out.println(". " + emp.getName() + ": " + emp.getSalary()  );
//            }
//        }

//        Problem 2: Group employees by department, and within each department, group them by salary category.
//
//        Salary categories:
//        - HIGH — salary greater than or equal to ₹75,000
//                - LOW — salary below ₹75,000

//        Map<String, Map<Boolean, List<Employee>>> map = employees.stream()
//                .collect(
//                        Collectors.groupingBy(emp -> emp.getDepartment(),
//                        Collectors.partitioningBy(emp -> emp.getSalary() >= 75000))
//                );
//
//        for(Map.Entry<String, Map<Boolean, List<Employee>>> entry : map.entrySet() ){
//            System.out.println(entry.getKey());
//            for(Map.Entry<Boolean, List<Employee>> entry1 : entry.getValue().entrySet()){
//                System.out.println(entry1.getKey() ? "High Salary Employee" : "Low Salary Employee: ");
//                for(Employee emp : entry1.getValue()){
//                    System.out.println(".     " + emp.getName() + ": " + emp.getSalary());
//                }
//            }
//        }

//        Problem 3: Group employees by department and calculate the salary statistics
//        Map<String, DoubleSummaryStatistics> map = employees.stream()
//                .collect(
//                        Collectors.groupingBy(emp -> emp.getDepartment(),
//                                Collectors.summarizingDouble(emp -> emp.getSalary()))
//                );
//
//        map.forEach((key, value) ->{
//            System.out.println(key);
//            System.out.println(value);
//        });

//        Problem 4: Find the department with the largest salary difference (maximum salary minus minimum salary).
        Map<String, DoubleSummaryStatistics> map = employees.stream()
                .collect(
                        Collectors.groupingBy(emp -> emp.getDepartment(),
                                Collectors.summarizingDouble(emp -> emp.getSalary()

                                        ))
                );

        Map<String, Double> diffMap = map.entrySet().stream()
                .collect((Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue().getMax() - entry.getValue().getMin()
                )));

        Map.Entry<String,Double> ans = diffMap.entrySet().stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue()))
                .orElse(null);

        System.out.println(ans.getKey() + ": " + ans.getValue());




    }
}
