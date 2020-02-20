package com.company;

import java.util.ArrayList;

public class Book {
    public int id;
    public int score;
    public ArrayList<Library> libraries;

    public Book(int id, int score, ArrayList<Library> libraries) {
        this.id = id;
        this.score = score;
        this.libraries = libraries;
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

    public ArrayList<Library> getLibraries() {
        return this.libraries;
    }

    public void setLibraries(ArrayList<Library> libraries) {
        this.libraries = libraries;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("[Book: ")
                .append("ID: ").append(id).append(", ")
                .append("Score: ").append(score)
                .append("]");


        return builder.toString();
    }

    public void addLibrary(Library library) {
        this.libraries.add(library);
    }
}
