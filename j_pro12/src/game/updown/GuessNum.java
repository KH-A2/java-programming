package game.updown;

import java.util.Random;

public class GuessNum {
	
	private Random rand = new Random();
	private int guess;
	private int guessLimit;
	
	public GuessNum() {
		this.guess = rand.nextInt(100) + 1;
		this.guessLimit = 10;
	}
	
	public GuessNum(int rangeMax, int limit) {
		this.guess = rand.nextInt(rangeMax) + 1;
		this.guessLimit = limit;
	}
	
	public GuessNum(int rangeMin, int rangeMax, int limit) {
		this.guess = rand.nextInt(rangeMax - rangeMin) + rangeMin;
		this.guessLimit = limit;
	}
	
	public Result guessing(int number) {
		Result res = new Fail();
		this.guessLimit--;
		if(remainCount()) {
			if(number > this.guess) {
				res = new DOWN();
			} else if(number < this.guess) {
				res = new UP();
			} else if(number == this.guess) {
				res = new Correct();
			}
		} else if(this.guessLimit == 0) {
			if(number == this.guess) {
				res = new Correct();
			}
		}
		return res;
	}
	
	public boolean remainCount() {
		return this.guessLimit > 0 ? true : false;
	}
}
