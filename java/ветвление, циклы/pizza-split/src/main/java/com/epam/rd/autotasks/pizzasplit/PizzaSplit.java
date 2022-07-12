package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static int gcd(int a, int b) {
        int temp;
        if (b > a) {
            temp = a;
            a = b;
            b = temp;
        }
        while (b != 0){
           temp = b;
           b = a % b;
           a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int people = scan.nextInt();
        int pieceOfPizza = scan.nextInt();
        System.out.println(people * pieceOfPizza / gcd(people, pieceOfPizza) / pieceOfPizza);
    }
}
