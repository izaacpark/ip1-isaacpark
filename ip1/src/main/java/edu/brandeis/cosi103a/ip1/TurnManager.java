package edu.brandeis.cosi103a.ip1;

public class TurnManager {
    
    public void takeTurn(Player player, Supply supply) {

        // Buy phase
        int availableCrypto = player.getTotalCryptoInHand();

        // Purchase priorty: Framework > Module > Method
        if (availableCrypto >= 8 && supply.isAvailable("Framework")) {
            player.addToDiscard(supply.buyCard("Framework"));

        } else if (availableCrypto >= 5 && supply.isAvailable("Module")) {
            player.addToDiscard(supply.buyCard("Module"));

        } else if (availableCrypto >= 2 && supply.isAvailable("Method")) {
            player.addToDiscard(supply.buyCard("Method"));

        } else if (availableCrypto >= 6 && supply.isAvailable("Dogecoin")) {
            player.addToDiscard(supply.buyCard("Dogecoin"));

        } else if (availableCrypto >= 3 && supply.isAvailable("Ethereum")) {
            player.addToDiscard(supply.buyCard("Ethereum"));
        }

        // Cleanup phase   
        player.discardHand();
        player.draw(5);
    }
}
