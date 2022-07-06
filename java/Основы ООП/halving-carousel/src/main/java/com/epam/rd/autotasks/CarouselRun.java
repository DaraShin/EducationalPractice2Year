package com.epam.rd.autotasks;

import java.util.Arrays;

public class CarouselRun {
    private DecrementingCarousel carousel;
    private int currentElement;
    private int[] nextNotZeroElement;
    private boolean isEmpty = false;

    public CarouselRun(DecrementingCarousel carousel) {
        this.carousel = carousel;

        if(carousel.getCurrentNumberOfElements() == 0){
            isEmpty = true;
            return;
        }

        nextNotZeroElement = new int[carousel.getCurrentNumberOfElements()];
        for (int i = 0; i <= carousel.getCurrentNumberOfElements() - 2; i++) {
            nextNotZeroElement[i] = i + 1;
        }
        nextNotZeroElement[carousel.getCurrentNumberOfElements() - 1] = 0;
        currentElement = 0;
    }

    public int next() {
        if (isEmpty) {
            return -1;
        }

        int nextResult = carousel.decreaseElement(currentElement);

        if (nextResult == 1) {

            if (nextNotZeroElement[currentElement] == currentElement) {
                Arrays.fill(nextNotZeroElement, -1);
                isEmpty = true;
                return nextResult;
            }

            int idx = currentElement - 1;
            if (currentElement != 0) {
                while (idx >= 0 && nextNotZeroElement[idx] == currentElement) {
                    nextNotZeroElement[idx] = nextNotZeroElement[currentElement];
                    idx--;
                }
            }

            if (idx < 0) {
                idx = carousel.getCurrentNumberOfElements() - 1;
                while (idx >= nextNotZeroElement[currentElement] && nextNotZeroElement[idx] == currentElement) {
                    nextNotZeroElement[idx] = nextNotZeroElement[currentElement];
                    idx--;
                }
            }
        }
        currentElement = nextNotZeroElement[currentElement];
        return nextResult;
    }

    public boolean isFinished() {
        return isEmpty;
    }

}
