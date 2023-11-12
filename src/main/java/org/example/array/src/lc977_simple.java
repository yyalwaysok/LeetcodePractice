package org.example.array.src;

import java.util.Arrays;

public class lc977_simple {
    public static void main(String[] args) {
        int[] nums = {-3, -2, 0, 2, 3, 11};
        System.out.println(Arrays.toString(nums));
        int[] answer = solution4(nums);
        System.out.println(Arrays.toString(answer));
    }

    // 暴力解法，元素平方后排序
    public static int[] solution1(int[] nums) {
//        for (int num : nums) {
//            num = num * num;
//        }
        // 注意使用for(int num:nums)循环遍历元素并进行修改时，并不会真正修改到原始数组
        // 中的元素，因为这里的num只是一个临时变量；如果需要遍历修改数组元素，应使用for i
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    // 双指针法
    public static int[] solution2(int[] nums) {
        int n = nums.length;
        // boundary为数组中负数与非负数的分界线
        int boundary = -1; // 设定为负数，防止数组所有元素都大于0，下面的for循环中没有为boundary赋值
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                boundary = i; // boundary最终取值为[最大的负数元素]的下标，遍历到正数元素后跳出本循环
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int neg = boundary; // nums[neg]是最大的负数
        int pos = boundary + 1; // nums[j]是最小的正数
        for (int index = 0; index < n; index++) { // index是答案数组的输入指针
            if (neg < 0) { // neg<0说明全部是正数
                ans[index] = nums[pos] * nums[pos]; // 那么直接把平方的元素放进答案数组就可以了
                // 使用pos因为neg=-1
                pos++;
            } else if (pos == n) { // pos==n说明全部是负数
                ans[index] = nums[neg] * nums[neg]; // 也是直接把平方的元素放进答案数组就可以了
                // 不过注意nums中最右的元素平方后值最小，所以循环中index递增，i递减
                neg--;
            } else if (nums[neg] * nums[neg] < nums[pos] * nums[pos]) { // 对比negative边界左右元素的平方，如果左边的小
                ans[index] = nums[neg] * nums[neg]; // 那就先存左边的
                neg--; // 然后负数指针往左走1
                // 注意nums中越靠近边界的值越小，所以从之间的元素开始存
            } else { // 剩下的情况只有对比negative边界左右元素的平方，右边的小
                ans[index] = nums[pos] * nums[pos];
                pos++;
            }
        }

        return ans;
    }

    // 双指针法：左右指针
    public static int[] solution3(int[] nums) {
        int[] result = new int[nums.length]; // 创建result数组存放比较后的值
        int left = 0; // 左指针
        int right = nums.length - 1; // 右指针
        int i = nums.length - 1; // result数组第一个存放位置的下标应该是最左边的那个，因为原数组两边的值为最大的值
        while (left <= right) { // 这里要用<=，因为最中间的数字也需要比较并添加至result数组
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[i] = nums[left] * nums[left];
                i--;
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                i--;
                right--;
            }
        }
        return result;
    }

    // 如果不创建新数组，可以直接在给定的数组上进行平方操作，
    // 并使用类似插入排序的方法实现非递减排序。
    public static int[] solution4(int[] nums) {
        for (int a = 0; a < nums.length; a++) {
            nums[a] = nums[a] * nums[a];
        }

        for (int i = 1; i < nums.length; i++) {
            int key = nums[i]; // 一开始i=1，key是第二个元素，每一轮循环都要跟i左边的值比较
            int j = i - 1; // 从i左边第一个开始比较

            // 9,4,1,0,4,9,121
            // 将比 key 大的元素向后移动
            // 下标为0到j的元素都是排过序，不递减的
            // j+1，即i下标的元素没有比较过，所以要跟它进行比较
            // 如果已排序的队伍中(0-)最大的那个也比key小的话，跳过循环，直接nums[j+1]=key，即num[i]=key，无事发生
            // 如果已排序的队伍中(0-j)最大的那个(j)比key大的话，那么key要往后放，原本的j往前走一步
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j]; // 原本的j往前走一步
                j--; // 然后j往左，第二小的那个跟key比较 => 这里说的是第一个循环 => 后面的循环就是不断往左走
            }
            nums[j + 1] = key; // 直到找到不递减队伍中小于等于key的那个位置，把key放在这个位置
            // 或者如果不递减队伍中都没有小于等于key的，那就把key放在下标0的位置
        }
        return nums;
    }

}
