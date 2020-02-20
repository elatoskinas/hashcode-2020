package com.company;

public class Book {
    public int id;
    public int score;
    public Library library;

    public Book(int id, int score, Library Library) {
        this.id = id;
        this.score = score;
        this.library = library;
    }
}
