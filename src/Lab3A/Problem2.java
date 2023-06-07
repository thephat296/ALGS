package Lab3A;

public class Problem2 {
    public static void main(String[] args) {
        System.out.println(isPrime(7));
    }

    /**
     * In term of value: T(n) = O(n)
     * In term of size: T(b) = O(2 ^ b)
     */
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
