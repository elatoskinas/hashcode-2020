package com.company;

import java.util.*;

public class Library implements Comparable<Library>{
    public int id;
    public ArrayList<Book> books;
    public int signupTime;
    public int shipPerDay;
    public int totalScore;
    public double value;

    public Library(int id, ArrayList<Book> books, int signupTime, int shipPerDay) {
        this.id = id;
        this.books = books;
        this.signupTime = signupTime;
        this.shipPerDay = shipPerDay;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("[Library: ")
                .append("ID: ").append(id).append(", ")
                .append("Signup Time: ").append(signupTime).append(", ")
                .append("Ship per day: ").append(shipPerDay)
                .append("]");

        return builder.toString();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void computeValue() {
        int totalScore = 0;
        for (Book book : this.books) {
            totalScore += book.score;
            System.out.println("reached");
        }
        this.totalScore = totalScore;
        this.value = (this.shipPerDay * totalScore) / (double) signupTime;
    }

    @Override
    public int compareTo(Library other) {
        if (this.value - other.value < 0) return 1;
        else if (this.value - other.value > 0) return -1;
        else return 0;
    }
}
