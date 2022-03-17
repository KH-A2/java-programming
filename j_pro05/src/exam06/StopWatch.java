package exam06;

public class StopWatch {
	/*
	 * +------------------+
	 * | exam06.StopWatch |
	 * +------------------+
	 * | - hour:int       |
	 * | - minute:int     |
	 * | - second:int     |
	 * +------------------+
	 * | + start():void   |
	 * | + stop():void    |
	 * | + pause():void   |
	 * | + reset():void   |
	 * +------------------+
	 */
	private int hour;
	private int minute;
	private int second;
	
	public void setHour(int h) {	// setter
		hour = h;
	}
	
	public int getHour() {		// getter
		return hour;
	}
	
	public void start() {}
	public void stop() {}
	public void pause() {}
	public void reset() {}
	
}
