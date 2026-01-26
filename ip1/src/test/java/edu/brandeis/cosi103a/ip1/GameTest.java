package edu.brandeis.cosi103a.ip1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameTest {
    
    @Test
    public void testGameRunsToCompletion() {
        Game game = new Game(); 
        
        assertDoesNotThrow(() -> {
            game.setupGame();
            game.runGame();
        });
    }
}
