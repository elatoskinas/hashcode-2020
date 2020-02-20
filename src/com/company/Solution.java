package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public List<Book> books;
    public List<Library> libraries;
    public int dayCount;

    public Solution() {
        Scanner scanner = new Scanner(System.in);

        // Get counts
        int bookCount = scanner.nextInt();
        int libraryCount = scanner.nextInt();
        this.dayCount = scanner.nextInt();

        this.books = new ArrayList<>();

        for (int i = 0; i < bookCount; i++) {
            books.add(new Book(i, scanner.nextInt()));
        }

        this.libraries = new ArrayList<>();

        for (int i = 0; i < libraryCount; ++i) {
            int libraryBooks = scanner.nextInt();
            int signupProcess = scanner.nextInt();
            int shipPerDay = scanner.nextInt();

            Library library = new Library(i, new HashMap<Integer, Book>(), signupProcess, shipPerDay);

            for (int j = 0; j < libraryBooks; j++) {
                int bookId = scanner.nextInt();
                library.addBook(books.get(bookId)); // add book to current library
                books.get(bookId).addLibrary(library); // add library book belongs to
            }

            libraries.add(library);
        }

        System.out.println(libraries);
        System.out.println(books);
    }

    public String getAnswer(List<LibraryAnswer> answers) {
        StringBuilder result = new StringBuilder();
        result.append(answers.size()).append("\n");

        for (LibraryAnswer answer : answers) {
            result.append(answer.toString()).append("\n");
        }

        return result.toString();
    }

}
