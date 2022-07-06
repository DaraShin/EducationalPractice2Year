package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public int decreaseElement ( int idx){
        if (idx >= getCurrentNumberOfElements()) {
            return -1;
        }

        if (elements[idx] == 0) {
            return -1;
        }

        int prevValue = elements[idx];
        elements[idx] = elements[idx]  / 2;
        return prevValue;
    }
}

