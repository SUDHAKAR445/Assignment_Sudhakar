package sortingAlgorithm;

public class QuickSorting {
	static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } 
	public static int partitionArray(int arr[], int left, int right)
	{
		int pivot = arr[right];
		int i = (left - 1);
		
		for(int j = left ; j<=right; j++)
		{
			if(arr[j]<pivot)
			{
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, right);
		return (i+1);
	}
	public void quickSort(int arr[], int left, int right)
	{
		if(left<right)
		{
			int pivot = partitionArray(arr, left, right);
			
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot+1, right);
		}
	}
	
}
