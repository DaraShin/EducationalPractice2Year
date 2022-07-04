package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int strangersNum = scan.nextInt();
        scan.nextLine();

        if (strangersNum < 0){
            System.out.println("Seriously? Why so negative?");
            return;
        }

        if (strangersNum == 0){
            System.out.println("Oh, it looks like there is no one here");
            return;
        }

        String name;
        for(int i = 0; i < strangersNum; i++){
            name = scan.nextLine();
            System.out.println("Hello, " + name);
        }
    }
}
