package com.company;

import java.util.*;

public class P00000ServerLoads {

    public static void main(String[] args) {
	// write your code here
        Integer[] loads = new Integer[]{1,2,3,4,5};
        int minDifference = solution(loads);
        System.out.println("The min difference between two loads is: "+minDifference);
    }

    public static int solution(Integer[] loads) {
        // put your solution here
        Arrays.sort(loads);
        int lengthArr = loads.length;
        int sum = 0;
        int maxLoad;

        for (int i : loads)
            sum += i;
        maxLoad = sum/2;

        //setting up dp table
        int[][] dp = new int[lengthArr+1][maxLoad + 1];
        int[] capacity = new int[maxLoad+1];
        int[] loadValues = new int[lengthArr+1];


        for(int j = 1; j < capacity.length; j++)
            capacity[j] = j;

        for(int i = 1; i < loadValues.length; i++)
            loadValues[i] = loads[i-1];

        //filling dp table
        for(int i=0; i < loadValues.length; i++) {
            for (int j = 0; j < capacity.length; j++) {
                if(i==0 || j == 0)
                    dp[i][j] = 0;
                if(i>0 && j>0){
                    if (loadValues[i] <= capacity[j])
                        dp[i][j] = Math.max(dp[i-1][j],loadValues[i] + dp[i-1][j-loadValues[i]]);
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
        }

        //code to visual the dp table:
        System.out.println("The dp table: ");
        for(int i=0; i < loadValues.length; i++) {
            for (int j = 0; j < capacity.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        //calculating difference between S1 - S2 (= sum - 2*S2)
        int minDifference = sum - 2*dp[lengthArr][maxLoad];

        return minDifference;
    }

}


/*
There are some processes that need to be executed. Amount of a load that process causes on a server that runs it, is being represented by a single integer.
Total load caused on a server is the sum of the loads of all the processes that run on that server.
You have at your disposal two servers, on which mentioned processes can be run.
Your goal is to distribute given processes between those two servers in the way that, absolute difference of their loads will be minimized.


Write a function that, given an array A of N integers, of which represents loads caused by successive processes,
the function should return the minimum absolute difference of server loads.


For example, given array A such that:

  A[0] = 1

  A[1] = 2

  A[2] = 3

  A[3] = 4

  A[4] = 5


your function should return 1.
We can distribute the processes with loads 1, 2, 4 to the first server
and 3, 5 to the second one, so that their total loads will be 7 and 8, respectively,
and the difference of their loads will be equal to 1.


Assume that:

N is an integer within the range [1..1,000]

the sum of the elements of array A does not exceed 100,000


In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

 */

///////////////////////////////////////////////////////////////////////////////
//https://leetcode.com/discuss/interview-question/356433/
//It's the P00000 in this source tab
//Similar to P01049 on Leetcode list of problems:
//https://leetcode.com/problems/last-stone-weight-ii/description/
//https://leetcode.com/problems/last-stone-weight-ii/discuss/653550/Trying-to-Explain-A-bit-(logic-behind-trick)


//0/1 Knapsack problem:
//https://www.youtube.com/watch?v=-kedQt2UmnE
//https://www.youtube.com/watch?v=cJ21moQpofY
//https://www.youtube.com/watch?v=xCbYmUPvc2Q&t=253s