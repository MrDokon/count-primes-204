package org.example;

class Solution {

    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int counter = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimeNumber(i)) counter++;
        }
        return counter;
    }

    public boolean isPrimeNumber(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0 ) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(3));
    }

}