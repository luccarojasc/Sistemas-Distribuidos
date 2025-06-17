package com.distribuidos.distribuidos;

import java.util.ArrayList;
import java.util.List;

public class PartialResult {
    private final List<Long> perfectNumbersFound = new ArrayList<>();
    private final List<AmicablePair> amicablePairsFound = new ArrayList<>();

    public List<Long> getPerfectNumbersFound() {
        return perfectNumbersFound;
    }

    public List<AmicablePair> getAmicablePairsFound() {
        return amicablePairsFound;
    }

    public void addPerfectNumber(long n) {
        this.perfectNumbersFound.add(n);
    }

    public void addAmicablePair(AmicablePair pair) {
        this.amicablePairsFound.add(pair);
    }
}