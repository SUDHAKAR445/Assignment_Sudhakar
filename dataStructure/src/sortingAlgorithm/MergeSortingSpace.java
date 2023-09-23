package sortingAlgorithm;

public class MergeSortingSpace 
{
	public static void merge(int arr[], int left, int mid, int right)
	{
		int start = mid + 1;
		
		if(arr[mid] <= arr[start])
		{
			return;
		}
		
		while(left <= mid && start <= right)
		{
			if(arr[left] <= arr[start])
			{
				left++;
			}
			else
			{
				int value = arr[start];
				int index = start;
				
				while(index != left)
				{
					arr[index] = arr[index-1];
					index--;
				}
				arr[left] = value;
				left++;
				mid++;
				start++;
			}
		}
	}
	public void mergeSortSpace(int arr[], int left,int right)
	{
		if(left<right)
		{
			int mid = left + (right - left)/2;
			mergeSortSpace(arr, left, mid);
			mergeSortSpace(arr, mid+1, right);
			
			merge(arr, left, mid, right);
		}
	}
}
