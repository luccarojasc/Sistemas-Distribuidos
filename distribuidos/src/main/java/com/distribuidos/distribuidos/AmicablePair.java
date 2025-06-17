package com.distribuidos.distribuidos;

/**
 * Representa um par de números amigáveis.
 */
public record AmicablePair(long number1, long number2) {
    @Override
    public String toString() {
        return "(" + number1 + ", " + number2 + ")";
    }
}