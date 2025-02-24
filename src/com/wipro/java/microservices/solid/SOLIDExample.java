package com.wipro.java.microservices.solid;


//1. Single Responsibility Principle (SRP)
class Logger {
 public void log(String message) {
     System.out.println(message);
 }
}

class Order {
 private Logger logger;

 public Order(Logger logger) {
     this.logger = logger;
 }

 public void processOrder(String orderDetails) {
     logger.log("Processing order: " + orderDetails);
     
 }
}

//2. Open/Closed Principle (OCP)
abstract class PaymentProcessor {
 public abstract void processPayment(double amount);
}

class CreditCardPayments extends PaymentProcessor {
 @Override
 public void processPayment(double amount) {
     System.out.println("Processing credit card payment of " + amount);
 }
}

class PayPalPayments extends PaymentProcessor {
 @Override
 public void processPayment(double amount) {
     System.out.println("Processing PayPal payment of " + amount);
 }
}

//3. Liskov Substitution Principle (LSP)
class PaymentService {
 public void processPayment(PaymentProcessor paymentProcessor, double amount) {
     paymentProcessor.processPayment(amount);
 }
}

//4. Interface Segregation Principle (ISP)
interface Printer {
 void print(String document);
}

interface Scanner {
 void scan(String document);
}

class MultiFunctionPrinter implements Printer {
 @Override
 public void print(String document) {
     System.out.println("Printing: " + document);
 }
}

class SimpleScanner implements Scanner {
 @Override
 public void scan(String document) {
     System.out.println("Scanning: " + document);
 }
}

//5. Dependency Inversion Principle (DIP) - Implementing Dependency Injection
class OrderService {
 private PaymentProcessor paymentProcessor;
 private Logger logger;

 public OrderService(PaymentProcessor paymentProcessor, Logger logger) {
     this.paymentProcessor = paymentProcessor;
     this.logger = logger;
 }

 public void placeOrder(String orderDetails, double amount) {
     logger.log("Order placed: " + orderDetails);
     paymentProcessor.processPayment(amount);
 }
}

public class SOLIDExample {
 public static void main(String[] args) {
     Logger logger = new Logger();
     PaymentProcessor creditCardPayment = new CreditCardPayments();
     OrderService orderService = new OrderService(creditCardPayment, logger);

     orderService.placeOrder("Laptop", 1200);
 }
}