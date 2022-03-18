package exam09;

public class Rectangle {
	public double area(double width) {
		return width * width;
	}
	
	public double area(double width, double height) {
		return width * height;
	}
	
	public double round(double width, double height) {
		double result;
		result = (width + height) * 2;
		return result;
	}
}
