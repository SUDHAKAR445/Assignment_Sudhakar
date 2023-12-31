package sortingAlgorithm;

public class CockTailSorting 
{
	public void cocktailSort(int arr[] , int n)
	{
		boolean swap = true;
		int start = 0;
		int end = n;
		int iteration = 1;
		int count = 0;
		while(swap == true)
		{
			swap = false;
			
			for(int i = start; i<end-1; i++)
			{
				if(arr[i]>arr[i+1])
				{
					Main.swap(arr, i, i+1);
					swap = true;
				}
				count++;
			}
			
			if(swap == false)
			{
				break;
			}
			
			swap = false;
			
			end--;
			
			for(int i = end - 1; i>=start; i--)
			{
				if(arr[i]>arr[i+1])
				{
					Main.swap(arr, i, i+1);
					swap = true;
				}
				count++;
			}
			
			start++;
			
			System.out.println("Iteration : "+ iteration++);
			Main.print(arr,n);
		}
		System.out.println("Iterartion count:"+count+"\n");
	}
}
