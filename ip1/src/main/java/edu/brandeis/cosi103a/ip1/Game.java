package edu.brandeis.cosi103a.ip1;

import java.util.Random;

public class Game {
    private final Supply supply;
    private final Player player1;
    private final Player player2;
    private final TurnManager turnManager;

    public Game() {
        this.supply = new Supply();
        this.player1 = new Player();
        this.player2 = new Player();
        this.turnManager = new TurnManager();
    }

    public void setupGame() {
        setupPlayer(player1);
        setupPlayer(player2);

        player1.draw(5);
        player2.draw(5);

    }

    private void setupPlayer(Player player) {
        for (int i = 0; i < 7; i++) {
            player.addToDiscard(supply.buyCard("Bitcoin"));
        }
        for (int i = 0; i < 3; i++) {
            player.addToDiscard(supply.buyCard("Method"));
        }
        player.draw(0);
    }

    public void runGame() {
        Player current = chooseStartingPlayer();
        Player other = (current == player1) ? player2 : player1;

        while (!supply.isFrameworkDepleted()) {
            turnManager.takeTurn(current, supply);

            // Swap players
            Player temp = current;
            current = other;
            other = temp;
        }

        endGame();
    }

    private Player chooseStartingPlayer() {
        Random rand = new Random();
        return rand.nextBoolean() ? player1 : player2;
    }

    private void endGame() {
        int player1Points = player1.getTotalAutomationPoints();
        int player2Points = player2.getTotalAutomationPoints();

        System.out.println("Game Over!");
        System.out.println("Player 1 Automation Points: " + player1Points);
        System.out.println("Player 2 Automation Points: " + player2Points);

        if (player1Points > player2Points) {
            System.out.println("Player 1 wins!");
        } else if (player2Points > player1Points) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setupGame();
        game.runGame();
    } 
}
