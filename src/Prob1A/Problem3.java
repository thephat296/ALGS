package Prob1A;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import Prob1B.Problem6;

public class Problem3 {

    public static void main(String[] args) {
        System.out.println(sumFound(List.of(1, 3, 9, 4, 8, 5), 21));
        System.out.println(sumFound(List.of(1, 3, 9, 4, 8, 5), 22));
        System.out.println(sumFound(List.of(1, 3, 9, 4, 8, 5), 31));
        System.out.println(sumFound(List.of(1, 3, 9, 4, 8, 5), 0));
    }

    /**
     * Problem 3. Given a list L = [s0, s1, . . ., sn−1] of n distinct positive integers and a non-negative
     * integer k, determine whether there is a subset of arr the sum of whose values is k. Do this by
     * implementing the following Java method.
     * <p>
     * Hint. Use a solution to Problem 6 as part of your solution to this problem. A solution in the
     * form of a jar file is provided for you so that you can try using it here even if you do not have
     * your own solution to Problem 6.
     * Also, solve the problem when L is allowed to have duplicates. For instance, if L = [4, 5, 3, 8, 3]
     * and k = 6, your Java method should return true since 3 + 3 = 6 and there are two occurrences of
     * 3 in L (however, if L = [4, 5, 3, 8], the Java method should return false since the single occurrence
     * of 3 in L in this case cannot be counted twice).
     * Examples
     * (A) If input is [1, 3, 9, 4, 8, 5] and k = 21, return true (since 9 + 4 + 8 = 21)
     * (B) If input is [1, 3, 9, 4, 8, 5] and k = 22, return true (since 1 + 9 + 4 + 8 = 22)
     * (C) If input is [1, 3, 9, 4, 8, 5] and k = 31, return false (since even the sum of all elements of
     * arr is less than 31)
     * (D) If input is [1, 3, 9, 4, 8, 5] and k = 0, return true (since the sum of the empty subarray is 0)
     */
    public static boolean sumFound(List<Integer> list, int k) {
        // implement
        List<Set<Integer>> setList = Problem6.powerSet(new ArrayList<>(list));
        for (Set<Integer> set : setList) {
            int total = k;
            for (int num : set) {
                total -= num;
            }
            if (total == 0) {
                return true;
            }
        }
        return false;
    }
}
