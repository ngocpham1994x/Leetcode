package com.company;

import java.util.HashSet;
import java.util.Set;

public class testPlayGround {

    public static void main(String[] args) {

        Integer[] integerArrayWrapper = new Integer[]{1,2,3,4,5};
        int[] integerArray = new int[]{7,8,9,10};


        System.out.println(integerArrayWrapper);
        System.out.println(integerArray);
    }

}


//    public static int[] intersect(int[] nums1, int[] nums2) {
//        int[] answer;
//        Set<Integer> map = new HashSet<>();
//
//        for (int x : nums1)
//            for (int y : nums2)
//                if (x == y)
//                    map.add(x);
//
//
////        int[] answerArr = answer.stream().mapToInt(i->i).toArray();  //convert ArrayList<Integer> to int[]
//        answer = new int[map.size()];
//        Object[] temp = map.toArray();
//        for(int i = 0; i < temp.length; i++)
//            answer[i] = (int) temp[i];
//
//        return answer;