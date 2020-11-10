package com.company;
import java.util.ArrayList;

public class P00929UniqueEmailAddresses {

    public static void main(String[] args) {
        String[] emails = new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
                //"test.emailalex@leetcode.com","test.e.mailbob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        ArrayList x = numUniqueEmails(emails);
        int y = x.size();
        System.out.println(x);
        System.out.println(y);
    }

    public static ArrayList numUniqueEmails(String[] emails) {
        ArrayList<String> receiver = new ArrayList<String>();

        for (int i=0;i < emails.length; i++){
            String address = emails[i];
            int atSignPosition = address.indexOf("@");
            String localName = address.substring(0,atSignPosition);
            String domain = address.substring(atSignPosition+1);
            String receiverAddress;

            receiverAddress = getValidSender(localName);
            receiverAddress += "@" + domain;
            receiver.add(receiverAddress);
        }//end for
        //handling duplication
        removeDuplication(receiver);
        return receiver;
    } //end main

    public static String getValidSender(String localName){
        if(localName.indexOf("+") > 0){
            //for "+" condition
            int plusSignPosition = localName.indexOf("+");
            localName = localName.substring(0,plusSignPosition);
        }

        if(localName.indexOf(".") > 0){
            //for "." condition
            localName = localName.replace(".","");
//            String[] path = localName.split(".");
//            localName = "";
//            for (int j = 0; j < path.length; j++)
//                localName += path[j];
        }
        return localName;
    }

    public static void removeDuplication(ArrayList<String> receiver){
        for (int i=0;i<receiver.size();i++){
            String emailAddress = receiver.get(i);
            int position;

            //remove any duplications that are beyond position
            while (i < (position = receiver.lastIndexOf(emailAddress)))
                receiver.remove(position);
        }//end for
    }//end removeDuplication


}//end class Solution

//

//https://leetcode.com/problems/unique-email-addresses/