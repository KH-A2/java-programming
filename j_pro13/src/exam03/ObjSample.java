package exam03;

import java.io.Serializable;

public class ObjSample implements Serializable {
	private int num;
	private double point;
	private boolean ys;
	private String name;
	
	public ObjSample(int i, double d, boolean b, String s) {
		num = i;
		point = d;
		ys = b;
		name = s;
	}

	@Override
	public String toString() {
		return "ObjSample [num=" + num + ", point=" + point + ", ys=" + ys + ", name=" + name + "]";
	}
}
