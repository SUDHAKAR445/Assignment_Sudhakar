package tryOut;

class Test1
{
	static class Run
	{
		int a = 0;
		static int b = 0;
		int test()
		{
			this.a++;
			return a;
		}
		int test1()
		{
			b++;
			return b;
		}
	}
}
public class StaticInc {
    public static void main(String args[])
    {
    	Test1.Run s1 = new Test1.Run();
    	System.out.println(s1.test());
    	System.out.println(s1.test());
    	System.out.println(s1.test());
    	System.out.println(s1.test());
    	System.out.println();
    	Test1.Run s2 = new Test1.Run();
    	System.out.println(s2.test());
    	System.out.println(s2.test());
    	System.out.println(s2.test());
    	System.out.println(s2.test());
    	
    	
    	System.out.println("******");
    	Test1.Run s3 = new Test1.Run();
    	System.out.println(s3.test1());
    	System.out.println(s3.test1());
    	System.out.println(s3.test1());
    	System.out.println(s3.test1());
    	System.out.println();
    	Test1.Run s4 = new Test1.Run();
    	System.out.println(s4.test1());
    	System.out.println(s4.test1());
    	System.out.println(s4.test1());
    	System.out.println(s4.test1());
    }
}

