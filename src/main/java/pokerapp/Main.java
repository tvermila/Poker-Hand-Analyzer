package pokerapp;

public class Main {
	
	public static void main(String[] args) {
		
		// Create new deck
		Deck deck = new Deck();
		
		// Create three hands
		Hand firstHand = new Hand(deck);
		Hand secondHand = new Hand(deck);
		Hand thirdHand = new Hand(deck);
		
		firstHand.dealFlush();
		System.out.println(firstHand);
		System.out.println();
		
		System.out.println(secondHand);
		System.out.println();
		
		System.out.println(thirdHand);

		
	}

}
