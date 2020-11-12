package com.company;

public class P00007LayingStones {

}
//https://leetcode.com/discuss/interview-question/928141/Google-or-OA-or-REJECT

/*
There are N stones lying in a line. The cost and type of the ith stone is 'ai' units and 'i' respectively.
You are initially having zero stones and you wish to collect all the N types of stones, type 1, type 2,.....,type N.
You can perform the following operation multiple times (probably zero) to change the types of all the stones in one step :

The stone of the type 'i' will be changed to the type 'i +1'. If 'i' is N, then change its type to 1.(1<=i<=N).

Applying this operation single time costs x unit(s).

Your task is to print the minimum price that you have to pay to get all the N types of stones in your collection.

Input format :

• First line: Two integers N, x.

• Next line: N space-separated integers representing the price of each stone.

Output format

Print a single integer representing the minimum price to get all the N types of stones.

Input Constraints :
1 < N < 2000
0 < x <= 10^9
1 <= a[i] <= 10^9

sample input :
3 5
50 1 50

sample output :
13
 */