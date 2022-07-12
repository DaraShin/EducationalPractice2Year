package com.epam.rd.autotasks;

public class Main {
    public static void main(String[] args) {
        int[][] spiral = Spiral.spiral(1, 2);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(spiral[i][j] + " ");
            }
            System.out.println();
        }
    }
}
