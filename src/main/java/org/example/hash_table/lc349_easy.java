package org.example.hash_table;

import java.util.*;

public class lc349_easy {
    // Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must
    // be unique and you may return the result in any order.
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] result = solutionUsingHashSet(nums1, nums2);
        for (int x : result) {
            System.out.println(x);
        }
    }

    private static int[] solutionUsingHashArray(int[] nums1, int[] nums2) {
        int[] hashArray = new int[1001];
        int[] hashArray2 = new int[1001];
        for (int x : nums1) {
            hashArray[x]++;
        }
        for (int x : nums2) {
            hashArray2[x]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] > 0 && hashArray2[i] > 0) {
                list.add(i);
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }


    private static int[] solutionUsingHashSet(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int x : nums1) {
            set.add(x);
        }
        for (int x : nums2) {
            if (set.contains(x)) {
                set2.add(x);
            }
        }
//        return set2.stream().mapToInt(x -> x).toArray(); // also work
        int[] result = new int[set2.size()];
        int count = 0;
        for (int x : set2) {
            result[count] = x;
            count++;
        }
        return result;
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        int[] record = new int[1001];
        int count = 0;
        for (int x : nums1) {
            if (record[x] == 0) {
                record[x]++;
                count++;
            }
        }
        count = 0;
        int[] recordCopy = Arrays.copyOf(record, record.length);
        for (int x : nums2) {
            if (recordCopy[x] > 0) {
                count++;
                recordCopy[x] = 0;
            }
        }
        int[] result = new int[count];
        count = 0;
        for (int x : nums2) {
            if (record[x] > 0) {
                result[count] = x;
                count++;
                record[x] = 0;
            }
        }
        return result;
    }
}
