package Lab3A;

import static Lab3A.Problem2.isPrime;

public class Problem3 {

    public static void main(String[] args) {
        System.out.println(sol(4, 7));
        System.out.println(sol(28, 28));
    }

    public static boolean sol(int m, int n) {
        int gcd = gcd(m, n);
        while (gcd % 2 == 0) {
            gcd /= 2;
        }
        return isPrime(gcd);
    }

    private static int gcd(int m, int n) {
        if (m < n) return gcd(n, m);
        if (n == 0) return m;
        return gcd(n, m % n);
    }
}
