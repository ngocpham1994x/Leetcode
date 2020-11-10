package com.company;

import java.util.Arrays;

public class testPlayGround {
    public static void main(String[] args) {
        String A = "+1A,+3E,-1A,+1B,+4F,+1A,-3E";
        String[] test = A.split(",");
        Arrays.sort(test);

        for(String s : test)
            System.out.println(s);

    }

}
