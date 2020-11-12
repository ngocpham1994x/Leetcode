package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class P004 {
    public static void main(String[] args) {
        String name = "alex";
        String typed = "aaleex";

        boolean answer = isLongPressedName(name, typed);
        System.out.println(answer);

    }

    public static boolean isLongPressedName(String name, String typed) {
        boolean answer =true;
        char[] nameChar = name.toCharArray();
        char[] typedChar = typed.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char charInTyped : typedChar) {
            map.put(charInTyped, map.getOrDefault(charInTyped, 0) + 1);
        }
        int k = 0;

//        System.out.println(map.entrySet());

        for (char charInName : nameChar) {
            int cnt = map.getOrDefault(charInName, 0);
            if (cnt > 0) {
                nameChar[k++] = charInName;
                map.put(charInName, cnt - 1);
            }
        }

//        char[] newName = Arrays.copyOfRange(nameChar, 0, k); //actual name
//        System.out.println(map.entrySet());
//        System.out.println(newName);

        ArrayList typedCharArrList = new ArrayList();
        for(char c : typedChar)
            typedCharArrList.add(c);

        for(char key : map.keySet()) {
            int remaindingChar = map.get(key);
            while(remaindingChar > 0){
                typedCharArrList.remove(typed.lastIndexOf(key));
                remaindingChar--;
            }
        }

        for(int i=0; i<typedCharArrList.size();i++){
            if((char) typedCharArrList.get(i) == nameChar[i])
                continue;
            else
                answer = false;
        }

//        for(char key : map.keySet()) {
//            if (map.get(key) >= 1){
//                answer = true;
//                break;
//            }
//        }
        return answer;
    }
}
