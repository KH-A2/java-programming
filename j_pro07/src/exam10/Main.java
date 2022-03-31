package exam10;

public class Main {

	public static void main(String[] args) {
		Operator op1 = new Calculator();
		
		System.out.println(op1.add(4, 2));
		System.out.println(op1.sub(4, 2));
		System.out.println(op1.mul(4, 2));
		System.out.println(op1.div(4, 2));
		
		// ======================================
		
		Operator op2 = new EngineerCalc();
		
		System.out.println(op2.add(4, 2));
		System.out.println(op2.sub(4, 2));
		System.out.println(op2.mul(4, 2));
		System.out.println(op2.div(4, 2));
		
		Engineer eng = (Engineer)op2;
		System.out.println(eng.mod(4, 2));
		System.out.println(eng.sqrd(4, 2));
		System.out.println(eng.abs(-4));
		
		// ======================================
		
		Operator op3 = new ProgrammerCalc();
		
		System.out.println(op2.add(4, 2));
		System.out.println(op2.sub(4, 2));
		System.out.println(op2.mul(4, 2));
		System.out.println(op2.div(4, 2));
		
		Programmer pro = (Programmer)op3;
		System.out.println(pro.binary(100));
		System.out.println(pro.octal(100));
		System.out.println(pro.hexa(100));
	}

}
