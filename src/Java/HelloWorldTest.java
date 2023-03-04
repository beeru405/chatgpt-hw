package com.Java
import java.util.Scanner;

public class HelloWorldTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String input = scanner.next();

        if (input.equals("hello")) {
            System.out.println("Hello, World!");
        } else {
            System.out.println("Sorry, I only respond to 'hello'.");
        }

        scanner.close();
    }
}
