package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] spiralArray = new int[rows][columns];
        int curNumber = 1;
        int curRow = -1;
        int curColumn = -1;
        while (curNumber <= rows * columns) {
            //move right
            curRow++;
            int column = curColumn;
            curColumn++;
            while (curColumn < columns - column - 1) {
                spiralArray[curRow][curColumn] = curNumber;
                curColumn++;
                curNumber++;
            }
            if(curNumber > rows * columns){
                return spiralArray;
            }

            //move down
            curColumn--;
            int row = curRow;
            curRow++;
            while(curRow < rows - row ){
                spiralArray[curRow][curColumn] = curNumber;
                curRow++;
                curNumber++;
            }
            if(curNumber > rows * columns){
                return spiralArray;
            }

            //move left
            curRow--;
            column = curColumn;
            curColumn--;
            while (curColumn > columns - column - 2) {
                spiralArray[curRow][curColumn] = curNumber;
                curColumn--;
                curNumber++;
            }
            if(curNumber > rows * columns){
                return spiralArray;
            }

            //move up
            curColumn++;
            row = curRow;
            curRow--;
            while(curRow > rows - row - 1){
                spiralArray[curRow][curColumn] = curNumber;
                curRow--;
                curNumber++;
            }
            if(curNumber > rows * columns){
                return spiralArray;
            }
        }
        return spiralArray;
    }
}
