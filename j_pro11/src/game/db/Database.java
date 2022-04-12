package game.db;

import java.io.File;

public class Database {

	private File file;
	
	public Database() {
		this.file = new File("C:/Users/user1/gbo_game.record");
	}
	
	public Database(File file) {
		this.file = file;
	}
	
	public int[] load() {
		// 데이터 불러오기
		return null;
	}
	
	public void save(int[] record) {
		// 데이터 저장하기
	}
}
