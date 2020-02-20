package com.company;

import java.util.HashMap;
import java.util.Set;

public class Library {
    public int id;
    public HashMap<Integer, Book> bookIds;
    public int signupTime;
    public int shipPerDay;

    public Library(int id, HashMap<Integer, Book> bookIds, int signupTime, int shipPerDay) {
        this.id = id;
        this.bookIds = bookIds;
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
        int bookId = book.getId();
        this.bookIds.put(bookId, book);
    }
}
