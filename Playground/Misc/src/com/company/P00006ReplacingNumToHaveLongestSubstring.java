package com.company;

public class P00006ReplacingNumToHaveLongestSubstring {

    public static void main(String[] args) {
        int[] A = new int[]{1,2,7,8,3,45};
        int k = 3;

        int lengthOfLongest = solution(A);
        System.out.println(lengthOfLongest);

    }

    public static int solution(int[] A){
        //define the window specs
        int start = 0;
        int end;
        int k = 1; //move

        //define other specs
        int answer = 0; //longest length of contiguous char
        int replaceCount=0;
        int[] numCount = new int[100];  //assume given numbers are not bigger than 100
        int maxNumFreqWithinWindow = 0;  //in the charCount array, this decides which char is maximum appearance


        //loop through the window in the given String
        for(end =0; end < A.length; end++) {
            int currentNum = A[end];
            int currentNumFreqInTheWindow = ++numCount[currentNum];  //increment first, then return
            maxNumFreqWithinWindow = Math.max(maxNumFreqWithinWindow, currentNumFreqInTheWindow);

            replaceCount = (end - start + 1) - maxNumFreqWithinWindow;
            if (0 <= replaceCount && replaceCount <= k)   //because we can perform AT MOST k operations
                answer = Math.max(answer, end - start + 1);   //length of the current window (or sub string) is end - start + 1
            else {
                --numCount[A[start]];
                maxNumFreqWithinWindow = 0;  //reset max freq value
                start++;   //if we replace more than k operations, pops the char at the start of the window, evaluate the new window from (start + 1) to (end+1) in next iteration

                //note that "ABABB" and "BABBA" will result same answer 5 as max length of same-letter string.
                //'A' was subtracted then added (even if next letter is a different letter than 'A') --> maxNumFreqWithinWindow stays the same --> replaceCount stays the same.
                //Therefore next iteration is for trying to find if max length can be 6, so increment the (end) to (end+1)

            }
        }
        return answer;
    }


}

//https://leetcode.com/discuss/interview-question/927457/Google-or-OA-or-2021-SWE-Internship

/*
Given an array consists of integers (ex. [1,2,3,1,2,3,3,3]),
the required returning value is the length of longest substring
that consists of repeating integer value you can get with maximum 3 replacements
(and you can replace any item with any value).

Test cases:

Input: A = [1,2,3,1,2,3,3,3]
Output: 7
Replace A[1], A[3], A[4] with 3 (3 moves)

Input: A = [1,2,7,8,3,45]
Output: 4
Pick any item and replace 3 items adjacent to that item with the value of the picked item.
 */