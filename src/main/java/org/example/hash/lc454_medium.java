package org.example.hash;

import java.util.HashMap;
import java.util.Map;

public class lc454_medium {
    // tuples: a collection or group of values in a specific order.
    // HashMap.getOrDefault(key, default value)
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{-2, -1};
        int[] nums3 = new int[]{-1, 2};
        int[] nums4 = new int[]{0, 2};
        int i = fourSumCount2(nums1, nums2, nums3, nums4);
        System.out.println(i);
    }

    // Time Limit Exceeded
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                for (int k = 0; k < nums3.length; k++) {
                    for (int l = 0; l < nums4.length; l++) {
                        if (nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int c : nums3) {
            for (int d : nums4) {
//                int sum = c + d;
//                if (map.containsKey(0 - sum)) {
//                    result += map.get(0 - sum);
//                }
                result += map.getOrDefault(0 - c - d, 0);
            }
        }
        return result;
    }
}
