package sortingAlgorithm;

public class QuickSortingStart 
{
	public static int partition(int arr[], int left, int right, int pivot) 
	{
		   int leftPointer = left -1;
		   int rightPointer = right;

		   System.out.println("Pivot element is : "+pivot);
		   while(true) {
		      while(arr[++leftPointer] < pivot);
		      
		      while(rightPointer > 0 && arr[--rightPointer] > pivot);

		      if(leftPointer >= rightPointer) {
		         break;
		      } 
		      else 
		      {
		    	 System.out.println(" Left and Right are swapped "+ arr[leftPointer] +" "+arr[rightPointer]);
		         Main.swap(arr,leftPointer,rightPointer);
		         Main.print(arr, arr.length);
		         System.out.println();
		      }
		   }
			
		   System.out.println(" pivot swapped "+ arr[leftPointer] +" "+arr[right]);
		   Main.swap(arr,leftPointer,right);
		   Main.print(arr, arr.length);
	       System.out.println();
		   System.out.println("Updated Array: "); 
		   Main.print(arr, arr.length);
	       System.out.println();
		   return leftPointer;
		}

		void quickSort(int arr[],int left, int right) {
		   if(left<right){
			  Main.swap(arr, right, left);
		      int pivot = arr[right];
		      int partitionPoint = partition(arr,left, right, pivot);
		      quickSort(arr,left,partitionPoint-1);
		      quickSort(arr,partitionPoint+1,right);
		   }        
		}
	
}
