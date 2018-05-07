package com.company;

import java.util.Scanner;

public class Solution {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        String firstLine = scan.nextLine();
        String[] parts = firstLine.split(" ");
        int numOfImages = Integer.parseInt(parts[2]);

        for(int i=0; i< numOfImages; i++){
            long timestamp = scan.nextInt();
            long row = scan.nextInt();
            long column = scan.nextInt();

            if(containsPicture(row, column)){
                System.out.println(timestamp);
            }
        }
    }



    public static boolean containsPicture(long row, long column){
        for(int i=0; i< row; i++){
            for(int j=0; j<column; j++){
                int intensity = scan.nextInt();
                if(intensity > 0){
                    return true;
                }
            }
        }
        return false;
    }
}
