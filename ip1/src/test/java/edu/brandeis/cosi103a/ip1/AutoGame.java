package edu.brandeis.cosi103a.ip1;

public class AutoGame {
    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("  Automation: The Game (IP2)");
        System.out.println("=================================\n");

        // Create and run the game
        Game game = new Game();

        System.out.println("Setting up game...");
        game.setupGame();

        System.out.println("Running game...\n");
        game.runGame();

        System.out.println("\n=================================");
        System.out.println(" Game execution complete");
        System.out.println("=================================");
    }
}
