package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int numberOfSummands = 0;
        int summand = scanner.nextInt();

        while (summand != 0) {
            sum += summand;
            numberOfSummands++;
            summand = scanner.nextInt();
        }

        System.out.println(sum / numberOfSummands);
    }

}