/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.distribuidos.distribuidos;

/**
 *
 * @author faria
 */
public class PerfectAndAmicableSequential {

    public static boolean isPerfect(int num) {
        int sum = 1;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num && num != 1;
    }

    public static boolean isAmicable(int a, int b) {
        return sumOfDivisors(a) == b && sumOfDivisors(b) == a && a != b;
    }

    public static int sumOfDivisors(int num) {
        int sum = 1;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

}
