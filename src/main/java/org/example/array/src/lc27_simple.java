package org.example.array.src;

import java.util.ArrayList;
import java.util.Arrays;

// 要求删除数组中等于val的元素
// require in-place algorithm: meaning modifying the input in place, without creating a separate copy of the data structure.在原数组上进行修改
public class lc27_simple {
    static int[] nums = {3, 2, 2, 3};

    public static void main(String[] args) {
        int val = 3;
        int answer = solution1(val);
        System.out.println(answer);
        System.out.println(Arrays.toString(nums));
    }


    // 暴力解法，时间复杂度：O(n^2)
    public static int solution1(int val) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) { // 发现需要移除的元素，就将数组中下标为i+1及以后的数字，集体向前移动一位
                for (int j = i + 1; j < length; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                length--;
            }
        }
        return length;
    }

    // 双指针法（快慢指针法）
    // 快指针用来判断数字是否等于val，慢指针用来重构修改数组
    public static int solution2(int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (val != nums[fastIndex]) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    // 相向双指针法，基于元素顺序可以改变的题目描述，改变了元素相对位置，确保了移动最少元素
    public static int solution3(int val) {
        int leftIndex = 0; // 最左元素的下标
        int rightIndex = nums.length - 1; // 最右元素的下标
        while (leftIndex <= rightIndex) { // 左指针还没有超过右指针
            while (leftIndex <= rightIndex && nums[leftIndex] != val) {
                // 当左指针还没有超过右指针，且左指针对应的元素不等于val，左指针往前（右）移动1，即不用修改不等于val的元素
                // 而当左指针对应的元素等于val，即该元素需要被删除时，跳出本while循环，进入下面的循环移动右指针
                ++leftIndex;
            }
            while (leftIndex <= rightIndex && nums[rightIndex] == val) {
                --rightIndex;
                // 当左指针还没有超过右指针，且右指针对应的元素等于val，右指针往后（左）移动1，即不用处理等于val的元素
                // 而当右指针对应的元素不等于val，即该元素需要替换左指针对应的元素，跳出本while循环
            }
            if (leftIndex < rightIndex) {
                nums[leftIndex] = nums[rightIndex];
                // 把右指针对应的需要保留的元素，替换左指针对应的需要剔除的元素，然后左右指针都继续移动，
                // 直到左指针超越右指针，即数组所有元素以被检验过，并把须保留的全部放在数组的前(leftIndex+1)个里
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }
}
