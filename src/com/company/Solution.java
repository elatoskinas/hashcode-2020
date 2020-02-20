package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public List<Book> books;
    public List<Library> libraries;
    public int dayCount;
    private String outputName;

    public Solution(String filename) {
        File file = new File(filename);
        this.outputName = filename.substring(0, filename.length() - 3);

        Scanner scanner = null;

        try {
            scanner = new Scanner(file);

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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeAnswer(List<LibraryAnswer> answers) {
        StringBuilder result = new StringBuilder();
        result.append(answers.size()).append("\n");

        for (LibraryAnswer answer : answers) {
            result.append(answer.toString()).append("\n");
        }

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("output/" + outputName + ".txt"));
            writer.write(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void solve() {
        // ...
        // Write here (by writeAnswer)
    }
}
