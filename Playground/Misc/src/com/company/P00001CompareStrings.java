package com.company;

public class P00001CompareStrings {
    public static void main(String[] args) {

        String A = "abcd,aabc,bd";
        String B = "aaa,aa,cc";

        int[] answer = numSmallerByFrequency(A,B);

        for(int i : answer)
            System.out.println(i);

    }

    public static int[] numSmallerByFrequency(String A, String B){
        String[] listOfStringInA = A.split(",");
        String[] listOfStringInB = B.split(",");


        int[] numStringInAStrictlySmallerCompareToB = new int[listOfStringInB.length];
        int[] freqA = new int[listOfStringInA.length];
        int[] freqB = new int[listOfStringInB.length];


        for (int i=0; i< listOfStringInA.length; i++)
            freqA[i] = findFreqOfSmallestChar(listOfStringInA[i]);

        for (int i=0; i< listOfStringInB.length; i++)
            freqB[i] = findFreqOfSmallestChar(listOfStringInB[i]);

        for(int i=0; i < freqB.length;i++) {
            int count = 0;
            for (int j = 0; j < freqA.length; j++){
                if (freqA[j] < freqB[i])
                    count++;
            }
            numStringInAStrictlySmallerCompareToB[i] = count;
        }

        return numStringInAStrictlySmallerCompareToB;
    }


    public static int findFreqOfSmallestChar(String s){
        int freq = 0;
        char smallestChar = findSmallestChar(s);

        for (int i=0; i<s.length();i++)
            if(s.charAt(i) == smallestChar)
                freq++;

        return freq;
    }


    public static char findSmallestChar(String s){
        char smallestChar = s.charAt(0);
        char[] charArrayOfString = s.toCharArray();

        for(char theChar : charArrayOfString)
            if(theChar < smallestChar)
                smallestChar = theChar;

        return smallestChar;
    }
}


//https://leetcode.com/discuss/interview-question/352458/
//Similar problem from Leetcode's list of problems: P01170
////https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/

/*Steps involved:

1. find array that has smaller length, mark it as the String to compare with the longer String. Consider this is the B String, because:
 -This problem specifically said compare A to B, hence length B is smaller length A.
2. split 2 given strings to 2 arrays of Strings --> listOfStringA[], listOfStringB[]
3. find smallest character in each element of the String array
4. create array of frequency of smallest char --> freqA[], freqB[]
5. for each element in freqB[], compare freqA[] with each element in freqB[]
6. if freqA < freqB, then increment count
7. add count to array indicating total number of smaller String in A as compare to each element in String B.

 */