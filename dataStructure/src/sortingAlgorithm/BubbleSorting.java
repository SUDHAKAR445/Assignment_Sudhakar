package sortingAlgorithm;
public class BubbleSorting 
{
	public  void bubbleSort(int arr[], int n)
	{
		int iteration = 1;
		for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				System.out.println("Interation "+(iteration++));
				Main.print(arr,n);
			}
		}
	}
}