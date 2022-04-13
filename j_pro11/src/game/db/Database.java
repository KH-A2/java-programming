package game.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Database {

	private File file;
	
	public Database() {
		this.file = new File("C:/Users/user1/gbo_game.record");
	}
	
	public Database(File file) {
		this.file = file;
	}
	
	public int[] load() {
		int[] nArr = new int[3];
		
		if(file.exists()) {
		
			StringBuilder sb = new StringBuilder();
			try (FileReader fr = new FileReader(file)) {
				char[] buffer = new char[4];
				char[] readChars = new char[0];
				
				while(true) {
					int i = fr.read(buffer);
					
					if(i == -1) {
						break;
					}
					
					int endIndex = readChars.length;
					readChars = Arrays.copyOf(readChars, readChars.length + i);
					System.arraycopy(buffer, 0, readChars, endIndex, i);
				}
				
				sb.append(new String(readChars));
				
				StringTokenizer st = new StringTokenizer(sb.toString(), " ");
				nArr = new int[st.countTokens()];
				int i = 0;
				while(st.hasMoreTokens()) {
					String s = st.nextToken();
					nArr[i++] = Integer.parseInt(s);
				}
				
				System.out.println(Arrays.toString(nArr));
				
			} catch (FileNotFoundException e) {
				System.out.println("FileReader 클래스로 읽을 파일을 찾지 못했습니다.");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("파일을 읽는 과정에 문제가 발생하였습니다.");
				e.printStackTrace();
			}
		}
		
		return nArr;
	}
	
	public void save(int[] record) {
		try (FileWriter fw = new FileWriter(file)) {
			
			for(int i = 0; i < record.length; i++) {
				fw.write(Integer.valueOf(record[i]).toString() + " ");
			}
			
			fw.flush();
		} catch (FileNotFoundException e) {
			System.out.println("쓰기 작업을 위한 파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("쓰기 작업 중 문제가 발생하였습니다.");
			e.printStackTrace();
		}
	}
}
