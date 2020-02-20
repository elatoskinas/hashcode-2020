package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get counts
        int bookCount = scanner.nextInt();
        int libraryCount = scanner.nextInt();
        int dayCount = scanner.nextInt();
        
        HashMap<Integer, Book> books = new HashMap<>();

        for (int i = 0; i < bookCount; i++) {
            books.put(i, new Book(i, scanner.nextInt(), null));
        }

        List<Library> libraries = new ArrayList<Library>();

        for (int i = 0; i < libraryCount; ++i) {
            int libraryBooks = scanner.nextInt();
            int signupProcess = scanner.nextInt();
            int shipPerDay = scanner.nextInt();

            Library library = new Library(i, new HashMap<Integer, Book>(), signupProcess, shipPerDay);

            for (int j = 0; j < libraryBooks; j++) {
                int bookId = scanner.nextInt();
                library.addBook(books.get(bookId));
            }

            libraries.add(library);
        }

        System.out.println(libraries);
        System.out.println(books);
    }
}
