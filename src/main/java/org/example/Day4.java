package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day4 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "Anil", "IT", 70000),
                new Employee(2, "Rahul", "HR", 50000),
                new Employee(3, "Amit", "IT", 90000),
                new Employee(8, "Neha", "finance", 60000),
                new Employee(8, "Nakul", "HR", 40000),
                new Employee(4, "Priya", "finance", 80000),
                new Employee(5, "Neha", "HR", 60000),
                new Employee(6, "Ravi", "IT", 75000),
                new Employee(7, "Karan", "finance", 90000),
                new Employee(8, "Sneha", "IT", 65000)
        );

//        Problem 1: department with the second-highest total salary.
                    //1. Calculate the total salary for each department.
                    //2. Sort departments by total salary in descending order.
                    //3. Return the second-highest department and its total salary.
//        Map<String, Double> map = employees.stream()
//                        .collect(Collectors.groupingBy(
//                                emp -> emp.getDepartment(),
//                                Collectors.summingDouble(emp -> emp.getSalary()))
//                        );
//
//        Map.Entry<String, Double> result = map.entrySet().stream()
//                        .sorted(Comparator.comparingDouble((Map.Entry<String, Double> entry) -> entry.getValue()).reversed())
//                                .skip(1)
//                                        .findFirst()
//                                                .orElse(null);
//
//        System.out.println(result.getKey() + ": " + result.getValue());

//        Problem 2: Find the top two highest-paid employees in each department
//        Map<String, List<Employee>> map = employees.stream()
//                .collect(Collectors.groupingBy(
//                        (Employee emp) -> emp.getDepartment(),
//                        Collectors.collectingAndThen(
//                        Collectors.toList(),
//                                list -> list.stream()
//                                .sorted(Comparator.comparingDouble((Employee emp1) -> emp1.getSalary()).reversed())
//                                .limit(2)
//                                .collect(Collectors.toList())
//                        )
//                ));
//
//        map.forEach((key, value) ->{
//            System.out.println("Department: " + key);
//            for(Employee emp : value){
//                System.out.println(" Emp Name: (" + emp.getName() + ", " + emp.getSalary() + ")" );
//            }
//        });

//        Problem 3 : Highest-paid employee per department after filtering by average salary
//        Using the same Employee class and dataset:
//        1. Calculate the average salary of each department.
//        2. Exclude employees whose salary is below their department's average.
//        3. From the remaining employees, find the highest-paid employee in each department.
//        4. Return the result as Map<String, Employee>.

        Map<String, Double> map = employees.stream()
                .collect(Collectors.groupingBy(
                        (Employee emp) -> emp.getDepartment(),
                        Collectors.averagingDouble((Employee emp) -> emp.getSalary())

                ));

        Map<String, List<Employee>> ans = employees.stream()
                .collect(
                        Collectors.groupingBy(emp -> emp.getDepartment(),
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        empList -> empList.stream()
                                                .sorted(Comparator.comparingDouble((Employee emp) -> emp.getSalary()).reversed())
                                                .filter(emp -> emp.getSalary() >= map.get(emp.getDepartment()))
                                                .limit(1)
                                                .toList()
                                )
                ));

        ans.forEach((dept, empList) ->{
            System.out.println(dept);
            for(Employee emp : empList){
                System.out.println("  " + emp.getName() + ": " + emp.getSalary());
            }

        });

    }
}
