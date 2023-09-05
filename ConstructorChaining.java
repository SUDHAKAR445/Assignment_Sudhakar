public class ConstructorChaining
{
   // default constructor 
   ConstructorChaining()
   {
        this(123);
           System.out.println("This is default constructor");
   }
  
   // parameterized construction have int type parameter
   ConstructorChaining(int a)
   {
      this("Hello");
      System.out.println("Parameterized constructor");
      System.out.println("It's called form default constructor");
   }
   ConstructorChaining(String a)
   {
       System.out.println("Parameterized constructor"); 
       System.out.println("It's called by default constructor having int type parameter");
   }
  
   public static void main (String arg[])
   { 
       ConstructorChaining n = new ConstructorChaining();
   }
}