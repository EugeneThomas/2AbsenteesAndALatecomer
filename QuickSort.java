/*****************************************************
 * Joanna Zhou
 * APCS2 pd4
 * HW15 -- So So Quick
 * 2017-03-09
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): Picks the first number as a pvtPos, runs a partition with the
 * whole range. Then it runs partition again on the two ranges that the last
 * pvtPos separated, until the range shrinks to one. If there is only one
 * element left in range, then the range is sorted.
 *
 * 2a. Worst pivot choice / array state and associated runtime: 
 * A pvtPos that ends up on the edge of a range. Shrinks the range by 1 each
 * run. O(N^2).
 *
 * 2b. Best pivot choice / array state and associated runtime:
 * Splits the whole thing in two. Are the partition calls run simultaneously?
 * If so, O(nLog(n)).
 *
 * 3. Approach to handling duplicate values in array:
 * Irrelevant. Did partition get things in a decent order? Yes, it would.
 * That will do. This is like binary sort but terrible. Mergesort, right.
 *****************************************************/

/***
    PROTIP: Assume no duplicates during initial development phase.
    Once you have a working implementation, test against arrays 
    with duplicate values, and revise if necessary. (Backup first.)
 ***/

public class QuickSort 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d ) { 
	helpSort(d, 0, d.length - 1);
    }

    // Thinkers are encouraged to roll their own subroutines.
    // Insert your auxiliary helper methods here.
    public static int partition( int arr[], int left, int right, int pvtPos){
	int v = arr[pvtPos];

	swap( pvtPos, right, arr);
	int s = left;

	for( int i = left; i < right; i++ ) {
	    if ( arr[i] <= v) {
		swap( i, s, arr );
		s++;}
	}
	swap(s,right,arr);

	return s;
    }//end mysterion

    public static void helpSort(int[] arr, int left, int right) {
	if (left == right) {
	}
	else {
	    int s = partition(arr, left, right, (left + right) / 2); 
	    //printArr(arr);
	    if (s > left) {
		helpSort(arr, left, s - 1);
	    }
	    if (s < right) {
		helpSort(arr, s + 1, right);
	    }
	}
    }

    //main method for testing
    public static void main( String[] args ) 
    {

	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/



	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);

	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort
