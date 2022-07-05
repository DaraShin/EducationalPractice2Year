package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if(array == null || array.length == 0){
            return;
        }

        int lastElem = array[array.length - 1];
        System.arraycopy(array, 0, array, 1, array.length - 1);
        array[0] = lastElem;
    }

    static void cycleSwap(int[] array, int shift) {
        if(array == null || array.length == 0){
            return;
        }

        int[] suffixCopy = new int [shift];
        System.arraycopy( array, array.length - shift,suffixCopy, 0, shift);
        System.arraycopy(array, 0, array, shift, array.length - shift);
        System.arraycopy(suffixCopy, 0, array, 0, shift);
    }
}
