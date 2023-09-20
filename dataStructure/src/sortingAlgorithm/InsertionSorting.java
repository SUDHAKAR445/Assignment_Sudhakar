package sortingAlgorithm;

public class InsertionSorting 
{
	public void InsertionSort(int arr[], int n)
	{
		int iteration = 1;
		for(int i=0;i<n;i++)
		{
			int key = arr[i];
			int j = i-1;
			
			while(j>=0 && arr[j]>key)
			{
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
			System.out.println("Interation "+(iteration++));
			Main.print(arr,n);
		}
	}
}
