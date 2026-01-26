package edu.brandeis.cosi103a.ip1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TurnManagerTest {
    
    @Test
    public void testTurnBuysCard() {
        Supply supply = new Supply();
        Player player = new Player();
        TurnManager turnManager = new TurnManager();

        for (int i = 0; i < 5; i++) {
            player.addToDiscard(new Card("Bitcoin", CardType.CRYPTO, 0, 1));
        }

        player.draw(5);

        turnManager.takeTurn(player, supply);

        assertFalse(supply.isAvailable("Method") && supply.isAvailable("Method") == false);
    }
}
