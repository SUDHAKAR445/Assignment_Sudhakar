package calculator;

import java.math.BigInteger;

public interface Calculator {
	public BigInteger add(BigInteger a, BigInteger b);
	public BigInteger subtract(BigInteger a, BigInteger b);
	public BigInteger multiply(BigInteger a, BigInteger b);
	public BigInteger division(BigInteger a, BigInteger b); 
	public BigInteger powerOfTwo(BigInteger a);
}
