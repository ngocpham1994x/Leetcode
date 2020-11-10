package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class P00002LargestSubarrayLengthK {
    public static void main(String[] args) {

        int[] A = new int[]{1,4,3,3,4,3,1,2,5};
        int k = 4;

        int[] B;
        B = findLargestSubArr(A,k);

        //below is just for showing on console
        ArrayList givenArray = new ArrayList();
        for (int element : A)
            givenArray.add(element);

        System.out.println("Given array: \n" + givenArray);

        System.out.println();
        System.out.println("All subarrays: \n" + findAllSubArr(A,k));

        System.out.println("\nThe max subarray is: ");
        for(int i : B)
            System.out.println(i);

    }

    //basically doing sliding window twice. One for finding all subarrays, one for finding max array in subarrays list
    public static int[] findLargestSubArr(int[] arr, int k) {
        ArrayList allSubArr = findAllSubArr(arr,k);
        ArrayList maxArrBetweenTwoArr = new ArrayList();

        for(int i=0; i<k; i++)
            maxArrBetweenTwoArr.add(0);


        //sliding window of length 1, result in "size()-1" iteration
        for (int i=0; i < allSubArr.size(); i++){
            maxArrBetweenTwoArr = largerArrBetweenTwoArr((ArrayList)allSubArr.get(i),maxArrBetweenTwoArr);
//            System.out.println(maxArrBetweenTwoArr);
        }

        int[] answerArr = new int[k];  //convert ArrayList to int[]
        for (int i =0; i < k; i++)
            answerArr[i] = (int) maxArrBetweenTwoArr.get(i);

        return answerArr;
    }

    public static ArrayList findAllSubArr(int[] arr, int k) {
        ArrayList listSubArr = new ArrayList();

        //sliding window with length of k, result in "length-k+1" iterations
        for (int i = 0; i < arr.length - k + 1; i++) {
            ArrayList subArr = new ArrayList();
            for (int j = 0; j < k; j++) {
                subArr.add(arr[j + i]);
            }
            listSubArr.add(subArr);
        }
        return listSubArr;
    }

    public static ArrayList largerArrBetweenTwoArr(ArrayList arr1, ArrayList arr2) {
        ArrayList largerArr = new ArrayList();
        if(arr1.equals(arr2))
            largerArr = arr1;
        else {
            for (int i = 0; i < arr1.size(); i++) {
                if ((int) arr1.get(i) == (int) arr2.get(i))
                    continue;
                else if ((int) arr1.get(i) > (int) arr2.get(i)){
                    largerArr = arr1;
                    break;
                }
                else if ((int) arr1.get(i) < (int) arr2.get(i)){
                    largerArr = arr2;
                    break;
                }
            }
        }
        return largerArr;
    }

}

//https://leetcode.com/discuss/interview-question/352459/
//Extra pratice on this easier problem P00239 from Leetcode's list of problems:
//https://leetcode.com/problems/sliding-window-maximum/