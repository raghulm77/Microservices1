package com.wipro.java.microservices.solid;


abstract class Vehicle {
public abstract void move();
}

class Car extends Vehicle {
public void move() {
   System.out.println("Car is moving on the road.");
}

public void startEngine() {
   System.out.println("Car engine started.");
}
}

class Bicycle extends Vehicle {
public void move() {
   System.out.println("Bicycle is being pedaled.");
}
}

public class LSPExample {
public static void main(String[] args) {
   
   Vehicle myCar = new Car();
   myCar.move();
   ((Car) myCar).startEngine();

   
   Vehicle myBicycle = new Bicycle();
   myBicycle.move();
}
}
