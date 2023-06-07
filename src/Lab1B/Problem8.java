package Lab1B;

public class Problem8 {

    public static void main(String[] args) {
        System.out.println(smallestCommon(4, 6));
        System.out.println(smallestCommon(3, 5));
        System.out.println(smallestCommon(7, 14));
    }

    /**
     * Problem 8. Given two positive integers x, y, find the smallest positive integer z with the property
     * that both x and y are factors of z.
     * Examples
     * (A) If input is 4, 6, return 12.
     * (B) If input is 3, 5, return 15.
     * (C) If input is 7, 14, return 14
     */
    public static int smallestCommon(int x, int y) {
        // implement
        return x * y / findGCD(x, y);
    }

    private static int findGCD(int x, int y) {
        if (x < y) return findGCD(y, x);
        if (x % y == 0) return y;
        return findGCD(y, x % y);
    }
}
