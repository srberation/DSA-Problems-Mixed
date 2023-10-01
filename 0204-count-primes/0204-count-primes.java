// class Solution {
//     public int countPrimes(int n) {
//         int count = 0; 
//         for(int i = 0; i<n;i++){
//             if(isPrime(i)) count++;
//         }
//         return count;
//     }

//     public static boolean isPrime(int number) {
//         if (number <= 1) {
//             return false; // 0 and 1 are not prime numbers
//         }

//         // Check for divisibility from 2 to the square root of the number
//         for (int i = 2; i * i <= number; i++) {
//             if (number % i == 0) {
//                 return false; // If the number is divisible, it's not prime
//             }
//         }

//         return true; // If no divisors were found, it's prime
//     }
// }

public class Solution {
    public int countPrimes(int n) {

        if(n<2) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i*i<n;i++){
            if(isPrime[i]){
                for(int j =i*i; j<n; j=j+i) isPrime[j] = false; // mark all the multiples of i as false
            }
        }

        int count=0;
        for(boolean prime: isPrime){
            if(prime) count++;
        }

        return count;
    }
}
