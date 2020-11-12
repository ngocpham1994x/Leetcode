package com.company;

public class P00000A1 {
    public static void main(String[] args) {

        String T = "??:01";
        int answer = solution(T);
        System.out.println(answer);
    }

    public static int solution(String T) {
        // Your solution goes here.
        int answer = 0;
        int a=1,b=1,c=1,d=1;
        char[] chars = T.toCharArray();


        if (chars[0] == '?'){
            if(chars[1] <= '3' && chars[1] != '?')
                a = 3;  // 0 1 2
            if(chars[1] > '3' && chars[1] != '?')
                a = 2;  // 0 1
            if(chars[1] == '?')
                answer = 24;
        }

        if(chars[1] == '?') {
            if(chars[0] <= '1' || chars[0] == '?')
                b=10;  // 0 - 9
            if(chars[0] == '2')
                b=4;  // 0 1 2 3
        }

        //char[2] is the colon

        if(chars[3] == '?')
            c = 6;  // 0-5


        if(chars[4] == '?')
            d = 10; // 0-9


        answer = a*b*c*d;

        int countNoQuestionMark = 0;
        for(int i=0; i< chars.length;i++)
            if(chars[i] != '?')
                countNoQuestionMark++;
        if(countNoQuestionMark == 5)
            answer = 0;

        return answer;
    }



}


/*

Given a time (in 24-hour format) with missing digits marked as '?',
we want to replace all of the question marks with digits (0-9) in such a way as to obtain a valid time.
The earliest possible time is 00:00 and the latest valid time is 23:59.

Write a function:
                       class Solution { public int solution(String T); }

that, given a string T in the format "HH:MM", returns an integer denoting the number of valid times that can be obtained by replacing the question marks.

Examples:

Given T = "2?:45", the function should return 4. We can obtain four valid times: "20:45", "21:45", "22:45" and "23:45".
Given T = "?9:32", the function should return 2. Valid times are: "09:32" and "19:32".
Given T = "0?:?0", the function should return 60.
Given T = "?4:0?", the function should return 20.
Given T = "29:01", the function should return 0.
Assume that: T consists of exactly five characters; the third one is ':'; the others are digits (0-9) or '?'.

In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

 */