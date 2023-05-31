package Prob1B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import lab1.powerset.PowerSet;
public class Problem6 {
    public static void main(String[] args) {
        System.out.println(powerSet(List.of(1)));
        System.out.println(powerSet(Arrays.asList(1, 2)));
    }

    /**
     * Problem 6. Given a List L without duplicate elements, return another list that consists of all
     * subsets of L (without duplicates). Use the following method signature:
     * Examples
     * (A) If input is {1}, output should be [{}, {1}].
     * (B) If input is {1, 2}, output should be [{}, {1}, {2}, {1, 2}].
     */
    public static List<Set> powerSet(List list) {
        // implement
        return PowerSet.powerSet(new ArrayList<>(list));
    }
}
