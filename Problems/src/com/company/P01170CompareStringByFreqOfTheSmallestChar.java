package com.company;

public class P01170CompareStringByFreqOfTheSmallestChar {
    public static void main(String[] args) {
        String[] queries = new String[]{"bbb","cc"};
        String[] words = new String[]{"a","aa","aaa","aaaa","aaaaa"};

        int[] answer = numSmallerByFrequency( queries, words);

        for(int i= 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }

    }

    public static int[] numSmallerByFrequency(String[] queries, String[] words){
        int[] answer = new int[queries.length];
        int[] freqOfQueries = new int[queries.length];
        int[] freqOfWords = new int[words.length];

        for (int i=0; i < queries.length;i++)
            freqOfQueries[i] = calculateFrequencyOfSmallestChar(queries[i]);

        for (int i=0; i < words.length;i++)
            freqOfWords[i] = calculateFrequencyOfSmallestChar(words[i]);

        for(int i=0; i < queries.length;i++) {
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if (freqOfQueries[i] < freqOfWords[j]) {
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }

    public static int calculateFrequencyOfSmallestChar(String s) {
        int freq = 0;
        char smallestChar;

        smallestChar = findSmallestChar(s);

        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == smallestChar)
                freq++;

        return freq;

    }

    public static char findSmallestChar(String s) {
        char smallestChar = s.charAt(0);
        char[] charArrOfString = s.toCharArray();

        for (int i = 1; i < charArrOfString.length; i++){
            if(s.charAt(i) < smallestChar)
                smallestChar = s.charAt(i);
        }

        return smallestChar;
    }

}


//https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/