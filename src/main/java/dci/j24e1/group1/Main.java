package dci.j24e1.group1;

import dci.j24e1.group1.command.Command;
import dci.j24e1.group1.command.CreateRandomDirectionCommand;
import dci.j24e1.group1.command.MoveCommand;
import dci.j24e1.group1.types.Direction;

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
            System.out.println("You have " + gs.getStepsRemaining() + " steps left");
            System.out.println("[left] for " + gs.getNextLeft() + " | [right] for " + gs.getNextRight());
            System.out.print("> ");
            String input = scanner.nextLine();
            try {
                switch (input) {
                    case "left":
                        Command moveLeft = new MoveCommand(Direction.LEFT);
                        moveLeft.execute(gs);
                        new CreateRandomDirectionCommand().execute(gs);
                        System.out.println("Ok. You swam in the " + gs.getCurrentArea());
                        System.out.println("You have "+ gs.getScalesCollected() +" Scales now.");
                        break;
                    case "right":
                        Command moveRight = new MoveCommand(Direction.RIGHT);
                        moveRight.execute(gs);
                        new CreateRandomDirectionCommand().execute(gs);
                        System.out.println("Ok. You swam in the " + gs.getCurrentArea());
                        System.out.println("You have "+ gs.getScalesCollected() +" Scales now.");
                        break;
                    case "quit":
                        gameRunning = false;
                        break;
                    case null, default:
                        System.out.println("Invalid input");

                }
                if (gs.getEatenBy() != null) {
                    gameRunning = false;
                    System.out.println("You got eaten by a " + gs.getEatenBy() + "!");
                }else if (gs.getScalesCollected() >= 10) {
                    gameRunning = false;
                    System.out.println("You have Found Nemo. You swim off together happily!");
                } else if (gs.stepsRemaining < 1) {
                    gameRunning = false;
                    System.out.println("You have exhausted yourself. Try to find Nemo tomorrow. Game Over!");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Goodbye! See you... never!!!");
    }
}