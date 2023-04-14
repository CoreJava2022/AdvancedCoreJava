package com.example;

import java.util.ArrayList;
import java.util.List;

public class GoodSets {
    public static List<List<Integer>> findGoodSets(int[] A, int k) {
        int n = A.length;
        List<List<Integer>> goodSets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> goodSet = new ArrayList<>();
            goodSet.add(i);
            for (int j = i + k; j < n; j++) {
                if (isGoodSet(goodSet, j, k)) {
                    goodSet.add(j);
                }
            }
            goodSets.add(goodSet);
        }
        return goodSets;
    }

    private static boolean isGoodSet(List<Integer> goodSet, int j, int k) {
        for (int i : goodSet) {
            if (Math.abs(i - j) < k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = {3,2,5,10,15};
        int k = 2;
        List<List<Integer>> goodSets = findGoodSets(A, k);
        for (List<Integer> goodSet : goodSets) {
            System.out.println(goodSet);
        }
    }
}
