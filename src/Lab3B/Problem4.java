package Lab3B;

public class Problem4 {

    public static void main(String[] args) {
        System.out.println(iterativeFib(5));
        System.out.println(recursiveCacheFib(5, new int[6]));
    }

    public static int iterativeFib(int n) {
        if (n <= 1) return n;
        int f1 = 0, f2 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = f1;
            f1 = f2;
            f2 = temp + f1;
        }
        return f2;
    }

    public static int recursiveCacheFib(int n, int[] cache) {
        if (n <= 1) {
            cache[n] = n;
        } else {
            cache[n] = recursiveCacheFib(n - 1, cache) + recursiveCacheFib(n - 2, cache);
        }
        return cache[n];
    }
}
