package Prob1B;

import java.util.*;

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
    public static List<Set<Integer>> powerSet(List<Integer> list) {
        // implement
        List<Set<Integer>> subsets = new ArrayList<>();
        subsets.add(new HashSet<>());
        for (int num : list) {
            int subsetsSize = subsets.size();
            for (int j = 0; j < subsetsSize; j++) {
                Set<Integer> subset = new HashSet<>(subsets.get(j));
                subset.add(num);
                subsets.add(subset);
            }
        }
        return subsets;
    }
}
