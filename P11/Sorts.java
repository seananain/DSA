/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
	    boolean sorted = false;
	    int pass = 0;
	    int temp;
	    do
	    {
		    sorted = true;
		    for(int i=0; i<(A.length -1); i++)
			{
				if(A[i] > A[i+1] == true)
				{
					temp = A[i];
				       	A[i] = A[i+1];
					A[i+1] = temp;
					sorted = false;
				}

			}
		    pass += 1;

	    }while(sorted == false);
    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] A)
    {
	    for(int n = 0; n<(A.length); n++)
	    {
		    int minIdx = n;
		    for(int j = 0; j<(A.length); j++)
		    {
		    	if(A[j] < A[minIdx] == true)
		    	{
				    A[minIdx] = A[j];
		    	}	
		    }
	    
	    	int temp = A[minIdx];
	    	A[minIdx] = A[n];
		A[n] = temp;
	}

    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
	    for(int n=1; n<(A.length); n++)
	    {
		    int i = n;
		    int temp = A[i];
		    while((i>0)&&(A[i-1] > temp))
			{
				A[i] = A[i-1];
				i = i-1;
			}
		A[i] = temp;
			
	    }
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
		mergeSortRecurse(A, 0, A.length-1);
    }//mergeSort()
    private static int[] mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
		int midIdx;
		if(leftIdx < rightIdx)
		{
			midIdx = (leftIdx+rightIdx)/2;
			mergeSortRecurse(A, leftIdx, midIdx);
			mergeSortRecurse(A, midIdx+1, rightIdx);
			merge(A, leftIdx, midIdx, rightIdx);
		}
		else
		{

		}
		return A;
    }//mergeSortRecurse()
    private static int[] merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
		int[] tempArr = new int[rightIdx-leftIdx+1];
		int ii = leftIdx;
		int jj = midIdx +1;
		int kk =0;
		while(ii<=midIdx && jj <= rightIdx)
		{
			if(A[ii]<=A[jj])
			{
				tempArr[kk] = A[ii];
				ii += 1;
			}
			else
			{
				tempArr[kk] = A[jj];
				jj += 1;
			}
			kk += 1;
		}

		for(int i=ii; i<midIdx; i++)
		{
			tempArr[kk] = A[i];
			kk += 1;
		}
		for(int j=jj; j<rightIdx; j++)
		{
			tempArr[kk] = A[j];
			kk += 1;
		}
		for(int k=leftIdx; k<rightIdx; k++)
		{
			A[k] = tempArr[k-leftIdx];
		}
		return A;

    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
		quickSortRecurse(A, 0, A.length-1);
    }//quickSort()
    private static int[] quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
		int pivotIdx;
		int newPivotIdx;
		if(rightIdx>leftIdx)
		{
			pivotIdx = (leftIdx+rightIdx)/2;
			newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);

			quickSortRecurse(A, leftIdx, newPivotIdx-1);
			quickSortRecurse(A, newPivotIdx+1, rightIdx);
		}
		return A;
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
		int currIdx, temp, newPivotIdx;
		int pivotVal = A[pivotIdx];
		A[pivotIdx] = A[rightIdx];
		A[rightIdx] = pivotVal;

		currIdx = leftIdx;
		for(int i=leftIdx;i<rightIdx;i++)
		{
			if(A[i]<pivotVal)
			{
				temp = A[i];
				A[i] = A[currIdx];
				A[currIdx] = temp;
				currIdx += 1;
			}
		}
		newPivotIdx = currIdx;
		A[rightIdx] = A[newPivotIdx];
		A[newPivotIdx] = pivotVal;
		
		return newPivotIdx;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning

	//quicksort random
	public static void quickSortRandom(int[] A)
    {
		quickSortRandomRecurse(A, 0, A.length-1);
    }//quickSort()
    private static int[] quickSortRandomRecurse(int[] A, int leftIdx, int rightIdx)
    {
		int pivotIdx;
		int newPivotIdx;
		if(rightIdx>leftIdx)
		{
			pivotIdx = ThreadLocalRandom.current().nextInt(leftIdx, rightIdx+1);
			newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);

			quickSortRandomRecurse(A, leftIdx, newPivotIdx-1);
			quickSortRandomRecurse(A, newPivotIdx+1, rightIdx);
		}
		return A;
    }//quickSortRecurse()

	//quicksort median
	public static void quickSortMedian(int[] A)
    {
		quickSortRandomRecurse(A, 0, A.length-1);
    }//quickSort()
    private static int[] quickSortMedianRecurse(int[] A, int leftIdx, int rightIdx)
    {
		int pivotIdx;
		int newPivotIdx;
		int midIdx;
		if(rightIdx>leftIdx)
		{
			midIdx = pivotIdx = (leftIdx+rightIdx)/2;
			
			if(A[rightIdx] < A[leftIdx])
			{
				swap(A, leftIdx, rightIdx);
			}
			else if(A[midIdx] < A[leftIdx])
			{
				swap(A, midIdx, leftIdx);
			}
			else if(A[rightIdx] < A[midIdx])
			{
				swap(A, rightIdx, midIdx);
			}
			pivotIdx = midIdx;
			newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);

			quickSortMedianRecurse(A, leftIdx, newPivotIdx-1);
			quickSortMedianRecurse(A, newPivotIdx+1, rightIdx);
		}
		return A;
    }//quickSortRecurse()

	private static void swap(int[] A, int leftIdx, int rightIdx)
	{
		int temp = A[leftIdx];
		A[leftIdx] = A[rightIdx];
		A[rightIdx] = temp;
	}

	//shell sort
	public static void shellSort(int[] A)
	{
		int n = A.length;
		for(int gap = n/2; gap > 0; gap /= 2)
		{
			for(int i=gap;i<n;i++)
			{
				int key  = A[i];
				int j=i;
				while(j>=gap && A[j - gap] > key)
				{
					A[j] = A[j - gap];
					j -= gap;
				}
				A[j] = key;
			}
		}
	}

	//counting sorts
	private static int[] counting(int[] A, int k)
	{
		int[] c = new int[k + 1];
		Arrays.fill(c, 0);

		for (int i : A) {
			c[i] += 1;
		}

		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}
		return c;
	}
	
	public static int[] countingSort(int[] A, int k) {
		int[] c = counting(A, k);
	
		int[] sorted = new int[A.length];
		for (int i = A.length - 1; i >= 0; i--) {
			int current = A[i];
			sorted[c[current] - 1] = current;
			c[current] -= 1;
		}
	
		return sorted;
	}

	//radix sort
	public static void radixSort(int[] A, int k)
	{
		
	}


}//end Sorts calss
