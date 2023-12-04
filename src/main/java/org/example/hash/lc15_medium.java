package org.example.hash;

import java.util.*;

public class lc15_medium {
    // Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    // Notice that the solution set must not contain duplicate triplets.
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        for (List<Integer> integers : threeSum2Pointers1204(nums)) {
        }

    }

    public static List<List<Integer>> threeSum2Pointers1204(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // sort the arrays from small to large
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) { // if the smallest number is bigger than 0, then no way the sum will be 0. and no need for next loop because the first number will only get bigger
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) { // if this element is the same as the one from last loop, then no need to do this loop, because we need to deduplicate for the result triplets
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right])); // put into result list
                    while (left < right && nums[left] == nums[left + 1]) { // deduplicate for the second element
                        // remember to add the condition (left<right) because it can keep moving until out of bounds for length
                        left++;
                    }
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++; // don't stop if a triplet found in a loop, there may be a chance we have more in one loop.
                    right--;
                }
                if (sum > 0) {
                    right--;
                }
                if (sum < 0) {
                    left++;
                }
            }
        }
        return result;
    }
    public static List<List<Integer>> threeSumHash(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) { // first loop to determine a
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // deduplicate
            }
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) { // second loop to determine b
                if (j > 2 && nums[j] == nums[j - 1] && nums[j - 1] == nums[j - 2]) {
                    continue; // deduplicate
                }
                int c = 0 - (nums[i] + nums[j]);
                if (set.contains(c)) {
                    result.add(Arrays.asList(nums[i], nums[j], c));
                    set.remove(c);
                } else {
                    set.add(nums[j]); // use set to store elements that already pass but was not included in any triplet
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum2Pointers(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }

}
