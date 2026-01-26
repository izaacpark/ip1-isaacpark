package edu.brandeis.cosi103a.ip1;

import java.util.HashMap;
import java.util.Map;

public class Supply {
    
    private final Map<String, Integer> cardCounts = new HashMap<>();

    public Supply() {
       
        // Automation cards
        cardCounts.put("Method", 14);
        cardCounts.put("Module", 8);
        cardCounts.put("Framework", 8);

        // Crypto cards
        cardCounts.put("Bitcoin", 60);
        cardCounts.put("Ethereum", 40);
        cardCounts.put("Dogecoin", 30);
    }

    // Check whether a card is available in the supply
    public boolean isAvailable(String cardName) {
        return cardCounts.getOrDefault(cardName, 0) > 0;
    }

    public Card buyCard(String cardName) {
        if (!isAvailable(cardName)) {
            return null;
        }

        cardCounts.put(cardName, cardCounts.get(cardName) - 1);

        return createCard(cardName);
    }

    // Returns true if all Framework cards have been purchased
    public boolean isFrameworkDepleted() {
        return cardCounts.getOrDefault("Framework", 0) == 0;
    }

    // Internal helper to create Card with correct properties
    private Card createCard(String cardName) {
        switch(cardName) {
            case "Method":
                return new Card("Method", CardType.AUTOMATION, 2, 1);
            case "Module":
                return new Card("Module", CardType.AUTOMATION, 5, 3);
            case "Framework":
                return new Card("Framework", CardType.AUTOMATION, 8, 6);
            case "Bitcoin":
                return new Card("Bitcoin", CardType.CRYPTO, 0, 1);
            case "Ethereum":
                return new Card("Ethereum", CardType.CRYPTO, 3, 2);
            case "Dogecoin":
                return new Card("Dogecoin", CardType.CRYPTO, 6, 3);
            default:
                throw new IllegalArgumentException("Unknown card name: " + cardName);
        }
    }
 
}
