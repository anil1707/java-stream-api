package org.example;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Que1 {
  /*
Questiong List:
      Que1: Find employees whose salary is greater than 70,000.
      Que2: Create a list containing only employee names.
      Que3: Print the names of employees in the IT department using forEach.
      Que4: Count employees whose salary is greater than 60,000.
      Que5 Find distinct salaries.
      Que6: Sort employees by salary in descending order.
      Que7: Calculate the average salary of all employees and print the result.
      QUE8: Calculate the total salary of all employees
      QUE9: Find the second-highest distinct salary

 Question of Grouping
      1. Group employees by department and return Map<String, List<Employee>>.
      2. Count employees in each department.
      3. Calculate the average salary for each department.
      4. Find the highest-paid employee in each department.
      5. Collect only employee names for each department
      6. Find the department with the highest average salary.


   */

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

        //   Que1: Find employees whose salary is greater than 70,000.
//        employees.stream()
//                .filter(emp -> emp.getSalary() > 70000)
//                .forEach(
//                        employee ->
//                                System.out.println(employee.getName() + ", " + employee.getSalary()
//                        ));

        //    Que2: Create a list containing only employee names.
//        List<String> emplNameList = employees.stream()
//                .map(employee -> employee.getName())
//                .toList();

//        System.out.println(emplNameList);

//        Que3: Print the names of employees in the IT department using forEach.
//        employees.stream()
//                .filter(employee -> employee.getDepartment().equals("IT"))
//                .forEach(employee -> System.out.println(employee.getName()));

//        Que4: Count employees whose salary is greater than 60,000.
//        long employCount = employees.stream()
//                .filter(employee -> employee.getSalary() > 60000)
//                .count();
//
//        System.out.println(employCount);

//        Que5 Find distinct salaries.
//        employees.stream()
//                .map(employee -> employee.getSalary())
//                .distinct()
//                .forEach(System.out::println);

//        Que6: Sort employees by salary in descending order.
//        employees.stream()
//                .sorted(Comparator.comparingDouble((Employee employee) -> employee.getSalary()).reversed())
//
//                .forEach(employee -> System.out.println(employee.getName() + ": " + employee.getSalary()));

//        Que7: Calculate the average salary of all employees and print the result.
//          double avg = employees.stream()
//                  .mapToDouble(emp-> emp.getSalary())
//                  .average()
//                  .orElse(0.0);
//
//        System.out.println(avg);

//        QUE8: Calculate the total salary of all employees
//        double total = employees.stream()
//                .mapToDouble(emp -> emp.getSalary())
//                .sum();
//
//        System.out.println(total);

//        QUE9: Find the second-highest distinct salary
//        Optional<Double> secondHighestSalary = employees.stream()
//                .map(emp -> emp.getSalary())
//                .sorted(Comparator.reverseOrder())
//                .distinct()
//                .skip(1)
//                .limit(1)
//
//                .findFirst();
//        System.out.println(secondHighestSalary.orElse(null));

//        QUE10: Find the highest-paid employee in each department using Java Streams and
//        Map<String, Optional<Employee>> map = employees.stream()
//                .collect(Collectors.groupingBy(
//                        emp -> emp.getDepartment(),
//                        Collectors.maxBy(Comparator.comparingDouble((Employee emp) -> emp.getSalary()))));
//
//        map.forEach((key, value) ->{
//            System.out.println("Department: " + key);
//            System.out.println(value.get().getName() + ": " +  value.get().getSalary());
//        });

//     sub questions on grouping by
//        1. Group employees by department and return Map<String, List<Employee>>.
//        Map<String, List<Employee>> empListByDept = employees.stream()
//                .collect(Collectors.groupingBy(emp -> emp.getDepartment()));
//
//        empListByDept.forEach((deparment, empList) ->{
//            System.out.println("Department: " + deparment);
//            for(int i = 0;i<empList.size();i++){
//                System.out.println(empList.get(i).getName() + ": " + empList.get(i).getSalary());
//            }
//        });

//       2. Count employees in each department.
//        Map<String, Long> map = employees.stream()
//                .collect(Collectors.groupingBy(emp -> emp.getDepartment(), Collectors.counting()));
//
//        map.forEach((department, empCount) -> {
//            System.out.println("Department: " + department + "and employee count: " + empCount);
//        });

//        3. Calculate the average salary for each department.
//        Map<String, Double> map = employees.stream()
//                .collect(Collectors.groupingBy(emp -> emp.getDepartment(), Collectors.averagingDouble(emp -> emp.getSalary())));
//
//        map.forEach((department, avgSalary) ->{
//            System.out.println("Department: " + department + " average salary: " + avgSalary);
//        });

//        4. Find the highest-paid employee in each department.
//        Map<String, Optional<Employee>> map= employees.stream()
//                .collect(Collectors.groupingBy(emp -> emp.getDepartment(),
//                        Collectors.maxBy(Comparator.comparingDouble((Employee emp) -> emp.getSalary())))
//                );
//
//        map.forEach((dept, emp) ->{
//            System.out.println(dept + ": avg salary(" + emp.get().getSalary() + ")" );
//        });


        //    5. Collect only employee names for each department
//        Map<String, List<String>> map = employees.stream()
//                .collect(Collectors.groupingBy(emp -> emp.getDepartment(),
//                        Collectors.mapping((Employee emp) -> emp.getName(), Collectors.toList())
//                )
//                );
//
//        map.forEach((dept, empList) -> {
//            System.out.println("Dept: " + dept +  "Emp list: " + empList);
//        });

//        6. Find the department with the highest average salary.
//        Map<String, Double> map = employees.stream()
//                .collect(Collectors.groupingBy(employee -> employee.getDepartment(),
//                        Collectors.averagingDouble((Employee emp) -> emp.getSalary())
//
//                ));
//        Optional<Map.Entry<String, Double>> result = map.entrySet().stream()
//                .max(Comparator.comparingDouble(entry -> entry.getValue()));
//        map.forEach((dept, avg) -> {
//            System.out.println(dept + ":  " + avg);
//        });
//
//        System.out.println(result.get().getValue() + ": " + result.get().getKey());
    }



}
