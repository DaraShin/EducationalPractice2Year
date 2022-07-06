package com.epam.rd.autotasks;

import java.util.Arrays;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    private int[] decreaseValue;
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
        decreaseValue = new int[capacity];
        Arrays.fill(decreaseValue, 1);
    }

    public int decreaseElement (int idx){
        if (idx >= getCurrentNumberOfElements()) {
            return -1;
        }

        if (elements[idx] <= 0) {
            return -1;
        }

        int prevValue = elements[idx];
        elements[idx] -= decreaseValue[idx];
        decreaseValue[idx]++;
        return prevValue;
    }
}
