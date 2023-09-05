package overloadingAndOverriding;

public class Overloading {
	int variable1,variable2;
	float var1,var2;
	
	//constructor overloading
	public Overloading()
	{
		System.out.println("Constuctor Overloading");
	}
	public Overloading(int variable1, int variable2)
	{
		this.variable1 = variable1;
		this.variable2 = variable2;
		System.out.println("Constuctor Overloading 1");
	}
	public Overloading(float var1, float var2)
	{
		this.var1 = var1;
		this.var2 = var2;
		System.out.println("Constuctor Overloading 2");
	}
}
