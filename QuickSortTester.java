/* ==============================================

                A L G O R I T H M
		*****************

   Slightly altering the sorthelper function, the 
   method averTest is run on the parameters 1, 10, 
   100, 1000, up to 1000000. averTest itself runs by 
   carrying out the quickSort method fifty times at 
   once. Then, you take the average of the time of 
   these fifty runs and returns that value. 

             C A L C U L A T I O N S 
	     ***********************

   Left pvtPos:

   1: 136
   10: 4798
   100: 19004
   1000: 112113
   10000: 855624
   100000: 9925553
   1000000: 39791567

   Middle pvtPos:

   1: 85
   10: 3694
   100: 24641
   1000: 156949
   10000: 1008169
   100000: 10207275
   1000000: 32990874

   Right pvtPos:

   1: 196
   10: 5952
   100: 23418
   1000: 141408
   10000: 1067861
   100000: 11274443
   1000000: 34271724

 ================================================*/

public class QuickSortTester {
    public static int[] ranArr(int vol) {
	// arrays of randomly generated ints
	int[] arrMatey = new int[vol];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( (vol * 2.4) * Math.random() );
	return arrMatey;
    }
    public static long testTest(int vol){
	int[] arrg = ranArr(vol);
	long s = System.nanoTime();
	QuickSort.qsort(arrg);
	s = System.nanoTime() - s;
	return s;
    }
    public static long averTest(int vol){
	testTest(vol);
	int retInt = 0;
	for (int i = 0; i < 50; i += 1) {
	    retInt += testTest(vol);
	}
	return (retInt / 50);
    }
    public static void main(String[] args) {
	System.out.println(averTest(1));	
	System.out.println(averTest(10));
	System.out.println(averTest(100));
	System.out.println(averTest(1000));
	System.out.println(averTest(10000));
	System.out.println(averTest(100000));
	System.out.println(averTest(1000000));
    }
}
