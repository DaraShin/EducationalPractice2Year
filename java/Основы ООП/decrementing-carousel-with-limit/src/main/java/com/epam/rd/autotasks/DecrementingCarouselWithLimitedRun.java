package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    private int actionsLimit;
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionsLimit = actionLimit;
    }

    public int getActionsLimit(){
        return actionsLimit;
    }

}
