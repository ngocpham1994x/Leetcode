package com.company;

public class P00344ReverseString {

    public static void main(String[] args) {
        String s = "leetcodeisacommunityforcoders";
        char[] chars = s.toCharArray();
        System.out.println(chars);

        char[] reverseChars = reverseString(chars);
        System.out.println(reverseChars);

    }


    public static char[] reverseString(char[] s) {
        //kind of like "sliding-window", push rightwards

        //setup
        int start = 0;
        int end = s.length-1;

        char tempFirst;
        while (start < end) {
            tempFirst = s[start];
            s[start] = s[end];
            s[end] = tempFirst;
            start++;
            end--;
        }
        return s;
    }
}

//https://leetcode.com/problems/reverse-string/