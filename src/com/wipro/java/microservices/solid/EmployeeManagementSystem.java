package com.wipro.java.microservices.solid;


interface Employeees {
 void work();
 double calculateSalary();
}

interface ManagerialDuties {
 void manageTeam();
}

class Developer implements Employeees {
 private String name;
 private double salary;

 public Developer(String name, double salary) {
     this.name = name;
     this.salary = salary;
 }

 @Override
 public void work() {
     System.out.println(name + " is writing code.");
 }

 @Override
 public double calculateSalary() {
     return salary;
 }
}

class SecurityGuard implements Employeees {
 private String name;
 private double salary;

 public SecurityGuard(String name, double salary) {
     this.name = name;
     this.salary = salary;
 }

 @Override
 public void work() {
     System.out.println(name + " is monitoring security.");
 }

 @Override
 public double calculateSalary() {
     return salary;
 }
}

class Manager implements Employeees, ManagerialDuties {
 private String name;
 private double salary;

 public Manager(String name, double salary) {
     this.name = name;
     this.salary = salary;
 }

 @Override
 public void work() {
     System.out.println(name + " is overseeing projects.");
 }

 @Override
 public void manageTeam() {
     System.out.println(name + " is managing the team.");
 }

 @Override
 public double calculateSalary() {
     return salary;
 }
}

//Payroll Service - Handles salary calculations
class PayrollService {
 public static void processPayroll(Employeees employee) {
     System.out.println("Processing salary for " + employee.calculateSalary());
 }
}

//Attendance Service - Tracks employee attendance
class AttendanceService {
 public static void markAttendance(Employeees employee) {
     System.out.println(employee.getClass().getSimpleName() + " attendance marked.");
 }
}

//Notification Service - Sends notifications to employees
class NotificationService {
 public static void sendNotification(Employeees employee, String message) {
     System.out.println("Notification to " + employee.getClass().getSimpleName() + ": " + message);
 }
}

public class EmployeeManagementSystem {
 public static void main(String[] args) {
     Employeees dev = new Developer("Alice", 80000);
     Employeees guard = new SecurityGuard("Bob", 40000);
     Manager manager = new Manager("Charlie", 100000);

     dev.work();
     guard.work();
     manager.work();
     manager.manageTeam();

     AttendanceService.markAttendance(dev);
     AttendanceService.markAttendance(guard);
     AttendanceService.markAttendance(manager);

     PayrollService.processPayroll(dev);
     PayrollService.processPayroll(guard);
     PayrollService.processPayroll(manager);

     NotificationService.sendNotification(manager, "Meeting at 10 AM");
     NotificationService.sendNotification(dev, "Code review scheduled");
 }
}

