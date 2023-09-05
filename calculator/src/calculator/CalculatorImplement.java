package calculator;

import java.math.BigInteger;

public class CalculatorImplement implements Calculator {

	public BigInteger a = new BigInteger("0");
	public BigInteger b = new BigInteger("0");
	
	
	public BigInteger add(BigInteger a, BigInteger b) 
	{
		return a.add(b);
	}

	public BigInteger subtract(BigInteger a, BigInteger b) 
	{
		return a.subtract(b);
	}

	public BigInteger multiply(BigInteger a, BigInteger b) 
	{
		return a.multiply(b);
	}

	public BigInteger division(BigInteger a, BigInteger b) 
	{
		return a.divide(b);
	}

	public BigInteger powerOfTwo(BigInteger a) 
	{
		return a.multiply(a);
	}

	

	


}
