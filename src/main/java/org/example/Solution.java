package org.example;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(5000000));
    }


    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int counter = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimeBoosted(i)) counter++;
        }
        return counter;
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

// it is way waster, but there might be a better solution -> sieve of Eratosthenes
    private boolean isPrimeBoosted(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < (int) Math.sqrt(n) + 1; i++) {
            if ( n % i == 0) return false;
        }
        return true;
    }

// solutions:
// - sieve of Eratosthenes - EASIER
// - sieve of Atkin https://www.geeksforgeeks.org/sieve-of-atkin/ - MOST EFFICIENT


}




