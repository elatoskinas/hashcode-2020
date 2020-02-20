package com.company;

import java.util.*;

public class Main {

    public static int bookCount, libraryCount, dayCount;
    public static ArrayList<Book> books;
    public static ArrayList<Library> libraries;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get counts
        bookCount = scanner.nextInt();
        libraryCount = scanner.nextInt();
        dayCount = scanner.nextInt();
        
        books = new ArrayList<>();

        for (int i = 0; i < bookCount; i++) {
            books.add(new Book(i, scanner.nextInt(), null));
        }

        libraries = new ArrayList<Library>();

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

        solve();
    }

    public static void solve(){
        Collections.sort(libraries)


    }

    public static int getAdditionalVal(Library lib){
        for ()
    }

}
