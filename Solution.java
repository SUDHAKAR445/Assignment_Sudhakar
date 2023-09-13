import java.util.*;

class Solution {
    public static int characterReplacement(String s, int k) {
        char arr[] = s.toCharArray();

        int left = 0;
        int right = 0;
        int len = arr.length;

        Map<Character,Integer> map = new HashMap<>();
        int maxLen = 0;
        int mostFreq = 0;

        while(right<len)
        {
            map.put(arr[right],map.getOrDefault(arr[right],0)+1);
            mostFreq = Math.max(mostFreq, map.get(arr[right]));

            if((right - left + 1) - mostFreq > k)
            {
                map.put(arr[left], map.get(arr[left])-1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int k = sc.nextInt();
		System.out.println(characterReplacement(str,k));
	}
}