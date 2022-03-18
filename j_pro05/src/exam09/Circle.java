package exam09;

public class Circle {
	private double radius;
	private double area;
	private double round;
	
	public final static double PI = 3.14;
	
	public Circle() {}
	
	public Circle(double radius) {
		setRadius(radius);
	}
	
	// setter
	public void setRadius(double radius) {
		this.radius = radius;
		_area();
		_round();
	}
	
	// getter
	public double getRadius() {
		return radius;
	}
	
	// getter
	public double getArea() {
		return area;
	}
	
	// getter
	public double getRound() {
		return round;
	}
	
	private void _area() {
		this.area = radius * radius * PI;
	}
	
	// 원 둘레 -> 2πr
	private void _round() {
		this.round = 2 * PI * radius;
	}
}
