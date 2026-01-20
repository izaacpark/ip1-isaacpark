package edu.brandeis.cosi103a.ip1;

import java.util.Scanner;
import java.util.Random;

public class App {

    private static final int TURNS = 10;
    private static final int MAX_REROLLS = 2;
    private static final Random rand = new Random();
    
    public static void main(String[] args)
    {
        playgame();
    }

    public static void playgame() {
        Scanner console = new Scanner(System.in);

        int score1 = 0;
        int score2 = 0;

        for (int turn = 1; turn <= TURNS; turn++) {
            System.out.println("Turn " + turn + ":");

            System.out.println("Player 1's turn:");
            score1 += playerTurn(console, 1);

            System.out.println("Player 2's turn:");
            score2 += playerTurn(console, 2);

        }

        determineWinner(score1, score2);
        console.close();
    }

    public static int playerTurn(Scanner scanner, int playerNumber) {
        int roll = rollDies();
        int rerollsLeft = MAX_REROLLS;

        System.out.println("Player " + playerNumber + " rolled: " + roll);

        while (rerollsLeft > 0) {
            System.out.print("Player " + playerNumber + ", do you want to reroll? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("y")) {
                roll = rollDies();
                rerollsLeft--;
                System.out.println("Player " + playerNumber + " rerolled: " + roll);
            } else if (response.equals("n")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
        return roll;
    }

    public static int rollDies() {
        return rand.nextInt(6) + 1;
    }

    public static void determineWinner(int score1, int score2) {
        System.out.println("Final Scores - Player 1: " + score1 + ", Player 2: " + score2);
        if (score1 > score2) {
            System.out.println("Player 1 wins!");
        } else if (score2 > score1) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
