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

    public String solve() {
        // Naive shortest signup time first
        PriorityQueue<Library> libraryQueue = new PriorityQueue<Library>(new Comparator<Library>() {
            @Override
            public int compare(Library o1, Library o2) {
                return Integer.compare(o1.signupTime, o2.signupTime);
            }
        });

        libraryQueue.addAll(libraries);

        int scanReady = 0;
        Library scanLibrary = null;
        Set<Library> scanLibraries = new HashSet<>();
        List<Library> result = new ArrayList<>();
        Set<Integer> usedBooks = new HashSet<>();

        for (int d = 0; d <= dayCount; ++d) {
            // Cannot scan book yet
            if (scanReady < d) {
                if (scanLibrary != null) {
                    // Queue library
                    scanLibraries.add(scanLibrary);
                    result.add(scanLibrary);
                }

                // Scan next one
                scanLibrary = libraryQueue.poll();

                // Update scan ready time
                if (scanLibrary != null) {
                    scanReady = d + scanLibrary.signupTime;
                }
            }

            // Maintain libraries to no longer consider
            Set<Library> removeLibraries = new HashSet<>();

            // Go thrrough all scan libraries
            for (Library library : scanLibraries) {
                int booksGot = 0;

                // Ship all possible books
                while (library.hasBook() && booksGot < library.shipPerDay) {
                    // Get next book
                    Book book = library.getNext();

                    if (book != null) {
                        // Add book
                        if (!usedBooks.contains(book.id)) {
                            library.addScanBook(book);
                            usedBooks.add(book.id);
                            booksGot++;
                        }
                    }
                }

                // No more books; No longer scan library.
                if (!library.hasBook()) {
                    removeLibraries.add(library);
                }
            }

            // Remove all libraries to no longer consider
            scanLibraries.removeAll(removeLibraries);
        }

        List<LibraryAnswer> answers = new ArrayList<>();

        for (Library library : result) {
            LibraryAnswer answer = new LibraryAnswer(library.id);

            for (Book b : library.booksToScan) {
                answer.addBook(b);
            }

            answers.add(answer);
        }

        return getAnswer(answers);
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
