package com.wipro.java.microservices.solid;


public class Book implements BookOperations {
    String name;
    String authorName;
    int year;
    int price;
    String isbn;

    public Book(String name, String authorName, int year, int price, String isbn) {
        this.name = name;
        this.authorName = authorName;
        this.year = year;
        this.price = price;
        this.isbn = isbn;
    }

    
    @Override
    public void displayBookDetails() {
        System.out.println("Book Name: " + name);
        System.out.println("Author: " + authorName);
        System.out.println("Published Year: " + year);
        System.out.println("Price: $" + price);
        System.out.println("ISBN: " + isbn);
    }

    @Override
    public double applyDiscount(double discountPercentage) {
        double discountAmount = (price * discountPercentage) / 100;
        return price - discountAmount;
    }
}