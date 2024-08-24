package org.example;

class Solution {

    // explanation - line:58
    public int countPrimes(int n) { // time complexity O(NLogLogN)
        if (n <= 2) return 0;
        boolean[] prime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i+=p) {
                    prime[i] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i]) count++;
        }
        return count;
    }

    // why this solution is bad?
    // Let's write down the divisors of the number 36 = {1, 2, 3, 4, 6, 9, 12, 18, 36}
    // if it's divided by 3, it is also divided by 6, if it's divided by 2 it is also divided by 18 etc.
    // We don't need to check each number. These numbers have PAIRS (SQUARES).
    // THE SQUARE ROOT OF A NUMBER IS THE NUMBER THAT WE MULTIPLY BY ITSELF TO GET THE NUMBER
    // WE DON'T NEED TO CHECK FROM 2->n, WE CAN check from 2->SQUARE ROOT OF N
    private boolean isPrimeSLOW(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // it is way waster, but sieve of Eratosthenes is better
    private boolean isPrimeBoosted(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < (int) Math.sqrt(n) + 1; i++) {
            if ( n % i == 0) return false;
        }
        return true;
    }

    /*
    provided solution - sieve of Eratosthenes
    find primes up to N
    For all numbers a: from 2 to sqrt(n)
    IF a is unmarked THEN
        a is prime
        for all multiples of a (a<n)
        mark multiples as composite
    All unmarked numbers are prime!
     */
    private boolean[] isPrime(int n) {
        // create a boolean array and initialize all entries as true
        // a value in prime[i] will finally be false if i is Not a prime, else true.
        boolean[] prime = new boolean[n + 1];
        prime[0] = false;
        prime[1] = false;
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }
        //mark multiples as composite
        for (int p = 2; p * p <= n; p++) {
            //if prime is not changed, then it is a prime
            if (prime[p]) { // prime[p] -> prime[p] == true
                //update all multiples of p
                for (int i = p * p; i <= n; i+=p) {
                    prime[i] = false;
                }
            }
        }
        return prime;
    }

}
// - also interesting: sieve of Atkin https://www.geeksforgeeks.org/sieve-of-atkin/






