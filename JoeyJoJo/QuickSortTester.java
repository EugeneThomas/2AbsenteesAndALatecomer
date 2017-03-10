/* DO YOU REALIZE HOW MUCH POWER I HAVE IT IS 1 IN THE MORNING AND NO ONE
   NO ONE
   IS UP.
   Left pvtPos:
   10: 6302
   100: 85413
   1000: 200190
   10000: 1147091
   Middle pvtPos:
   10: 7013
   100: 65799
   1000: 192094
   10000: 1159214
   Right pvtPos:
   10: 6157
   100: 84443
   1000: 268840
   10000: 1181074
 */
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
	for (int i = 0; i < 10; i += 1) {
	    retInt += testTest(vol);
	}
	return (retInt / 10);
    }
    public static void main(String[] args) {
	System.out.println(averTest(10));
	System.out.println(averTest(100));
	System.out.println(averTest(1000));
	System.out.println(averTest(10000));
    }
}
