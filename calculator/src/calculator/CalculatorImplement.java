package calculator;

import java.math.BigInteger;

public class CalculatorImplement implements Calculator {

	public BigInteger a = new BigInteger("0");
	public BigInteger b = new BigInteger("0");
	@Override
	public BigInteger add(BigInteger a, BigInteger b) {
		// TODO Auto-generated method stub
		return a.add(b);
	}

	@Override
	public BigInteger subtract(BigInteger a, BigInteger b) {
		// TODO Auto-generated method stub
		return a.subtract(b);
	}

	@Override
	public BigInteger multiply(BigInteger a, BigInteger b) {
		// TODO Auto-generated method stub
		return a.multiply(b);
	}

	@Override
	public BigInteger division(BigInteger a, BigInteger b) {
		// TODO Auto-generated method stub
		return a.divide(b);
	}

	@Override
	public BigInteger powerOfTwo(BigInteger a) {
		// TODO Auto-generated method stub
		return a.multiply(a);
	}

	

	


}
