package pokerapp;

public class Card {	
	private Suit suit;
	private Value value;
	
	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}

	public Suit getSuit() {
		return suit;
	}

	public Value getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return this.value + " of " + this.suit;
	}	

}
