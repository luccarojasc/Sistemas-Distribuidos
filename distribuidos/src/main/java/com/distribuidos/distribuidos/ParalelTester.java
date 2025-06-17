// Arquivo: ParalelTester.java (Corrigido)
package com.distribuidos.distribuidos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParalelTester {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final long INTERVALO_MAX = 1000000;
        final int NUM_THREADS = 8;

        System.out.println("--- VERSÃO PARALELA ---");
        System.out.println("---------------------------------------------------------");
        
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        List<Callable<PartialResult>> tasks = new ArrayList<>();
        
        long chunkSize = INTERVALO_MAX / NUM_THREADS;
        long start = 1;
        for (int i = 0; i < NUM_THREADS; i++) {
            long end = (i == NUM_THREADS - 1) ? INTERVALO_MAX : start + chunkSize - 1;
            tasks.add(new NumberSearchWorker(start, end));
            System.out.println("Thread criada para o intervalo: [" + start + ", " + end + "]");
            start += chunkSize;
        }

        long startTime = System.currentTimeMillis();
        List<Future<PartialResult>> futureResults = executor.invokeAll(tasks);
        List<Long> totalPerfectNumbers = new ArrayList<>();
        List<AmicablePair> totalAmicablePairs = new ArrayList<>();

        for (Future<PartialResult> future : futureResults) {
            PartialResult partialResult = future.get();
            totalPerfectNumbers.addAll(partialResult.getPerfectNumbersFound());
            totalAmicablePairs.addAll(partialResult.getAmicablePairsFound());
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        executor.shutdown();

        System.out.println("---------------------------------------------------------");
        System.out.println("Busca finalizada.");
        System.out.println("\nIntervalo,Tempo (ms),Perfeitos Encontrados,Pares Amigáveis");
        System.out.printf("%d,%d,%d,%d\n", INTERVALO_MAX, totalTime, totalPerfectNumbers.size(), totalAmicablePairs.size());
        
        System.out.println("\nNúmeros Perfeitos encontrados: " + totalPerfectNumbers);
        System.out.println("Pares Amigáveis encontrados: " + totalAmicablePairs);
    }
}