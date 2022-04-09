package com.mypractice.java8.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringEmployees {

    public static void main(String ... args){

        List<Employee> employees = Arrays.asList(new Employee(20,"Jalaluddin"),
                                              new Employee(30, "Nasruddin"),
                                              new Employee(50, "Rehan"));

        List<Employee> nameEmployees = filterEmployees(employees, FilteringEmployees::isNameEmployee);
        System.out.println(nameEmployees);
        
        List<Employee> ageEmployees = filterEmployees(employees, FilteringEmployees::isAgeGreterThan20Employee);
        System.out.println(ageEmployees);
        
        List<Employee> nameEmployees2 = filterEmployees(employees, (Employee a) -> "Rehan".equals(a.getName()));
        System.out.println(nameEmployees2);
        
        List<Employee> ageEmployees2 = filterEmployees(employees, (Employee a) -> a.getAge() >= 50);
        System.out.println(ageEmployees2);
        

        List<Employee> ageLowestEmployee = filterEmployees(employees, (Employee a) -> a.getAge() <= 30 ||
                                                                       "Jalaluddin".equals(a.getAge()));
        System.out.println(ageLowestEmployee);
    }

    public static List<Employee> filterEmployees(List<Employee> employees){
        List<Employee> result = new ArrayList<>();
        for (Employee employee: employees){
            if ("Rehan".equals(employee.getName())) {
                result.add(employee);
            }
        }
        return result;
    }

    public static List<Employee> filterAgeEmployees(List<Employee> inventory){
        List<Employee> result = new ArrayList<>();
        for (Employee employee: inventory){
            if (employee.getAge() >= 50) {
                result.add(employee);
            }
        }
        return result;
    }

    public static boolean isNameEmployee(Employee employee) {
        return "Nasruddin".equals(employee.getName());
    }

    public static boolean isAgeGreterThan20Employee(Employee employee) {
        return employee.getAge() > 0;
    }

    public static List<Employee> filterEmployees(List<Employee> inventory, Predicate<Employee> p){

       return inventory.stream().filter(p).collect(Collectors.toList());
      //  return result;
    }       

    public static class Employee {
        private int age = 0;
        private String name = "";

        public Employee(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
