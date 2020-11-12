package com.company;

import java.util.Arrays;

public class P01051HeightChecker {

    public static void main(String[] args) {
        int[] heights = new int[]{1,2,3,4,5};
        int answer = heightChecker(heights);
        System.out.println(answer);
    }

    public static int heightChecker(int[] heights) {

        int moveCount = 0;
        int[] originalArr = new int[heights.length];
        System.arraycopy(heights,0,originalArr,0,heights.length);

        Arrays.sort(heights);

        for (int i = 0; i< heights.length; i++){
            if(originalArr[i] == heights[i])
                continue;
            else
                moveCount++;
        }
        return moveCount;
    }

}

//https://leetcode.com/problems/height-checker/
