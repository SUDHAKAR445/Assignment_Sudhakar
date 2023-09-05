package overloadingAndOverriding;
class Overriding {
	Overriding()
	{
		System.out.println("Constructor overriding");
	}
}
class OverridingChild extends Overriding
{
	void Overriding()
	{
		System.out.println("Constructor overriding by child");
	}
}
