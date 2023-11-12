package org.example.array.src;

import java.util.Arrays;

public class lc209_medium {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 11;
        int i = solution1(target, nums);
        System.out.println(i);

//        int[] arr = {1, 3, 6, 7, 9};
//        int elementToSearch = 10;
//        int index = Arrays.binarySearch(arr, elementToSearch);
//        System.out.println(-index - 1);
    }

    // 暴力解法，两个for循环不断寻找符合条件的子数组
    // 时间复杂度是O(n^2)
    public static int solution1(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE; // 设置ans为最大的值
        for (int i = 0; i < n; i++) {
            int sum = 0; // 记录子数组元素和

            if (nums[i] >= target) {
                return 1; // 如果当前元素大于等于target，直接返回1
            }

            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) { // 满足题目条件：其和 ≥ target
                    ans = Math.min(ans, j - i + 1); // j-i+1=该数组长度，与现有的ans对比，取更小的那个
                    break;
                }
                if (j - i + 1 >= ans) {
                    break; // 如果当前子数组长度已经大于等于ans，提前终止内层循环
                }
            }

        }
        // 如果两个for循环结束后还没有找到符合条件的子数组，那么ans依然=Integer.MAX_VALUE
        return ans == Integer.MAX_VALUE ? 0 : ans; // 换言之如果ans=Integer.MAX_VALUE，那么就是没有找到，要返回0
    }

    // 前缀和 + 二分查找
    public int solution2(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1]; // sums用于储存数组和
        // sums[0] = nums前0个元素的和 = 0
        // sums[1] = nums前1个元素的和 = nums[0]
        // sums[2] = nums前2个元素的和 = nums[0] + nums[1]
        // sums[n] = nums[0] + nums[1] + ... + nums[n-1]
        // sums[n+1] = nums[0] + nums[1] + ... + nums[n]
        // 为了把nums中所有的n个元素的和都存起来，需要设置sums的size为n+1
        // 但是为什么sums数组第一个元素要存0，而不是nums[0]呢？
        for (int i = 1; i <= n; i++) { // sums最后一个元素下标是n，所以可以遍历得到
            sums[i] = sums[i - 1] + nums[i - 1]; // 就是因为在for循环里写使用这个公式
            // 如果想从i=0开始存的话，不存在sums[-1]，那么需要对 i=0 单独设置 sums[i] = nums[i]，其余情况 sums[i] = sums[i-1] + nums[i]
        }
        for (int i = 1; i <= n; i++) {
            int d = target + sums[i - 1]; // target = d - sums[i-1] => 起点为下标i-1，终点为值d，这个区间的值刚好=目标值target
            int bound = Arrays.binarySearch(sums, d);
            // Arrays.binarySearch(int[] arr, int i)会用二分查找法，查找不递减数组arr中=i的第一个位置，
            // 找不到就返回-1 * (insertionPoint) - 1 => insertionPoint是应该插入的位置
            if (bound < 0) { // bound<0说明找不到sums数组中=d的位置，即没有刚好值=target的区间
                bound = -bound - 1; // 取反+1获得应该插入的位置
            }
            if (bound <= n) { // bound>n，基本上是bound=n+1，就是sums数组里没有比d小的值了，可以直接跳过，不需对ans进行处理
                ans = Math.min(ans, bound - (i - 1)); // bound-(i-1)是就是这个区间的元素个数
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // 滑动窗口
    public int solution3(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


}
