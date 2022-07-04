package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt();
        int friendsNum = scan.nextInt();

        if (sum < 0){
            System.out.println("Bill total amount cannot be negative");
            return;
        }

        if (friendsNum <= 0){
            System.out.println("Number of friends cannot be negative or zero");
            return;
        }

        sum *= 1.1;
        System.out.println(sum / friendsNum );
    }
}
