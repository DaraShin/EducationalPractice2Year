package com.epam.rd.autotasks.snail;

import java.util.Scanner;


public class Snail
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int up, down, height;
        up = scan.nextInt();
        down = scan.nextInt();
        height = scan.nextInt();

        if(up >= height){
            System.out.println(1);
            return;
        }

        if (up <= down){
            System.out.println("Impossible");
            return;
        }

        int days = (int)Math.ceil((double)(height - up) /(up - down));
        days++;
        System.out.println(days);
    }
}
