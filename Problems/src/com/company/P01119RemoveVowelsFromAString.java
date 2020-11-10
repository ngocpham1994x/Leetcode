package com.company;

public class P01119RemoveVowelsFromAString {
    public static void main(String[] args) {
        System.out.println(removeVowels("leetcodeisacommunityforcoders"));
    }


    public static String removeVowels(String S) {
        String newString = "";
        for (int i = 0; i < S.length(); i++)
            if (S.charAt(i) != 'a' && S.charAt(i) != 'e' && S.charAt(i) != 'i' && S.charAt(i) != 'o' && S.charAt(i) != 'u')
                newString += S.charAt(i);
        return newString;
    }
}

//https://leetcode.com/problems/remove-vowels-from-a-string/