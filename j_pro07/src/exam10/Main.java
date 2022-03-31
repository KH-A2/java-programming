package exam10;

public class Main {

	public static void main(String[] args) {
		Operator op = new Calculator();
		
		System.out.println(op.add(4, 2));
		System.out.println(op.sub(4, 2));
		System.out.println(op.mul(4, 2));
		System.out.println(op.div(4, 2));
	}

}
