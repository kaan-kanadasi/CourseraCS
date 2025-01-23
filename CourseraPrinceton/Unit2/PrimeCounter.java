/**
* takes an integer command-line argument n and finds the number of primes less than or equal to n. 
* Use it to print out the number of primes less than or equal to 10 million.
* @author GPT3.5 
* @since 21 nov 2023
*/

public class PrimeCounter {
    public static boolean isPrime(int num) {
        if (num <= 1) { return false; }
        for (int i = 2; i <= Math.sqrt(num); i++) { 
        //.sqrt(num) = efficiency, örnek: [121 için 11'den sonraki sayılarak bakmak gereksiz]
            if (num % i == 0) { return false; }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // input
        int count = 0; // initializing count to 0

        for (int i = 2; i <= n; i++) {  // start at 2 since numbers before 2 are not prime
            if (isPrime(i)) { count++; }
        }  
        
        System.err.println(count);
    }
}