package com.company;

public class P002 {

    public static void main(String[] args) {

    }

    public int networkDelayTime(int[][] times, int N, int K) {
        int timeTakesForAllNodes =0;

        for(int i =0; i< times.length; i++)
            if(times[i][0] == K)
                   timeTakesForAllNodes += times[i][2];


        return timeTakesForAllNodes;
    }

}
