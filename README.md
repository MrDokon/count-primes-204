# Sieve of Eratosthenes solution

Find primes up to N
For all numbers a: from 2 to sqrt(n)
IF a is unmarked THEN a is prime
        for all multiples of a (a<n)
        mark multiples as composite
All unmarked numbers are prime!

### Java solution

```bash
# time complexity O(NLogLogN)
    public int countPrimes(int n) { 
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
```
