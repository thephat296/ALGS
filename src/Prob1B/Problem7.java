package Prob1B;

public class Problem7 {

    public static void main(String[] args) {
        System.out.println(generate(3));
        System.out.println(generate(4));
        System.out.println(generate(5));
    }

    /**
     * Problem 7. Write a Java method that generates the following sequence of numbers:
     * a = h0, 1, 1, 2, 3, 5, 8, . . .i.
     * The pattern is generated by the following formula:
     * a0 = 0; a1 = 1 an = an−1 + an−2.
     */
    public static int generate(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        // implement
        return generate(n - 1) + generate(n - 2);
    }
}