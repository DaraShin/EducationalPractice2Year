package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static int max(int[] values) {
        int maxElem = values[0];
        for(int elem: values){
            if(elem > maxElem){
                maxElem = elem;
            }
        }
        return maxElem;
    }
}
