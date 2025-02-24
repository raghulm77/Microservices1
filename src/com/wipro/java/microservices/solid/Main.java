package com.wipro.java.microservices.solid;


public class Main {
    public static void main(String[] args) {
        Book book = new Book("Effective Java", "Joshua Bloch", 2018, 50, "978-0134685991");
        book.displayBookDetails();

        double discountedPrice = book.applyDiscount(10); // Applying 10% discount
        System.out.println("Discounted Price: $" + discountedPrice);
    }
}
