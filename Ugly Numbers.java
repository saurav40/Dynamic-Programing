//-------------->Ugly numbers are numbers whose only prime factors are 2, 3 or 5. 
/*

  Input  : n = 7
Output : 8

1 2 3 4 5 6| 8


*/


  
  

import java.io.*;

class Solution {
	public static void main (String[] args) {
	   int n=7;
	   int dp[]=new int[n];
   dp[0]=1;
   int i2=0,i3=0,i5=0;
   int next_ug2=dp[i2]*2;
   int next_ug3=dp[i3]*3;
   int next_ug5=dp[i5]*5;
   
   for(int i=1;i<n;i++)
   {
       dp[i]=Math.min(next_ug2,Math.min(next_ug3,next_ug5));
       if(dp[i]==next_ug2)
       {
           i2++;
          next_ug2=dp[i2]*2;
       }
       if(dp[i]==next_ug3)
       {
          i3++;
          next_ug3=dp[i3]*3;
       }
       if(dp[i]==next_ug5)
       {
         i5++;
         next_ug5=dp[i5]*5;
       }
      }
      System.out.println(dp[n-1]);

 }
}
