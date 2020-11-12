package com.company;

public class P00000A2 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 3, 2, 1, 2, 2, 9, 3, 3};

        int answer = solution(arr);

        System.out.println(answer);

    }

    public static int solution(int[] A) {
        //define the window specs
        int start = 0;
        int end;
        int k = 3; //move

        //define other specs
        int answer = 0; //longest length of contiguous char
        int replaceCount = 0;
        int[] numCount = new int[21];  // number is from [-10...10], there are 21 nums total. Index = num +10
        int maxNumFreqWithinWindow = 0;  //in the given array, this decides which num is maximum appearance


        //loop through the window in the given num array
        for (end = 0; end < A.length; end++) {
            int currentNum = A[end];
            int currentNumFreqInTheWindow = ++numCount[currentNum+10];  //increment first, then return
            maxNumFreqWithinWindow = Math.max(maxNumFreqWithinWindow, currentNumFreqInTheWindow);

            replaceCount = (end - start + 1) - maxNumFreqWithinWindow;
            if (0 <= replaceCount && replaceCount <= k)   //because we can perform AT MOST k operations
                answer = Math.max(answer, end - start + 1);   //length of the current window (or sub string) is end - start + 1
            else {
                --numCount[A[start]+10];
                maxNumFreqWithinWindow = 0;  //reset max freq value
                start++;
            }

        }

        return answer;
    }

}

/*
We are given an array A consisting of N integers. In one move, we can choose any element in this array and replace it with any value.

We are interested in the longest consistent segment of identical elements. For example, given an array A = [3, -3, 3, 3, 3, 1, -3], the segment that we are looking for is [3, 3, 3].

What is the maximum length of such a segment that we can achieve by performing at most three moves on the array?

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the maximum length of a consistent segment of identical elements in the array A that can be obtained after replacing up to three elements in the array.

Examples:
Given A = [-9, 8], your function should return 2. One of the correct ways to obtain such a solution is to use one move and change 8 into -9.
Given A = [1, 1, -10, 3, -10, 3, -10], your function should return 6. By performing three moves we can obtain the following array: [1, -10, -10, -10, -10, -10, -10].
Given A = [2, 3, 3, 3, 3, 1], your function should return 6. We can perform two moves to replace the first and last elements with 3s.
Given A = [3, 3, 2, 1, 2, 2, 9, 3, 3], your function should return 6. By performing three moves we can obtain the following array: [3, 3, 2, 2, 2, 2, 2, 2, 3].
Assume that:
N is an integer within the range [1..10];
each element of array A is an integer within the range [−10..10].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.


 */