package com.bootstrappers.backend;

import java.util.Comparator;

class MyComparator implements Comparator<Home> {
    public int compare(Home x, Home y) {
        if (x.getPrice() < y.getPrice()) {
            return -1;
        }
        if (x.getPrice() > y.getPrice()) {
            return 1;
        }
        return 0;
    }
}