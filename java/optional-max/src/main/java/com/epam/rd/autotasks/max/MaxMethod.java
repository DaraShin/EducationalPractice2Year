package com.epam.rd.autotasks.max;

import java.util.Optional;
import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        if(values == null || values.length == 0){
            return OptionalInt.empty();
        }

        int maxElement = values[0];
        for(int element: values){
            if(element > maxElement){
                maxElement = element;
            }
        }
        return OptionalInt.of(maxElement);
    }
}
