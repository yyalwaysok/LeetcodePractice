package org.example.array.src;

public class basic {
    // 数组是存放在连续内存空间上的相同类型数据的集合，可以方便地通过下标索引的方式获取到下表对应的数据
    // 数组内存空间的地址是连续的，所以在增删元素时会移动其他元素的地址
    public static void main(String[] args) {
        test_arr();
    }

    public static void test_arr() {
        int[][] arr = {{1, 2, 3}, {3, 4, 5}, {6, 7, 8}, {9, 9, 9}}; // 这是一个二维数组
        System.out.println(arr[0]); // [I@723279cf
        System.out.println(arr[1]); // [I@10f87f48
        System.out.println(arr[2]); // [I@b4c966a
        System.out.println(arr[3]); // [I@2f4d3709
        // 这些数值不是真正的内存地址，而是经过处理后的哈希码，表示对象的引用地址，而且也不是连续的。因为这些引用地址是栈区指向堆区的地址
        // 在java中，无法直接查看数组的真正内存地址，因为java为了提供更高级的抽象和安全性，隐藏了对象的底层内存细节。

    }
}
