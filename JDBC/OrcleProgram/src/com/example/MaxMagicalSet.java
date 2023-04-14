package com.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class MaxMagicalSet {
    public static List<Integer> findMaxMagicalSet(int[] A, int k) {
        int n = A.length;
        List<Integer> maxMagicalSet = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> goodSet = new ArrayList<>();
            goodSet.add(i);
            for (int j = i + k; j < n; j++) {
                if (isGoodSet(goodSet, j, k)) {
                    goodSet.add(j);
                }
            }
            List<Integer> magicalSet = new ArrayList<>();
            for (int x : goodSet) {
                magicalSet.add(A[x]);
            }
            Collections.sort(magicalSet);
            boolean isMagical = true;
            for (int x = 0; x < magicalSet.size() - 1; x++) {
                if (magicalSet.get(x) > magicalSet.get(x + 1)) {
                    isMagical = false;
                    break;
                }
            }
            if (isMagical) {
                if (magicalSet.size() > maxMagicalSet.size()) {
                    maxMagicalSet = magicalSet;
                }
            }
        }
        return maxMagicalSet;
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
        int[] A = {1, 2, 3, 4, 5};
        int k = 2;
        List<Integer> maxMagicalSet = findMaxMagicalSet(A, k);
        int[] arr = new int[maxMagicalSet.size()];
        for(int i = 0; i < maxMagicalSet.size(); i++) {
            arr[i] = maxMagicalSet.get(i);
        }
        System.out.println("The maximum magical set is: " + Arrays.toString(arr));
    }
}