/**
 * @author Tomas Vermil�
 */

package pokerapp;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards;
	
	public Hand() {
		this.cards = new ArrayList<>();
	}

	public Hand(Deck deck) {
		this.cards = deck.deal();
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public int numberOfCards() {
		return this.cards.size();
	}

	public void printCards() {
		this.cards.forEach(System.out::println);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cards: ");

		// append cards
		this.cards.forEach(card -> sb.append(card).append(", "));

		// remove comma and space at the end
		sb.replace(sb.length() - 2, sb.length(), "");

		// append checks
		sb.append("\nHand contains a two pair: ").append(this.hasTwoPair());
		sb.append("\nHand contains a straigth: ").append(this.isStraight());
		sb.append("\nHand contains a flush: ").append(this.isFlush());
		sb.append("\nHand contains a straight flush: ").append(this.isStraightFlush());

		return sb.toString();
	}

	public boolean hasTwoPair() {
		if (this.cards.isEmpty())
			return false;

		int pairs = 0;
		for (int i = 0; i < this.numberOfCards() - 1; i++) {

			Value first = this.cards.get(i).getValue();

			for (int j = i + 1; j < this.numberOfCards(); j++) {
				Value second = this.cards.get(j).getValue();
				if (first == second)
					pairs++;
			}
		}

		// check if two pair was found
		if (pairs == 2) {
			return true;
		}

		return false;
	}

	public boolean isFlush() {
		if (this.cards.isEmpty())
			return false;

		// Pick the first card and check the rest are same suit
		Suit first = this.cards.get(0).getSuit();
		for (int i = 1; i < this.numberOfCards(); i++) {
			if (this.cards.get(i).getSuit().compareTo(first) != 0)
				return false;
		}

		return true;
	}

	public boolean containsAce() {
		for (Card c : this.cards) {
			if (c.getValue().compareTo(Value.ACE) == 0)
				return true;
		}
		return false;
	}

	public void sortByValue() {
		this.cards.sort((a, b) -> a.getValue().compareTo(b.getValue()));
	}

	public boolean isStraight() {
		if (this.cards.isEmpty())
			return false;

		// Sort the deck by value
		this.sortByValue();

		// If hand contains an ace, check if it is lower end straight
		if (this.containsAce() && this.cards.get(0).getValue().equals(Value.TWO)
				&& this.cards.get(1).getValue().equals(Value.THREE) && this.cards.get(2).getValue().equals(Value.FOUR)
				&& this.cards.get(3).getValue().equals(Value.FIVE)) {
			return true;
		}

		// Check whether hand contains a straight
		for (int i = 0; i < this.numberOfCards() - 1; i++) {
			Value a = this.cards.get(i).getValue();
			Value b = this.cards.get(i + 1).getValue();
			if (a.ordinal() - b.ordinal() != 1)
				return false;

		}
		return true;
	}

	public boolean isStraightFlush() {
		return this.isFlush() && this.isStraight();
	}

}
