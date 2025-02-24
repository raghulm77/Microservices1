package com.wipro.java.microservices.solid;

abstract class Payment {
 public abstract void pay(double amount);
}

class CreditCardPayment extends Payment {
 public void pay(double amount) {
     System.out.println("Paid $" + amount + " using Credit Card.");
 }
}

class PayPalPayment extends Payment {
 public void pay(double amount) {
     System.out.println("Paid $" + amount + " using PayPal.");
 }
}

class UPIPayment extends Payment {
 public void pay(double amount) {
     System.out.println("Paid $" + amount + " using UPI.");
 }
}

public class OCPExample {
 public static void main(String[] args) {
     
     Payment payment1 = new CreditCardPayment();
     payment1.pay(250.75);

     
     Payment payment2 = new PayPalPayment();
     payment2.pay(99.99);



     Payment payment3 = new UPIPayment();
     payment3.pay(500.00);
 }
}