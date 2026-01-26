package edu.brandeis.cosi103a.ip1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CardTest {
    
    @Test
    public void testCardProperties1() {
        Card card = new Card("Bitcoin", CardType.CRYPTO, 0, 1);
        
        assertEquals("Bitcoin", card.getName());
        assertEquals(CardType.CRYPTO, card.getType());
        assertEquals(0, card.getCost());
        assertEquals(1, card.getValue());
    }

    @Test
    public void testCardProperties2() {
        Card card = new Card("Method", CardType.AUTOMATION, 2, 1);
        
        assertEquals("Method", card.getName());
        assertEquals(CardType.AUTOMATION, card.getType());
        assertEquals(2, card.getCost());
        assertEquals(1, card.getValue());
    }
}
