interface OuterInterface
{
	void print1();
	interface InnerInterface
	{
		void print2();
	}
}
class MyClass1 implements OuterInterface
{
	public void print1()
	{
		System.out.println("Welcome");
	}
}
class MyClass2 implements OuterInterface.InnerInterface
{
	public void print2()
	{
		System.out.println("Java");
	}
}
public class Interface
{
	public static void main(String[] args)
	{
		MyClass1 obj1 = new MyClass1();
		obj1.print1();
		MyClass2 obj2 = new MyClass2();
		obj2.print2();
	}
}