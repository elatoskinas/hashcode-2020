package com.company;

import java.util.*;

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

            Library library = new Library(i, new ArrayList<>(), signupProcess, shipPerDay);

            for (int j = 0; j < libraryBooks; j++) {
                int bookId = scanner.nextInt();
                library.addBook(books.get(bookId)); // add book to current library
                books.get(bookId).addLibrary(library); // add library book belongs to
            }

            library.computeValue(); // compute value and total score
            libraries.add(library);
        }
        Collections.sort(libraries);
        printValues(libraries);
    }

    public static void printValues(List<Library> libraries) {
        for (Library library : libraries) {
            System.out.println("Library " + library.id + " : " + library.totalScore);
        }
    }

    public static void printBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book.toString());
        }
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
