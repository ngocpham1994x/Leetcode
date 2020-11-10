package com.company;


public class P00003MaximumTime {

    public static void main(String[] args) {
	// write your code here
        System.out.println(giveMaxTime("?9:??"));

    }

    public static String giveMaxTime(String s){
        char[] chars = s.toCharArray();

        if (chars[0] == '?')
            chars[0] = (chars[1] <= '3' || chars[1] == '?') ? '2' : '1';

        if(chars[1] == '?')
            chars[1] = (chars[0] == '?' || chars[0] == '2') ? '3' : '9';

        if(chars[3] == '?')
            chars[3] = '5';

        if(chars[4] == '?')
            chars[4] = '9';

        return String.valueOf(chars);
    }
}

//https://leetcode.com/discuss/interview-question/396769/
/*
You are given a string that represents time in the format hh:mm.
Some of the digits are blank (represented by ?).
Fill in ? such that the time represented by this string is the maximum possible.
Maximum time: 23:59, minimum time: 00:00. You can assume that input string is always valid.

Example 1:

Input: "?4:5?"
Output: "14:59"


Example 2:

Input: "23:5?"
Output: "23:59"


Example 3:

Input: "2?:22"
Output: "23:22"


Example 4:

Input: "0?:??"
Output: "09:59"


Example 5:

Input: "??:??"
Output: "23:59"
 */