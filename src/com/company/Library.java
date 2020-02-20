package com.company;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class Library {
    private int id;
    private HashMap<Integer, Book> bookIds;
    private int signupTime;
    private int shipPerDay;

    private PriorityQueue<Book> queuedBooks;

    public Library(int id, HashMap<Integer, Book> bookIds, int signupTime, int shipPerDay) {
        this.id = id;
        this.bookIds = bookIds;
        this.signupTime = signupTime;
        this.shipPerDay = shipPerDay;

        // Sort in descending order
        this.queuedBooks = new PriorityQueue<Book>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o2.score, o1.score);
            }
        });
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
        //int bookId = book.getId();
        //this.bookIds.put(bookId, book);
        this.queuedBooks.add(book);
    }
}
