package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        //int[] array = new int[]{18, 1, 3, 6, 7, -5};
        int[] array = new int[]{-18, 21, 3, 6, 7, 65};
        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){
        int[] arrayWithoutMaxs = new int [array.length];
        int curIdx = 0;

        if(array[0] <= array[1]){
            arrayWithoutMaxs[curIdx] = array[0];
            curIdx++;
        }
        for(int i = 1; i < array.length - 1; i++){
            if(array[i] > array[i-1] && array[i] > array[i+1]){
                continue;
            }
            arrayWithoutMaxs[curIdx] = array[i];
            curIdx++;
        }
        if(array[array.length - 1] <= array[array.length - 2]){
            arrayWithoutMaxs[curIdx] = array[array.length - 1];
            curIdx++;
        }

        arrayWithoutMaxs = Arrays.copyOf(arrayWithoutMaxs, curIdx);

        return arrayWithoutMaxs;
    }
}
