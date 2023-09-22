package sortingAlgorithm;

public class QuickSortingMiddle 
{
	static void quickSort(int arr[],int left,int right)
	{ 
	int start=left;
	int end=right;
	int pivot=(right+left)/2;
	while(start<=end)
	{
	    while(arr[start]<arr[pivot]&&start<=right)
	    start++;
	    while(arr[end]>arr[pivot]&&end>0)
	    end--;
	    if(start<=end)
	    {
	        Main.swap(arr, start, end);
	        start++;
	        end--;
	    }
	}
	if(left<start-1)
		quickSort(arr,left,start-1);
	if(start<right)
		quickSort(arr,start,right);
	}
}
