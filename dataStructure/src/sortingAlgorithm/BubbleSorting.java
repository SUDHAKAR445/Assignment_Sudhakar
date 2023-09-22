package sortingAlgorithm;
public class BubbleSorting 
{
	public  void bubbleSort(int arr[], int n)
	{
		int iteration = 1;
		int count =0;
		for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					Main.swap(arr,j,j+1);
				}
				count++;
				System.out.println("Interation "+(iteration++));
				Main.print(arr,n);
			}
		}
		System.out.println("Iteration Count : "+count +"\n");
	}
}
