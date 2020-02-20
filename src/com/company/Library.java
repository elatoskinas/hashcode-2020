package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Library implements Comparable<Library>{
    public int id;
    public List<Book> bookIds;
    public int signupTime;
    public int shipPerDay;

    public int addVal;
    public int totalsum;


    public Library(int id, List<Book> bookIds, int signupTime, int shipPerDay){
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
        this.bookIds.add(book);
    }

    @Override
    public int compareTo(Library o) {
        return o.shipPerDay*o.addVal/o.signupTime - this.shipPerDay*addVal/this.signupTime;
    }




}
