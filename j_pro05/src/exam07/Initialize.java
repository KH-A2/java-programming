package exam07;

public class Initialize {
	public int num1;
	public static String name1;
	
	public int num2 = 10;
	public static String name2 = "java";
	
	public int num3 = 20;
	public static String name3 = "programming";
	
	{
		num3 = num3 + 10;
		name3 = name2 + " " + name3;
	}
	
	static {
		name3 = name2 + " " + name3;
	}
}
