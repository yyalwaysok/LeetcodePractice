package org.example.hash_table;

import java.util.HashMap;
import java.util.Map;

public class lc1_easy {
    // Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    // You may assume that each input would have exactly one solution, and you may not use the same element twice.

    // You can return the answer in any order.
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    // why use hash table => because we have to quickly see if a number exist before, if so, then we don't check on that number again
    // why use map => because we have to verify the value of the number, and return its index, which means we have store both the value and the index of a number, so we use key and value to store
    // what's the map use for => store the elements that have been checked
    // what's the key and value use for => key for value and value for index
    public static int[] twoSum(int[] nums, int target) {
        Map map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Object o = map.get(target - nums[i]);
            if (o != null) {
                return new int[]{i, (Integer) o};
            } else {
                map.put(nums[i], i);
            }

        }
        return null;
    }

    public static int[] twoSum0(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
