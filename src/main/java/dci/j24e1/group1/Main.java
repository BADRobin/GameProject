package dci.j24e1.group1;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        private static final String URL = "jdbc:postgresql://localhost:5432/random_numbers_with_colors";
//        private static final String USER = "postgres";
//        private static final String PASSWORD = "root";
        System.out.println("Welcome to Hell !!! ");
        System.out.println("Enter \"quit\" to exit the program ");

        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;
        while (gameRunning) {
            String input = scanner.nextLine();
            switch (input) {
                case "go left" :
                    System.out.println("Ok. I going left"); break;
                case "quit":
                    gameRunning = false; break;
                case null, default:
                    System.out.println("Invalid input");

            }
        }
        System.out.println("Goodbye! See you... never!!!" );
    }
}