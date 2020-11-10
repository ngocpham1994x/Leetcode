package com.company;

public class P00482LicenseKeyFormatting {

    public static void main(String[] args) {
        String s2 ="";
        int K=3;
        String s1 = "5F3Z-2e-9-w2-5g-3-J";
        String noDash = s1.replace("-", "");
        int group = noDash.length()/K;
        int remainder = noDash.length()%K;

        if(remainder == 0){
            for(int i=0; i < group; i++) {
                int startIndex = i*K;
                int endIndex = (i+1)*K;
                if(i!=group-1)
                    s2 += noDash.substring(startIndex,endIndex) + "-";
                if(i==group-1)
                    s2 += noDash.substring(startIndex,endIndex) ;
            }
            s2=s2.toUpperCase();
        }

        if(remainder != 0) {
            String oddGroup = noDash.substring(0, remainder);
            int remaindingLength = noDash.length() - oddGroup.length();

            if (remaindingLength > 0) {
                String rest = noDash.substring(remainder);
                for (int i = 0; i < group; i++) {
                    int startIndex = i * K;
                    int endIndex = (i + 1) * K;
                    if (i != group - 1)
                        s2 += rest.substring(startIndex, endIndex) + "-";
                    if (i == group - 1)
                        s2 += rest.substring(startIndex, endIndex);
                }
                s2 = oddGroup.toUpperCase() + "-" + s2.toUpperCase();
            }

            else
                s2 = oddGroup;
        }

        System.out.println("Length is: " + noDash.length() + "\n" + group + " groups of " + K + " & 1 group of "+ remainder );
        System.out.println(s2);
    }
}


//https://leetcode.com/problems/license-key-formatting/