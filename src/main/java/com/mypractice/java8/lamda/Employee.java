package com.mypractice.java8.lamda;

import java.util.Comparator;

interface EmployeeAge{
    public boolean test(Employee t);
}
public class Employee {
    private  int age;
    EmployeeAge employeeAge;
    public Employee(){}
    public Employee(EmployeeAge employeeAge) {
        this.employeeAge = employeeAge;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    //Passing lambda Expression to method
    public boolean doAgeCheck(Employee employee){
        return  employeeAge.test(employee);
    }
    public  static void main(String []ar){
        Employee employee = new Employee();
        employee.setAge(20);
        EmployeeAge e= (age)-> age.getAge() > 18;
        EmployeeAge e1= age-> age.getAge() > 15;
        EmployeeAge e2=  age-> {
            return age.getAge() > 10;
        };
        EmployeeAge e3= (Employee age)-> age.getAge() < 15;
        System.out.println(e.test(employee));
        System.out.println(e1.test(employee));
        System.out.println(e2.test(employee));
        System.out.println(e3.test(employee));
        //Passing lambda Expression to method
        Employee e4 = new Employee(age-> age.getAge() > 15);
        System.out.println(e4.doAgeCheck(e4));
        //Accessing the variable from local lambda
        int counter = 3;
        EmployeeAge e5=  age-> {
            int counter1 = 1;
            //counter=5; can't change outside variable must be declare AtomicInteger
            counter1++; //can modify
            System.out.println("Inside Lambda Variable: "+counter1);
            System.out.println("OutSide Lambda Variable: "+counter);
            return age.getAge() > 10;
        };
        System.out.println(e5.test(employee));

    }
}
