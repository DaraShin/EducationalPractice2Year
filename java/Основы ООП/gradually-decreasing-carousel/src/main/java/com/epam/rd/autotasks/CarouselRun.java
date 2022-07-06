package com.epam.rd.autotasks;

import java.util.Arrays;

public class CarouselRun {
    private DecrementingCarousel carousel;
    private int currentElement;
    private int[] nextPositiveElement;
    private boolean isEmpty = false;

    public CarouselRun(DecrementingCarousel carousel) {
        this.carousel = carousel;

        if(carousel.getCurrentNumberOfElements() == 0){
            isEmpty = true;
            return;
        }

        nextPositiveElement = new int[carousel.getCurrentNumberOfElements()];
        for (int i = 0; i <= carousel.getCurrentNumberOfElements() - 2; i++) {
            nextPositiveElement[i] = i + 1;
        }
        nextPositiveElement[carousel.getCurrentNumberOfElements() - 1] = 0;
        currentElement = 0;
    }

    public int next() {
        if (isEmpty) {
            return -1;
        }

        int nextResult = carousel.decreaseElement(currentElement);

        if (carousel.getElement(currentElement) <= 0) {

            if (nextPositiveElement[currentElement] == currentElement) {
                Arrays.fill(nextPositiveElement, -1);
                isEmpty = true;
                return nextResult;
            }

            int idx = currentElement - 1;
            if (currentElement != 0) {
                while (idx >= 0 && nextPositiveElement[idx] == currentElement) {
                    nextPositiveElement[idx] = nextPositiveElement[currentElement];
                    idx--;
                }
            }

            if (idx < 0) {
                idx = carousel.getCurrentNumberOfElements() - 1;
                while (idx >= nextPositiveElement[currentElement] && nextPositiveElement[idx] == currentElement) {
                    nextPositiveElement[idx] = nextPositiveElement[currentElement];
                    idx--;
                }
            }
        }
        currentElement = nextPositiveElement[currentElement];
        return nextResult;
    }

    public boolean isFinished() {
        return isEmpty;
    }

}
