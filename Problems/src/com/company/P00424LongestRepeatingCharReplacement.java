package com.company;

public class P00424LongestRepeatingCharReplacement {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;

        int answer = findLongestRepeatingCharReplacement(s,k);
        System.out.println(answer);

    }


    public static int findLongestRepeatingCharReplacement(String s,int k){
        //define the window specs
        int start = 0;
        int end;

        //define other specs
        int answer = 0; //longest length of contiguous char
        int replaceCount=0;
        int[] charCount = new int[26];  //26 chars in the alphabet, this array keeps track of the num of chars appear in the given WINDOW. No need hashmap because here, index 0 is depict num of appearance of A, etc.
        int maxCharFreqWithinWindow = 0;  //in the charCount array, this decides which char is maximum appearance


        //loop through the window in the given String
        for(end =0; end < s.length(); end++){
            char currentChar = s.charAt(end);
            int currentCharFreqInTheWindow = ++charCount[currentChar - 'A'];  //increment first, then return
            maxCharFreqWithinWindow = Math.max(maxCharFreqWithinWindow,currentCharFreqInTheWindow);

            replaceCount = (end - start + 1) - maxCharFreqWithinWindow;
            if(0 <= replaceCount && replaceCount <= k)   //because we can perform AT MOST k operations
                answer = Math.max(answer, end - start + 1);   //length of the current window (or sub string) is end - start + 1
            else {
                --charCount[s.charAt(start)-'A'];
                maxCharFreqWithinWindow = 0;
                start++;   //if we replace more than k operations, pops the char at the start of the window, evaluate the new window from (start + 1) to (end+1) in next iteration
            }
        }


        return answer;
    }


}


//https://leetcode.com/problems/longest-repeating-character-replacement/

/*
Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
In one operation, you can choose any character of the string and change it to any other uppercase English character.
Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.
----------------------
Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.

----------------------
Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
 */