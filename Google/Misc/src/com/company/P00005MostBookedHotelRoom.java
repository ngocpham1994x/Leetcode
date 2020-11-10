package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P00005MostBookedHotelRoom {

    public static void main(String[] args) {
        String[] A = new String[]{"+1A","+3E","-1A","+1B","+4F","+1A","-3E","-1B","+1B","-1B","+1B"};
        String theMostBookedRoom = solution(A);
        System.out.println(theMostBookedRoom);
    }

    public static String solution(String[] rooms){
        String answer;
        Map<String,Integer> map = new HashMap<>();
        int maxBookedNum = 0;

        Arrays.sort(rooms);

        for(String room : rooms){
            String roomNum = room.substring(1);
            if(room.charAt(0) == '+'){
                map.put(roomNum,map.getOrDefault(roomNum,0)+1);  // set initial value of key to 0, if "+" then set to actual current value + 1
                maxBookedNum = Math.max(maxBookedNum, map.get(roomNum));   // update max value
            }
        }

        System.out.println("The hashmap is: " + map.entrySet());

        ArrayList mostBookedRoomsList = new ArrayList();
        for(String roomNum : map.keySet())
            if(map.get(roomNum) == maxBookedNum)
                mostBookedRoomsList.add(roomNum);

        System.out.println("The list of most booked rooms is: " + mostBookedRoomsList);

        answer = (String) mostBookedRoomsList.get(0);

        return answer;

    }
}

//https://leetcode.com/discuss/interview-question/421787/


