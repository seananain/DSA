/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
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
    }//mergeSort()
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
		return 0;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning


}//end Sorts calss
