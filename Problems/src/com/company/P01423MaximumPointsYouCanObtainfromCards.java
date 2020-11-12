package com.company;

public class P01423MaximumPointsYouCanObtainfromCards {
    public static void main(String[] args) {
        int[] cardPoints = new int[]{1,2,3,4,5,6,1};
        int k = 3;

        int maxSum = MaxSum(cardPoints,k);
        System.out.println(maxSum);
    }


    public static int MaxSum(int[] cardPoints, int k){
        int maxSum = 0;
        int currentSum = 0;
        int n = cardPoints.length;

        //initialize first maxSum in the first window
        for (int i=0; i<k; i++)
            maxSum += cardPoints[i];

        //sliding window of k-length through entire arr, to the left, override to the end, continue leftward
        currentSum = maxSum;
        for(int i=0; i< k;i++){
            currentSum += (-cardPoints[k-i-1] + cardPoints[n-i-1]);
            maxSum = Math.max(maxSum,currentSum);
        }


        return maxSum;
    }


}

//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
//Key idea: You can’t choose 2nd element from the beginning unless you have chosen the first one.
//Similarly, you can’t choose 2nd element from last unless you have chosen the last one.