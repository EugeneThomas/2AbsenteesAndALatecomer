// Eugene Thomas
// APCS2 pd4
// HW14 -- So So Quick 
// 2017-03-08

/*****************************************************
 * class QuickSort
 * 
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm: 
 *
 * QSort(arr): The way the algorithm works is that you first use the partition 
 *             method to place one of the elements in the array in the right 
 *             place, split the rest of the array into two parts (one part where
 *             all of the values are less than the partition and one part where 
 *             all of the values are greater than the partition). This process
 *             is then repeated via recursion until it does not satisfy the base
 *             case (the end value is greater than the start value). Then, the values 
 *             in the array are recombined to create a sorted list. 
 *
 * 2a. Worst pivot choice / array state and associated runtime: 
 *             The worst pivot choice/array state combination would be a situation where you 
 *             run partition with your pivot being your last element in the array, only to 
 *             find that it yields either the largest or smallest value, splitting it into 
 *             one array of length (arr-length - 1). Due to a linear runtime on the partition 
 *             method, and the splitting of arrays then taking n-1 step, this runtime is n^2. 
 * 
 * 2b. Best pivot choice / array state and associated runtime:
 *             The ideal pivot choice/array state combination would be a situation in 
 *             which each of the values at a set index, not dependent on the length of 
 *             the array (so the partition only runs a linear time) of any array or 
 *             sub-array would yield a near-midpoint. This runtime would most likely be logn. 
 *
 * 3. Approach to handling duplicate values in array:
 *             I am not sure if there was more code that needed to be implemented to account for
 *             duplicates because mine worked without adding any additional code other than the algo 
 *             that was given. I think this is because when you are splitting values, they will 
 *             eventually end up next to each other (even if the method does not recognize them as 
 *             unique values). 
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

    // helper method for qsort

    public static void qsorth (int[] arr, int a, int b) { 
 
	if (a < b) { 
	    int pvtpos;
	    pvtpos = partition(arr, a, b, (a+b)/2); 
	    qsorth(arr, a, pvtpos-1); 
	    // arr[pvtpos] = the old arr value at (a+b)/2
	    qsorth(arr,pvtpos+1, b); 
	} 
    } 

    //--------------^  HELPER METHODS  ^--------------


    // a --> lower bound 
    // b --> upper bound
    // c --> pivot 

    public static int partition (int[] arr, int a, int b, int c) { 
	int v = arr[c]; 
	// swap one 
	swap(b,c,arr); 
	int s = a; 
	for (int i = a; i < b; i++) {
	    if (arr[i] < v) { 
		// swap two 
		swap(i,s,arr);  
		s++; 
	    }  
	} 
	// swap three 
	swap(b,s,arr); 
	return s; 
    } // end partition()  

    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/

    public static void qsort( int[] d ) 
    { 
        qsorth(d, 0, d.length-1); 
    }

    // Thinkers are encouraged to roll their own subroutines.
    // Insert your auxiliary helper methods here.

 
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


    }//end main

}//end class QuickSort
