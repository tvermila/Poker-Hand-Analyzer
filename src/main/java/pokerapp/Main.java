/**
 * @author Tomas Vermil�
 */

package pokerapp;

public class Main {

	public static void main(String[] args) {

		// Create new deck
		Deck deck = new Deck();

		// Create three hands and print
		for (int i = 0; i < 3; i++) {
			System.out.println(new Hand(deck));
			System.out.println();
		}
	}

}
