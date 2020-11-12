package com.company;

import java.util.*;

public class P00350IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = new int[] {4,9,5,4,4,4};
        int[] nums2 = new int[] {9,4,9,8,4};

        int[] answer = intersect(nums1,nums2);

        for (int i=0;i< answer.length;i++)
            System.out.println(answer[i]);

    }


    //HashMap technique
    public static int[] intersect(int[] nums1, int[] nums2) {
        //for checking the shorter array against longer array
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);

        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1)
            m.put(n, m.getOrDefault(n, 0) + 1);

        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }




    //methods below don't solve for the case when 2 given arrays have same size!
    //or if the intersect has same values. Example: {2,2}
//    public static int[] intersect(int[] nums1, int[] nums2) {
//        int[] answerArr;
//        ArrayList answer = new ArrayList();
//
//        if(nums1.length < nums2.length)
//            answer = compareSmallToBig(nums1,nums2);
//        else
//            answer = compareSmallToBig(nums2,nums1);
//
//
////        int[] answerArr = answer.stream().mapToInt(i->i).toArray();  //convert ArrayList<Integer> to int[]
//        answerArr = new int[answer.size()];
//        for(int i = 0; i < answer.size(); i++)
//            answerArr[i] = (int) answer.get(i);
//
//        return answerArr;
//    }
//
//    public static ArrayList compareSmallToBig(int[] smallerArr, int[] biggerArr) {
//        ArrayList answer = new ArrayList();
//
//        for (int x : smallerArr) {
//            int count = 0;
//            for (int y : biggerArr) {
//                if (x == y) {
//                    answer.add(x);
//                    count++;
//                }
//            }
//        }
//
//        //remove duplicates
//        //........
//        return answer;
//
//    }

}

//https://leetcode.com/problems/intersection-of-two-arrays-ii/