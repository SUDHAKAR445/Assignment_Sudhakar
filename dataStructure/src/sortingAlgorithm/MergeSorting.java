package sortingAlgorithm;

public class MergeSorting 
{
	public static void mergeArray(int arr[], int left, int mid, int right)
	{
		int length1 = mid - left+1;
		int length2 = right - mid;
		
		int leftArray[] = new int[length1];
		int rightArray[] = new int[length2];
		
		for(int i=0;i<length1; i++)
		{
			leftArray[i] = arr[left+i];
		}
		for(int i=0;i<length2;i++)
		{
			rightArray[i] = arr[mid + 1 + i];
		}
		
		int i = 0, j = 0, k = left;
		
		while(i < length1 && j < length2)
		{
			if(leftArray[i] <= rightArray[j])
			{
				arr[k] = leftArray[i];
				i++;
			}
			else
			{
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}
		while(i<length1)
		{
			arr[k] = leftArray[i];
			i++;
			k++;
		}
		while(j<length2)
		{
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}
	public void mergeSort(int arr[], int left, int right)
	{
		if(left<right)
		{
			int mid = (left + right)/2;
			mergeSort(arr,left,mid);
			mergeSort(arr,mid+1,right);
			
			mergeArray(arr, left, mid, right);
		}
	}
}
