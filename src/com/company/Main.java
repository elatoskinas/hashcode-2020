package com.company;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] inputs = new File("input/").list();

        for (int i = 0; i < inputs.length; ++i) {
            String file = inputs[i];
            Solution solution = new Solution("input/" + file);
            solution.solve();
        }
    }

}
