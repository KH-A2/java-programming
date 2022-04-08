package game.player;

import game.card.Hand;

public class UserPlayer implements Player {

	@Override
	public Hand randomCardHand() {
		return null;
	}

	@Override
	public boolean versus(Hand h1, Hand h2) {
		return false;
	}

}
