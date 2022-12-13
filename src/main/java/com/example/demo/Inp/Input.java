package com.example.demo.Inp;

import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);
    public static long inputLong() {

        String input;
        long output;

        while (true) {
            try {
                input = scanner.nextLine().trim();
                output = Long.parseLong(input);

                return output;
            } catch (NumberFormatException e) {
                System.out.println("Please input long value!");
            }
        }
    }
}
