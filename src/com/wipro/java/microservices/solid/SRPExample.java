
package com.wipro.java.microservices.solid;

class Employee {
    public String name;
    public String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
}

class SalaryCalculator {
    public double calculateSalary(int hoursWorked, double hourlyRate) {
        return hoursWorked * hourlyRate;
    }
}

class ReportGenerator {
    public void generateReport(Employee employee, double salary) {
        System.out.println("Employee Report:");
        System.out.println("Name: " + employee.name);
        System.out.println("Department: " + employee.department);
        System.out.println("Salary: $" + salary);
    }
}

public class SRPExample {
    public static void main(String[] args) {
        
        Employee emp = new Employee("Alice", "IT");

        
        SalaryCalculator salaryCalc = new SalaryCalculator();

        
        ReportGenerator reportGen = new ReportGenerator();

       
        double salary = salaryCalc.calculateSalary(40, 30);



        reportGen.generateReport(emp, salary);
    }
}