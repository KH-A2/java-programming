package game.player;

import java.util.Random;

import game.card.Bawi;
import game.card.Bo;
import game.card.Gawi;
import game.card.Hand;

public class UserPlayer implements Player {
	
	Random rd = new Random(12345);
	
	@Override
	public Hand randomCardHand() {
		Hand card = null;
		int rand = rd.nextInt(3);
		switch(rand) {
			case 0:
				card = new Gawi(); break;
			case 1:
				card = new Bawi(); break;
			case 2:
				card = new Bo(); break;
		}
		return card;
	}

	@Override
	public int versus(Hand h1, Hand h2) {
		return h1.compare(h2);
	}

}
