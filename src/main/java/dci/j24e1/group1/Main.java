package dci.j24e1.group1;

import dci.j24e1.group1.command.Command;
import dci.j24e1.group1.command.CreateRandomDirectionCommand;
import dci.j24e1.group1.command.MoveCommand;
import dci.j24e1.group1.types.Area;
import dci.j24e1.group1.types.Direction;

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
        GameState gs = new GameState();

        new CreateRandomDirectionCommand().execute(gs);





        while (gameRunning) {
            System.out.println("Where do you want to go? And why? It's dangerous!");
            System.out.println("[left] for " + gs.getToLeft() + " | [right] for " + gs.getToRight());
            System.out.print("> ");
            String input = scanner.nextLine();
            switch (input) {
                case "left":
                    Command moveLeft = new MoveCommand(Direction.LEFT);
                    moveLeft.execute(gs);
                    new CreateRandomDirectionCommand().execute(gs);
                    System.out.println("Ok. You swam in the " + gs.getLocation());
                    break;
                case "right":
                    Command moveRight = new MoveCommand(Direction.RIGHT);
                    moveRight.execute(gs);
                    new CreateRandomDirectionCommand().execute(gs);
                    System.out.println("Ok. You swam in the " + gs.getLocation());
                    break;
                case "quit":
                    gameRunning = false;
                    break;
                case null, default:
                    System.out.println("Invalid input");

            }
        }
        System.out.println("Goodbye! See you... never!!!");
    }
}