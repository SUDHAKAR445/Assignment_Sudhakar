package overloadingAndOverriding;
public class OverloadingAndOverriding 
{
	public static void main(String[] args)
	{
		Overloading overloading = new Overloading();
		Overloading overloading1 = new Overloading(10 , 20);
		Overloading overloading2 = new Overloading(10f , 20f);
		OverridingChild child = new OverridingChild();
		child.Overriding();
	}
}
