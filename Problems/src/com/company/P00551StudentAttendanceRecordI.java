package com.company;

import java.util.HashMap;
import java.util.Map;

public class P00551StudentAttendanceRecordI {


    public static void main(String[] args) {
        // write your code here
        String s = "LALL";
        boolean answer = checkRecord(s);
        System.out.println(answer);

    }

    public static boolean checkRecord(String s) {
        boolean reward = true;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for(char c : chars)
            map.put(c,map.getOrDefault(c,0)+1);

        if(map.containsKey('A') && map.get('A') > 1)
            reward = false;
        else if(map.containsKey('L') && map.get('L') >= 3){
            //proper sliding-window
            for(int i=0; i < chars.length - 3 +1; i++){
                int count = 0;
                for(int j=i; j < 3+i; j++) {
                    if (chars[j] == 'L')
                        count++;
                }
                if(count ==3) {
                    reward = false;
                    break;
                }
            }
        }


        return reward;
    }

}
//https://leetcode.com/problems/student-attendance-record-i/
