class Student
{
	Student()
	{
		System.out.println("Hello");
	}
	interface info
	{
		void department();	
	}
}
class Student1 implements Student.info
{
	public void department()
	{
		System.out.println("Computer Science and Engineering");
	}
}

class InterfaceWithinClass
{
	public static void main(String[] args)
	{
		Student s = new Student();
		Student1 s1 = new Student1();
		s1.department();
	}
}
		