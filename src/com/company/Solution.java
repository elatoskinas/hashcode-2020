package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.*;
import java.io.*;

public class Solution {
    public List<Book> books;
    public List<Library> libraries;
    public int dayCount;
    private String outputName;

    public Solution(String filename) {
        File file = new File(filename);
        this.outputName = filename.substring(6, filename.length() - 4);

    public ArrayList<Integer> solutionBooks;

    public Solution() {
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

            Library library = new Library(i, new ArrayList<Book>(), signupProcess, shipPerDay);
            int sum = 0;
            for (int j = 0; j < libraryBooks; j++) {
                int bookId = scanner.nextInt();
                library.addBook(books.get(bookId)); // add book to current library
                books.get(bookId).addLibrary(library); // add library book belongs to
                sum += books.get(bookId).score;
            }
            library.totalsum = sum;

                libraries.add(library);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //System.out.println(libraries);
        //System.out.println(books);
        solve();
    }


    public void solve() {

            for (int i = 0; i < libraries.size(); i++)
                libraries.get(i).addVal = libraries.get(i).totalsum;
            Collections.sort(libraries);
            //System.out.println(libraries);

            int day = 0;
            int score = 0;

            ArrayList<Library> solution = new ArrayList<Library>();
            ArrayList<ArrayList<Integer>> booksIDD = new ArrayList<>();
            while (day < dayCount && libraries.size() > 0) {
                Library lib = libraries.get(0);
                // System.out.println("selected library " + lib);

                day += lib.signupTime;
                int sc = 0;
                if (day < dayCount) {
                    sc = getScore(lib, day);
                    solution.add(lib);
                    booksIDD.add(solutionBooks);

                }
                score += sc;
                //System.out.println("score for library " + sc + "\n");


                libraries.remove(0);
                if (libraries.size() > 0)
                    Collections.sort(libraries);
            }
            //System.out.println("score " + score);

            //System.out.prinln(solution.size());
            System.out.println(solution.size());
            StringBuilder builder = new StringBuilder();
            builder.append(solution.size()).append("\n");
            for (int i = 0; i < solution.size(); i++) {
                builder.append(solution.get(i).id).append(" ").append(booksIDD.get(i).size()).append("\n");
//            System.out.println(solution.get(i).id + " " + booksIDD.get(i).size());
//            str += solution.get(i).id + " " + booksIDD.get(i).size()
                for (int j = 0; j < booksIDD.get(i).size(); j++)
                    builder.append(booksIDD.get(i).get(j)).append(" ");
//                System.out.print(booksIDD.get(i).get(j) + " ");
//            System.out.println();
                builder.append("\n");

            }
            this.writeAnswer(builder.toString());
        }

    public void writeAnswer(String result) {
//        StringBuilder result = new StringBuilder();
//        result.append(answers.size()).append("\n");
//
//        for (LibraryAnswer answer : answers) {
//            result.append(answer.toString()).append("\n");
//        }

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("output/" + outputName + ".txt"));
            writer.write(result);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getScore (Library lib, int day){
        Collections.sort(lib.bookIds);
        int score = 0;
        int j = 0;
        solutionBooks = new ArrayList<Integer>();
        for (;day<dayCount && j < lib.bookIds.size();day++){
            //System.out.println("day" + day);
            for (int i = 1;i<=lib.shipPerDay && j < lib.bookIds.size();i++){
                if (lib.bookIds.get(j).score !=0){
                    solutionBooks.add(j);
                }
                score += lib.bookIds.get(j).score;
                lib.bookIds.get(j).score = 0;
                j ++;
            }
        }
        return score;
    }

}
