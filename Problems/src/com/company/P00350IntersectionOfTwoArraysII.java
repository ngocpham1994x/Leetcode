package com.company;

import java.util.ArrayList;

public class P00350IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = new int[] {4,9,5,4,4,4};
        int[] nums2 = new int[] {9,4,9,8,4};

//        int[] answer = intersect(nums1,nums2);

//        for (int i=0;i< answer.length;i++)
//            System.out.println(answer[i]);

    }

    //HashMap technique
//    public static int[] intersect(int[] nums1, int[] nums2) {
//
//
//        return null; //dummy for now
//    }





    //methods below don't solve for the case when 2 given arrays have same size!
//    public static int[] intersect(int[] nums1, int[] nums2) {
//        ArrayList<Integer> answer = new ArrayList<Integer>();
//
//        if(nums1.length < nums2.length)
//            answer = compareSmallToBig(nums1,nums2);
//        else
//            answer = compareSmallToBig(nums2,nums1);
//
//
//        int[] answerArr = answer.stream().mapToInt(i->i).toArray();  //convert ArrayList<Integer> to int[]
//        return answerArr;
//    }
//
//    public static ArrayList<Integer> compareSmallToBig(int[] smallerArr, int[] biggerArr) {
//        ArrayList<Integer> answer = new ArrayList<Integer>();
//
//        for (int x : smallerArr) {
//            int count = 0;
//            for (int y : biggerArr) {
//                if (x == y) {
//                    answer.add(x);
//                    count++;
//                }
//            }
//            //more than 1 occurrence in comparable array, count as 1 only
//            if (count > 1)
//                for (int i = 1; i < count; i++)
//                    answer.remove(answer.lastIndexOf(x));
//        }
//        return answer;
//
//    }


}

//https://leetcode.com/problems/intersection-of-two-arrays-ii/