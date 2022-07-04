package com.epam.rd.autotasks.sequence;
import java.util.Scanner;
import static java.lang.Integer.*;

public class FindMaxInSeq {
    public static int max() {

        Scanner scan = new Scanner(System.in);

        int nextNumber;
        int maxNumber = MIN_VALUE;

        while(true){
            nextNumber = scan.nextInt();
            if (nextNumber == 0 ){
                break;
            }
            if(nextNumber > maxNumber){
                maxNumber = nextNumber;
            }
        }

        return maxNumber;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
