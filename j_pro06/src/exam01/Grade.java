package exam01;

public class Grade {
	private String name;
	private double score;
	private char rank;
	private final static char[] RANK = new char[] {
			'F', 'F', 'F', 'F', 'E', 'E', 'D', 'C', 'B', 'A', 'A'
	};

	public Grade(String name) {
		this.name = name;
	}

	public Grade(String name, double score) {
		this.name = name;
		this.setScore(score);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		if(score <= 100 && score >= 0) {
			this.score = score;
		} else {
			this.score = 0;
		}
		this._setRank();
	}

	public char getRank() {
		return rank;
	}
	
	private void _setRank() {
		/*
		 * 점수가 설정되면 여기에 등급을 분류하기 위한 코드를 작성
		 * A: 100 이하 ~ 90 이상, B: 90 미만 ~ 80 이상, C: 80 미만 ~ 70이상
		 * D: 70 미만 60 이상, E: 60 미만 ~ 40 이상, F: 40 미만
		 */
		this.rank = Grade.RANK[(int)(this.score / 10)];
	}
	
	
}
