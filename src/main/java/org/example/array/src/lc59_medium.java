package org.example.array.src;

public class lc59_medium {
    public static void main(String[] args) {
        int[][] ints = solution3(5);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.printf("%5d", i);
            }
            System.out.println();
        }
    }

    // 模拟矩阵的生成
    public static int[][] solution1(int n) {
        int maxNum = n * n; // 矩阵的元素个数
        int[][] matrix = new int[n][n]; // 创建矩阵
        int row = 0, column = 0; // 表示填到矩阵中哪个位置（行列）
        int curNum = 1; // 用于给该位置填数字，每赋完一次值就自增1
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 表示赋完值后要转哪个方位填下一个数字，分别是向右、向下、向左、向上
        // 这个顺序也正是螺旋矩阵生成的顺序
        int directionIndex = 0; // 用于directions的轮换
        while (curNum <= maxNum) {
            matrix[row][column] = curNum; // 给行列对应的位置赋值
            curNum++;
            int nextRow = row + directions[directionIndex][0]; // 只用于判断下一个位置是否有效，并不直接操作
            int nextColumn = column + directions[directionIndex][1];

            // 这里不需要用while因为不存在变更方向后还是无效位置的情况
            if (nextRow == -1 // 矩阵的上边界
                    || nextRow == n // 矩阵的下边界
                    || nextColumn == -1 // 矩阵的左边界
                    || nextColumn == n // 矩阵的右边界
                    || matrix[nextRow][nextColumn] != 0) { // 或者准备填的位置已经有值
                directionIndex = (directionIndex + 1) % 4; // 那么就需要转向
                // 通过更新directions的索引来变更方向
            }
            row += directions[directionIndex][0]; // 变换位置
            column += directions[directionIndex][1];
        }
        return matrix;
    }

    // 按层模拟
    // 可以将矩阵看成若干层，首先填入矩阵最外层的元素，其次填入矩阵次外层的元素，直到填入矩阵最内层的元素。
    public static int[][] solution2(int n) {
        int num = 1; // 用来赋值
        int[][] matrix = new int[n][n]; // 创建矩阵
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        // 下标，用于确定输入的位置，从矩阵的左右上下边界开始
        while ((left <= right && top <= bottom)) { // 直到最内层也填完了（其实这里这判断一个也可以，因为题中是个正方形
            for (int column = left; column <= right; column++) { // 左边界到右边界
                matrix[top][column] = num; // 给最上边那行赋值
                num++;
            }
            for (int row = top + 1; row <= bottom; row++) { // 上边界下一行到下边界
                matrix[row][right] = num; // 给最右边那列赋值
                num++;
            }
            if (left < right && top < bottom) { // 最内层只要
                for (int column = right - 1; column > left; column--) { // 右边界左一行到左边界
                    matrix[bottom][column] = num; // 给最下边那行赋值
                    num++;
                }
                for (int row = bottom; row > top; row--) { // 下边界到上边界下一行
                    matrix[row][left] = num; // 给最左边那列赋值
                    num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
            // 边界移动
        }
        return matrix;
    }

    public static int[][] solution3(int n) {
        int num = 1; // 用来赋值
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while ((left <= right && top <= bottom)) {
            for (int column = left; column <= right; column++) {
                matrix[top][column] = num;
                num++;
            }
            top++;
            for (int row = top; row <= bottom; row++) {
                matrix[row][right] = num;
                num++;
            }
            right--;
            if (left < right && top < bottom) {
                for (int column = right; column >= left; column--) {
                    matrix[bottom][column] = num;
                    num++;
                }
                bottom--;
                for (int row = bottom; row >= top; row--) {
                    matrix[row][left] = num;
                    num++;
                }
                left++;
            }
        }
        return matrix;
    }

}
