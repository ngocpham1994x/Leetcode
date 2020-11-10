package com.company;

public class P00239SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,-1};
        int k = 1;

        int[] answer = maxSlidingWindow(nums,k);
        for(int i : answer)
            System.out.println(i);
    }

    //optimal solution





    //Note: problem asks to find maximum integer within the window, NOT to find maxSum between two contiguous windows
    //this solution will fail the test case #53 : Time Limit Exceeded... :(
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length - k+1];

        for (int i =0;i < answer.length;i++){
            int maxNum = nums[i];
            for(int j = i; j < i+k; j++)
                maxNum = Math.max(maxNum,nums[j]);
            answer[i] = maxNum;
        }

        return answer;
    }

}

//https://leetcode.com/problems/sliding-window-maximum/
//https://www.youtube.com/watch?v=__guhvzO540&t=338s