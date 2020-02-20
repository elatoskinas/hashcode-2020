package com.company;

import java.util.ArrayList;
import java.util.List;

public class LibraryAnswer {
    private int id;
    private List<Integer> books;

    public LibraryAnswer(int id) {
        this.id = id;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book.id);
    }

    public String toString() {
        StringBuilder result = new StringBuilder(id + " " + books.size() + "\n");

        for (int book : books) {
            result.append(book).append(" ");
        }

        return result.toString();
    }
}
