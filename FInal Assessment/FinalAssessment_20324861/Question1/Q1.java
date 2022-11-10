import java.util.*;

public class Q1
{
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

		for(int i=ii; i<=midIdx; i++)
		{
			tempArr[kk] = A[i];
			kk += 1;
		}
		for(int j=jj; j<=rightIdx; j++)
		{
			tempArr[kk] = A[j];
			kk += 1;
		}
		for(int k=leftIdx; k<=rightIdx; k++)
		{
			A[k] = tempArr[k-leftIdx];
		}
		return A;

    }//merge()




    public static void main(String[] args)
    {
        int[] A = {2,0,3,2,4,8,6,1};

        mergeSort(A);
        for(int i=0; i<A.length; i++)
        {
            System.out.println(A[i]);
        }


    }
}