import java.util.*;
public class FindNumber
{
	public static void main(String[] args)
	{
		final int number = 1000000;

		long sLength = 0;
		long start = 0;
		long s;
		Map<Integer,Integer>mp = new LinkedHashMap<>();
		for (int i = 2; i <= number; i++) {
			int length = 1;
			s = i;
		
			while (s != 1) {
				if(mp.containsKey(s))
				{
					mp.put(i,mp.get(s)+length);
					length = mp.get(i);
					break;
				}
				if ((s % 2) == 0) {
					s = s / 2;
				} else {
					s = s * 3 + 1;
				}
				length++;
			}
			mp.put(i,length);
			System.out.println("Number and count "+ i+" " +length);
			//Check if sequence is the best solution
			if (length > sLength) {
				sLength = length;
				start = i;
			}
			
		}
        System.out.println("Result number and count : " +start+" " + sLength);
	}
}