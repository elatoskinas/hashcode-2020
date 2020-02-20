package com.company;

public class Book {
    public int id;
    public int score;
    public Library library;

    public Book(int id, int score, Library library) {
        this.id = id;
        this.score = score;
        this.library = library;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
