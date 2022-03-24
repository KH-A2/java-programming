package exam01;

import java.util.Random;

public class Lotto {
	private int rangeMin = 1;
	private int rangeMax = 45;
	private int count = 6;
	private int[] numbers;
	private Random rand = new Random();
	
	public Lotto() {
		this.numbers = new int[count];
	}
	
	public Lotto(int min, int max, int count) {
		this.rangeMin = min;
		this.rangeMax = max;
		this.count = count;
		this.numbers = new int[count];
	}

	public int getRangeMin() {
		return rangeMin;
	}

	public void setRangeMin(int rangeMin) {
		this.rangeMin = rangeMin;
	}

	public int getRangeMax() {
		return rangeMax;
	}

	public void setRangeMax(int rangeMax) {
		this.rangeMax = rangeMax;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int[] getNumbers() {
		return numbers;
	}
	
	public void generate(int ... nums) {
		int cnt = nums.length;
		
		for(int i = 0; i < cnt; i++) {
			numbers[i] = nums[i];
		}
		
		for(int i = cnt; i < count;) {
			int num = this.rand.nextInt(rangeMax) + rangeMin;
			if(!_isDuplicate(num)) {
				numbers[i] = num;
				i++;
			}
		}
	}
	
	private boolean _isDuplicate(int number) {
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] == number) {
				return true;
			}
		}
		return false;
	}
	
}
