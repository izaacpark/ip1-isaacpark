package edu.brandeis.cosi103a.ip1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testRollDies() {
        // Test that rollDies() generates numbers between 1 and 6
        IntStream.range(0, 100).forEach(i -> {
            int roll = App.rollDies();
            assertTrue(roll >= 1 && roll <= 6, "Roll should be between 1 and 6");
        });
    }

    @Test
    void testDetermineWinner_Player1Wins() {
        // Test when Player 1 wins
        App.determineWinner(10, 5);
        assertTrue(outputStream.toString().contains("Player 1 wins!"));
    }

    @Test
    void testDetermineWinner_Player2Wins() {
        // Test when Player 2 wins
        App.determineWinner(5, 10);
        assertTrue(outputStream.toString().contains("Player 2 wins!"));
    }

    @Test
    void testDetermineWinner_Tie() {
        // Test when it's a tie
        App.determineWinner(10, 10);
        assertTrue(outputStream.toString().contains("It's a tie!"));
    }

    @Test
    void testPlayerTurn() {
        // Mock user input for playerTurn
        String input = "y\nn\n"; // Player chooses to reroll once, then stops
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int roll = App.playerTurn(new java.util.Scanner(System.in), 1);
        assertTrue(roll >= 1 && roll <= 6, "Final roll should be between 1 and 6");
    }
}