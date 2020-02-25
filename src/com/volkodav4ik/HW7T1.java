package com.volkodav4ik;

/*
Число Фибоначи
написать метод который возвращает N-ное число фибоначи, по правилу:
F(0) = 0, F(1) = 1
F(N) = F(N - 1) + F(N - 2)
*/

import java.math.BigInteger;
import java.util.Random;

public class HW7T1 {
    private static final Random RANDOM = new Random();
    private static final int MAX_VALUE_N = 90;
    private static final int MAX_VALUE_N_FOR_RECURSION = 35;

    public static void main(String[] args) {
        int n = RANDOM.nextInt(MAX_VALUE_N);
        if (n <= MAX_VALUE_N_FOR_RECURSION) {
            System.out.println("Fibonaccis " + n + " number is " + getFibonacciNumberViaRecursion(n));
        } else {
            System.out.println("Fibonaccis " + n + " number is " + getFibonacciNumberViaBigInteger(n));
        }
    }

    private static BigInteger getFibonacciNumberViaBigInteger(int n) {
        BigInteger actual = BigInteger.valueOf(1);
        BigInteger previous = BigInteger.valueOf(0);
        BigInteger next = BigInteger.valueOf(0);
        for (int i = 1; i < n; i++) {
            next = actual.add(previous);
            previous = actual;
            actual = next;
        }
        return next;
    }

    private static int getFibonacciNumberViaRecursion(int n) {
        if (n == 0) {
            return 0;
        } else {
            if (n == 1) {
                return 1;
            } else {
                return getFibonacciNumberViaRecursion(n - 1) + getFibonacciNumberViaRecursion(n - 2);
            }
        }
    }
}