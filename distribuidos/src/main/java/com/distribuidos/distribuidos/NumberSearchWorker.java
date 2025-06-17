package com.distribuidos.distribuidos;

import java.util.concurrent.Callable;

/**
 * Tarefa que busca números perfeitos e amigáveis em um subintervalo numérico.
 */
public class NumberSearchWorker implements Callable<PartialResult> {
    private final long start;
    private final long end;

    public NumberSearchWorker(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public PartialResult call() {
        PartialResult partialResult = new PartialResult();
        for (long i = start; i <= end; i++) {
            if (PerfectAndAmicableSequential.isPerfect((int) i)) {
                partialResult.addPerfectNumber(i);
            }

            int partner = PerfectAndAmicableSequential.sumOfDivisors((int) i);
            if (i < partner && PerfectAndAmicableSequential.isAmicable((int) i, partner)) {
                partialResult.addAmicablePair(new AmicablePair(i, partner));
            }
        }
        return partialResult;
    }
}