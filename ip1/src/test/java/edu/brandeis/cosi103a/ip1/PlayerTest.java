package edu.brandeis.cosi103a.ip1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    
    @Test
    public void testDrawAndDiscard() {
        Player player = new Player();

        for (int i = 0; i < 5; i++) {
            player.addToDiscard(new Card("Bitcoin", CardType.CRYPTO, 0, 1));
        }

        player.draw(5);

        assertEquals(5, player.getHand().size());

        player.discardHand();
        assertEquals(0, player.getHand().size());
    }

    @Test
    public void testCryptoCalculation() {
        Player player = new Player();

        player.addToDiscard(new Card("Bitcoin", CardType.CRYPTO, 0, 1));
        player.addToDiscard(new Card("Ethereum", CardType.CRYPTO, 3, 2));
        player.addToDiscard(new Card("Method", CardType.AUTOMATION, 2, 1));

        player.draw(3);

        assertEquals(3, player.getTotalCryptoInHand());
    }
}
