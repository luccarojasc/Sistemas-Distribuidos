/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.distribuidos.distribuidos;

/**
 *
 * @author faria
 */
public class BatchTester {

    public static void main(String[] args) {
        int[] intervals = {10000, 100000, 1000000};

        System.out.println("Intervalo,Tempo (ms),Perfeitos Encontrados,Pares Amigáveis");

        for (int end : intervals) {
            long startTime = System.currentTimeMillis();

            int perfectCount = 0;
            int amicableCount = 0;

            for (int i = 1; i <= end; i++) {
                if (PerfectAndAmicableSequential.isPerfect(i)) {
                    perfectCount++;
                }
            }

            for (int i = 1; i <= end; i++) {
                int j = PerfectAndAmicableSequential.sumOfDivisors(i);
                if (j > i && PerfectAndAmicableSequential.isAmicable(i, j)) {
                    amicableCount++;
                }
            }

            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            System.out.printf("%d,%d,%d,%d%n", end, duration, perfectCount, amicableCount);
        }
    }
}
