package org.example.array.src;

import java.util.Arrays;

public class lc704_simple {
    // 给定一个 n 个元素有序的（升序）且无重复元素的整型数组 nums 和一个目标值 target  ，
    // 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 4, 5, 9, 12};
        int target = 6;
        System.out.println(solution3(nums, target));
    }

    // 暴力解法
    public static int solution1(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE; // 先对ans赋最大的值
        int[] sums = new int[n + 1]; // sums数组用于储存计算出来的和
        // sums[0] = 前 0 个元素的前缀和 = 0
        // sums[1] = 前 1 个元素的前缀和 = A[0]
        // size=n+1是为了把
        // 为了方便计算，令 size =2 n + 1
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int s = target + sums[i - 1];
            int bound = Arrays.binarySearch(sums, s);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static int solution2(int[] nums, int target) { // 定义 target 是在一个在左闭右闭的区间里，也就是[left, right]
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) { // 对于nums不存在target的情况，假如数组有单数个成员，
            // 那么最后会收窄至left=right，再经过一轮比对后，left+1，这时left>right，while循环结束

            // 数组有双数个成员时也类似，倒数第三次循环，收窄至right=left+1，而mid因为int形式，取值=right，
            // 经过if检验后left+1，下一轮while循环中left=right，与上述单数个成员的程序执行一致
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1; // 这里不是right=mid是因为已经比对了mid是否==target，mid不是目标
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static int solution3(int[] nums, int target) { // 定义 target 是在一个在左闭右开的区间里，即：[left, right)
        int left = 0;
        int right = nums.length; // 这时right不用-1
        while (left < right) { // 因为left == right的时候，在[left, right)是无效的空间，所以使用 <
            int mid = left + ((right - left) >> 1); // >> 是位右移操作符。它用于将一个数的二进制位向右移动指定的位数。
            // 对于表达式 A >> B，其中 A 是要右移的数，B 是要右移的位数。
            // ((right - left) >> 1) 的作用是计算 (right - left) 的一半。通过右移操作将 (right - left) 的结果向右移动一位，相当于将其除以 2（向下取整）。
            // 在数字没有溢出的前提下，对于正数和负数，左移一位都相当于乘以2的1次方，左移n位就相当于乘以2的n次方，这里右移一位代表乘以2的-1次方，即除以2
            // 这种使用位右移操作来实现整数除法的方式可以提高计算效率，特别是在处理大型数据集时。
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid; // 这时right不用-1
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
