class Shape
{
	Shape()
	{
		System.out.println("It is a shape");
	}
	public double getArea()
	{
		return 0.0;
	}
	public String getName()
	{
		return "";
	}
	
}
class Rectangle extends Shape
{
	private double length;
	private double width;
	private String name;
	public Rectangle()
	{
		super();
	}
	public void rectangle(double length, double width, String name)
	{
		this.length = length;
		this.width = width;
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public double getArea()
	{
		return length * width;
	}
}
class Circle extends Shape
{
	private double pi = 3.14;
	private double radius;
	private String name;
	public Circle()
	{
		super();
	}
	public void circle(double radius, String name)
	{
		this.radius = radius;
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public double getArea()
	{
		return pi*radius*radius;
	}
}
class DemoShape
{
	public static void main(String[] args)
	{
		Rectangle reg = new Rectangle();
		reg.rectangle(10.0,20.0,"Rectangle");
		System.out.println(reg.getName());
		System.out.println(reg.getArea());
		Circle cir = new Circle();
		cir.circle(10.0,"Circle");
		System.out.println(cir.getName());
		System.out.println(cir.getArea());
	}
}

	
