/*
The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

N=4

0 1 1 2 3
0+1+1=2
1+1+2=4
return 4;
*/

class Solution {
    public int tribonacci(int n) {
        if(n<2)
            return n;
       if(n==2)
           return 1;
        int dp[]=new int[n+1];
        
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<dp.length;i++)
        {
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}
