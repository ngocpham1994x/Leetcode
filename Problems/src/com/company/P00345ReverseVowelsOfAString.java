package com.company;

public class P00345ReverseVowelsOfAString {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hEllo"));
    }


    public static String reverseVowels(String S) {
        String vowelString = "";
        String newString = "";


        for (int i = 0; i < S.length(); i++)
            if (S.charAt(i) == 'a' || S.charAt(i) == 'e' || S.charAt(i) == 'i' || S.charAt(i) == 'o' || S.charAt(i) == 'u' ||
                    S.charAt(i) == 'A' || S.charAt(i) == 'E' || S.charAt(i) == 'I' || S.charAt(i) == 'O' || S.charAt(i) == 'U')
                vowelString += S.charAt(i);

        int vowelIndex = vowelString.length()-1;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'a' || S.charAt(i) == 'e' || S.charAt(i) == 'i' || S.charAt(i) == 'o' || S.charAt(i) == 'u' ||
                    S.charAt(i) == 'A' || S.charAt(i) == 'E' || S.charAt(i) == 'I' || S.charAt(i) == 'O' || S.charAt(i) == 'U') {
                newString += vowelString.charAt(vowelIndex);
                vowelIndex--;
            }
            else
                newString += S.charAt(i);
        }
        return newString;
    }
}


//https://leetcode.com/problems/reverse-vowels-of-a-string/