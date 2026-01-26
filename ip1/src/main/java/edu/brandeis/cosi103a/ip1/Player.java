package edu.brandeis.cosi103a.ip1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    
    private final List<Card> drawPile = new ArrayList<>();
    private final List<Card> hand = new ArrayList<>();
    private final List<Card> discardPile = new ArrayList<>();

    public void addToDiscard(Card card) {
        discardPile.add(card);
    }

    private void reshuffleDiscardIntoDraw() {
        if (discardPile.isEmpty()) {
            return;
        }
        
        drawPile.addAll(discardPile);
        discardPile.clear();
        Collections.shuffle(drawPile);
    }

    public void draw(int n) {
        for (int i = 0; i < n; i++) {
            if (drawPile.isEmpty()) {
                reshuffleDiscardIntoDraw();
            }
            if (drawPile.isEmpty()) {
                return; // No more cards to draw
            }
            hand.add(drawPile.remove(0));
        }
    }

    public void discardHand() {
        discardPile.addAll(hand);
        hand.clear();
    }

    public int getTotalCryptoInHand() {
        int total = 0;
        for (Card card : hand) {
            if (card.getType() == CardType.CRYPTO) {
                total += card.getValue();
            }
        }
        return total;
    }

    public int getTotalAutomationPoints() {
        int total = 0;
        for (Card card : getAllCards()) {
            if (card.getType() == CardType.AUTOMATION) {
                total += card.getValue();
            }
        }
        return total;
    }

    public List<Card> getHand() {
        return new ArrayList<>(hand);
    }

    private List<Card> getAllCards() {
        List<Card> allCards = new ArrayList<>();
        allCards.addAll(drawPile);
        allCards.addAll(hand);
        allCards.addAll(discardPile);
        return allCards;
    }
}
