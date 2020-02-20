package com.company;

import java.util.Set;

public class Library {
    private int id;
    private Set<Integer> bookIds; // TODO: Replace with book object
    private int signupTime;
    private int shipPerDay;

    public Library(int id, Set<Integer> bookIds, int signupTime, int shipPerDay) {
        this.id = id;
        this.bookIds = bookIds;
        this.signupTime = signupTime;
        this.shipPerDay = shipPerDay;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("[Library:\n")
                .append("ID: ").append(id).append("\n")
                .append("Signup Time: ").append(signupTime).append("\n")
                .append("Ship per day: ").append(shipPerDay).append("\n")
                .append("]\n");

        return builder.toString();
    }
}
