# 2AbsenteesAndALatecomer

<b> Q U I C K S O R T </b> 

<b>  ALGORITHM </b>  

QSort(arr): Picks the first number as a pvtPos, runs a partition with the whole range. Then it runs partition again on the two ranges that the last pvtPos separated, until the range shrinks to one. If there is only one element left in range, then the range is sorted.

<b> Big O Time Classification (best case, worst case, general runtime): </b> 
 
The worst pivot choice/array state combination would be a situation where you run partition with your pivot being your last element in the array, only to find that it yields either the largest or smallest value, splitting it into one array of length (arr-length - 1). Due to a linear runtime on the partition method, and the splitting of arrays then taking n-1 step, this runtime is n^2. 
 
The ideal pivot choice/array state combination would be a situation in which each of the values of any array or sub-array would yield a near-midpoint. This runtime would most likely be a logarithmic runtime with a linear time method within it. Thus, it is nlongn. 

Because 

<b> Time Experiment / Analysis: </b> 

  The following are the three test positions for the pivot value, followed by the amount of nano seconds each run took (# of elements in   array: # of nano seconds).  
  
   Left pvtPos: <br>
   
   1: 136 <br> 
   10: 4798 <br> 
   100: 19004 <br>
   1000: 112113 <br>
   10000: 855624 <br>
   100000: 9925553 <br>
   1000000: 39791567 <br>

   Middle pvtPos: <br>

   1: 85 <br> 
   10: 3694 <br>
   100: 24641  <br>
   1000: 156949 <br>
   10000: 1008169 <br>
   100000: 10207275 <br>
   1000000: 32990874 <br> 

   Right pvtPos: <br> 

   1: 196 <br>
   10: 5952 <br>
   100: 23418 <br>
   1000: 141408 <br>
   10000: 1067861 <br>
   100000: 11274443 <br> 
   1000000: 34271724 <br>
   
   This allows us to believe that the growth resembles something between a linear and quadratic growth, therefore aroung nlogn. 

HOW DOES PIVOT POSITION INFLUNCE THE RUNTIME. 

Albeit slight, the data show that the middle pivot value is the best-case scenario while the sides can yield the worst-case scenario. 

