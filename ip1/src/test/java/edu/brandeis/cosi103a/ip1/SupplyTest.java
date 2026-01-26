package edu.brandeis.cosi103a.ip1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SupplyTest {
    
    @Test
    public void testSupplyAvailablityAndPurchases() {
        Supply supply = new Supply();

        assertTrue(supply.isAvailable("Framework"));

        Card card = supply.buyCard("Framework");
        assertNotNull(card);
        assertEquals("Framework", card.getName());
    }

    @Test
    public void testFrameworkDepletion(){
        Supply supply = new Supply();

        for (int i = 0; i < 8; i++) {
            supply.buyCard("Framework");
        }

        assertTrue(supply.isFrameworkDepleted());
        assertFalse(supply.isAvailable("Framework"));
    }
}
