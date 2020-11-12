package com.company;

import java.util.Arrays;

public class P00004MinAbsDifferenceOfServerLoads {


    public static void main(String[] args) {
        // write your code here
        Integer[] loads = new Integer[]{1,2,3,8,5,6};
        int minDifference = solution(loads);
        System.out.println("The min difference between two loads is: "+minDifference);
    }

    public static int solution(Integer[] loads) {
        // put your solution here

        //Same result either sort array or no sort
//        Arrays.sort(loads);
//        for(int i : loads)
//            System.out.println(i);

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
        dp = fillDPTable(capacity,loadValues);


        //calculating difference between S1 - S2 (= sum - 2*S2)
        int minDifference = sum - 2*dp[lengthArr][maxLoad];

        return minDifference;
    }

    public static int[][] fillDPTable (int[] capacity, int[] loadValues){
        int[][] dp = new int[loadValues.length][capacity.length];

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

        return dp;
    }

}
//https://leetcode.com/discuss/interview-question/356433/
//It's the P00000 in this source tab
//Similar to P01049 on Leetcode list of problems:
//https://leetcode.com/problems/last-stone-weight-ii/description/
//https://leetcode.com/problems/last-stone-weight-ii/discuss/653550/Trying-to-Explain-A-bit-(logic-behind-trick)


//0/1 Knapsack problem:
//https://www.youtube.com/watch?v=-kedQt2UmnE
//https://www.youtube.com/watch?v=cJ21moQpofY
//https://www.youtube.com/watch?v=xCbYmUPvc2Q&t=253s