package com.company;

import java.util.HashMap;
import java.util.Set;

public class Library {
    private int id;
    private HashMap<Integer, Book> bookIds;
    private int signupTime;
    private int shipPerDay;

    public Library(int id, HashMap<Integer, Book> bookIds, int signupTime, int shipPerDay) {
        this.id = id;
        this.bookIds = bookIds;
        this.signupTime = signupTime;
        this.shipPerDay = shipPerDay;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        return builder.toString();
    }

    public void addBook(Book book) {
        int bookId = book.getId();
        this.bookIds.put(bookId, book);
    }
}
