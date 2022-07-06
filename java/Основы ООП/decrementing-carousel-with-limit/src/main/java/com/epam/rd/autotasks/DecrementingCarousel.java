package com.epam.rd.autotasks;

import java.util.Arrays;

public class DecrementingCarousel {
    private int[] elements;
    private int currentNumberOfElements = 0;
    private boolean isRunning = false;

    public DecrementingCarousel(int capacity) {
        elements = new int[capacity];
    }

    public int getCurrentNumberOfElements() {
        return currentNumberOfElements;
    }

    public boolean addElement(int element) {
        if (currentNumberOfElements == elements.length) {
            return false;
        }

        if (isRunning) {
            return false;
        }

        if (element <= 0) {
            return false;
        }

        elements[currentNumberOfElements] = element;
        currentNumberOfElements++;
        return true;
    }

    public CarouselRun run () {
        if (isRunning) {
            return null;
        }

        isRunning = true;
        return new CarouselRun(this);
    }

    public int decreaseElement ( int idx){
        if (idx >= currentNumberOfElements) {
            return -1;
        }

        if (elements[idx] == 0) {
            return -1;
        }

        int prevValue = elements[idx];
        elements[idx]--;
        return prevValue;
    }
}
