package game.card;

public class Gawi extends Hand {

	@Override
	public boolean compare(Hand otherHand) {
		return false;
	}

	@Override
	public Hand cheat(Hand otherHand) {
		return null;
	}

}
