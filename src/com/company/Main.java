package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get counts
        int bookCount = scanner.nextInt();
        int libraryCount = scanner.nextInt();
        int dayCount = scanner.nextInt();

        // TODO: Scan scores of books
        // TODO: Remove this next line
        scanner.nextLine();

        List<Library> libraries = new ArrayList<Library>();

        for (int i = 0; i < libraryCount; ++i) {
            int libraryBooks = scanner.nextInt();
            int signupProcess = scanner.nextInt();
            int shipPerDay = scanner.nextInt();

            // TODO: Scan books
            // TODO: Remove this next line
            scanner.nextLine();

            // TODO: Replace hashset with book set/list
            Library library = new Library(i, new HashSet<Integer>(), signupProcess, shipPerDay);
            libraries.add(library);
        }

        System.out.println(libraries);
    }
}
