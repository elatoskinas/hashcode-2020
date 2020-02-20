package com.company;

import java.util.*;

public class Library {
    public int id;
    public HashMap<Integer, Book> bookIds;
    public int signupTime;
    public int shipPerDay;

    private PriorityQueue<Book> queuedBooks;
    public List<Book> booksToScan;

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

        this.booksToScan = new ArrayList<>();
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

    public void addScanBook(Book book) {
        this.booksToScan.add(book);
    }

    public Book getNext() {
        return queuedBooks.poll();
    }

    public boolean hasBook() {
        return !queuedBooks.isEmpty();
    }
}
