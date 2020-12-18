package com.java.generics;

//solution : N extends Number, N extends Integer
public class MinMax<N extends Number> {

    private N min;
    private N max;

    public N getMin() {
        return min;
    }

    public N getMax() {
        return max;
    }

    public void add(N added) {
        if (min == null || added.doubleValue() < min.doubleValue()) {
            min = added;
        }
        if (max == null || added.doubleValue() > max.doubleValue()) {
            max = added;
        }
    }
}
