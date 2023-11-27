package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // 双指针法（快慢指针）
        // 二分法
        // 链表 - 虚拟头节点
        // 什么时候用哈希法 => 需要快速判断一个元素是否出现过，或者一个元素是否在集合里的时候
        // 哈希法常用三种数据结构：array数组、set集合、map映射
        // 哈希法：牺牲空间换时间
    }

    int[] solution(int[] a) {
        int[] integers = new int[10];
        for (int x : a) {
            if (x > 9) {
                while (x != 0) {
                    int temp = x % 10;
                    integers[temp]++;
                    x = x / 10;
                }
            } else {
                integers[x]++;
            }
        }
        int maxCount = 0;
        for (int i = 0; i < integers.length; i++) {
            maxCount = Math.max(maxCount, integers[i]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] == maxCount) {
                result.add(integers[i]);
            }
        }
        return result.stream().mapToInt(x->x).toArray();
    }
}