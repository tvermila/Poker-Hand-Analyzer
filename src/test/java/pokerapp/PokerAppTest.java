package pokerapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PokerAppTest {
	private ArrayList<Card> cards;
	private Hand testHand;
	private ArrayList<Card> falseCards;
	private Hand falseHand;
	
	// initialize falseHand
	{
		falseHand = new Hand();
		falseCards = new ArrayList<Card>();
		falseCards.add(new Card(Suit.CLUBS, Value.ACE));
		falseCards.add(new Card(Suit.CLUBS, Value.FOUR));
		falseCards.add(new Card(Suit.HEARTS, Value.SIX));
		falseCards.add(new Card(Suit.SPADES, Value.NINE));
		falseCards.add(new Card(Suit.DIAMONDS, Value.JACK));
		falseHand.setCards(falseCards);
	}
	
	@BeforeEach
	void init() {
		testHand = new Hand();
		cards = new ArrayList<>();
	}
	
	@Nested
	@DisplayName("Testing hasTwoPair method")
	class TwoPairTests {
		
		@Test
		@DisplayName("Testing hasTwoPair method returns true")
		void testHasTwoPair() {		
			cards.add(new Card(Suit.CLUBS, Value.ACE));
			cards.add(new Card(Suit.CLUBS, Value.FOUR));
			cards.add(new Card(Suit.HEARTS, Value.ACE));
			cards.add(new Card(Suit.SPADES, Value.THREE));
			cards.add(new Card(Suit.DIAMONDS, Value.FOUR));
			testHand.setCards(cards);		
			assertTrue(testHand.hasTwoPair(), "Should have returned true.");
		}
		
		@Test
		@DisplayName("Testing hasTwoPair method returns false")
		void testIsNotTwoPair() {
			assertFalse(falseHand.hasTwoPair(), "Should have returned false.");
		}
		
	}
	
	@Nested
	@DisplayName("Testing isStraight method")
	class IsStraightTests {
		
		@Test
		@DisplayName("Testing isStraight method returns true")
		void testIsStraight() {
			cards.add(new Card(Suit.CLUBS, Value.ACE));
			cards.add(new Card(Suit.CLUBS, Value.TWO));
			cards.add(new Card(Suit.CLUBS, Value.THREE));
			cards.add(new Card(Suit.CLUBS, Value.FOUR));
			cards.add(new Card(Suit.SPADES, Value.FIVE));
			testHand.setCards(cards);		
			assertTrue(testHand.isStraight(), "Should have returned true.");		
		}
		
		@Test
		@DisplayName("Testing isStraight method returns false")
		void testIsNotStraight() {
			assertFalse(falseHand.isStraight(), "Should have returned false.");
		}
		
	}
	
	@Nested
	@DisplayName("Testing isFlush method")
	class IsFlushTests {
		
		@Test
		@DisplayName("Testing isFlush method returns true")
		void testIsFlush() {
			cards.add(new Card(Suit.CLUBS, Value.ACE));
			cards.add(new Card(Suit.CLUBS, Value.EIGHT));
			cards.add(new Card(Suit.CLUBS, Value.TEN));
			cards.add(new Card(Suit.CLUBS, Value.JACK));
			cards.add(new Card(Suit.CLUBS, Value.KING));
			testHand.setCards(cards);		
			assertTrue(testHand.isFlush(), "Should have returned true.");
		}
		
		@Test
		@DisplayName("Testing isFlush method returns false")
		void testIsNotStraight() {
			assertFalse(falseHand.isFlush(), "Should have returned false.");
		}		
	}	

}
