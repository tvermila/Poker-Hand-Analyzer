package pokerapp;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> cards;
	
	public Deck() {
		this.cards = new ArrayList<>();
		this.fillDeck();
		this.shuffleDeck();
	}
	
	private void shuffleDeck() {
		Collections.shuffle(this.cards);
	}
	
	// Create cards into deck
	private void fillDeck() {
		for (int i = 0; i < Suit.values().length; i++) {
			for (int j = 0; j < Value.values().length; j++) {
				this.cards.add(new Card(Suit.values()[i], Value.values()[j]));
			}
		}
	}
	
	// Pick one card from deck
	private Card getCard() {
		Card card = this.cards.get(0);
		this.cards.remove(0);
		return card;
	}
	
	public void printCards() {
		this.cards.forEach(System.out::println);
	}
	
	public int amountOfCards() {
		return this.cards.size();
	}
	
	public ArrayList<Card> getCards() {
		return this.cards;
	}
	
	// Deal five cards
	public ArrayList<Card> deal() {
		ArrayList<Card> dealtCards = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			dealtCards.add(this.getCard());
		}
		
		return dealtCards;
	}

}
