//Eliza With HashMap

package com.company;
import java.util.HashMap;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to a Therapy store, I am Eliza, How may I help you Today?");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Enter your Response here are or 'Q' to End the chat?");
        String s1 = sc.nextLine();
        String message = "";

        while (!s1.toLowerCase().equals("q")) {
            String[] input = (s1.split(" "));

            message="";


            for (int i = 0; i < input.length; i++) {
                String re = getReplace(input[i]);
                if (input[i].contains("I")) {
                    input[i] = input[i].replace("I", re);
                } else if (input[i].contains("me")) {
                    input[i] = input[i].replace("me", re);
                } else if (input[i].contains("my")) {
                    input[i] = input[i].replace("my", re);
                } else if (input[i].contains("am")) {
                    input[i] = input[i].replace("am", re);
                } else if (input[i].contains("you")) {
                    input[i] = input[i].replace("you", re);
                } else {
                    input[i] = input[i];
                }
                message += (input[i] + " ");
            }
            //checking if the input contain these key words
            if  ((s1.contains("I")) || (s1.contains("my")) || (s1.contains("me"))
                    || (s1.contains("am")) || (s1.contains("you"))){
                //calling method to get a qualifier
                String qu = getQualif();
                //Printing the Qualifier message
                System.out.print(qu + " " + message);
                s1 = sc.nextLine();
            }
            else {
                //calling method to get a hedge
                String hed = getHedge();
                //Printing the hedge
                System.out.println(hed);
                s1 = sc.nextLine();
            }


        }
        System.out.println("thanks");
    }
//METHOD creation and generating random value
    public static  String getReplace(String  key) {
        HashMap<String, String> replacements = new HashMap<>();
        replacements.put("I", "you");
        replacements.put("me", "your");
        replacements.put("am", "are");
        replacements.put("my", "your");
        replacements.put("you", "me");
        String rp=replacements.get(key);
        return rp;
    }

    public static  String getQualif(){
        Random rnd = new Random();
        HashMap<Integer, String> qualif = new HashMap<Integer, String>();
        qualif.put( 1, "Why do you say that");
        qualif.put(2, "You seem to think that");
        qualif.put(3, "So you are concerned that");
        qualif.put(4, "So you are concerned that");

        int qual = rnd.nextInt(qualif.size());
        String quali =qualif.get(qual+1);
        return quali;

    }
    public static String  getHedge(){
        Random rnd = new Random();
        HashMap<Integer, String> hedge = new HashMap<>();
        hedge.put( 1, "Please tell me more");
        hedge.put(2, "Many of my patients tell me the same thing It is getting late");
        hedge.put(3, "Maybe we better quit");
        hedge.put(4, "I think we should go now");

        int he = rnd.nextInt(hedge.size());
        String hed= hedge.get(he+1);
        return hed;



   }

}


