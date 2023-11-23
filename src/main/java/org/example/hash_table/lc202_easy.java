package org.example.hash_table;

import java.util.HashSet;

public class lc202_easy {
    // Write an algorithm to determine if a number n is happy.

    //A happy number is a number defined by the following process:

    //Starting with any positive integer, replace the number by the sum of the squares of its digits.
    //Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    //Those numbers for which this process ends in 1 are happy.
    //Return true if n is a happy number, and false if not.
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> integers = new HashSet<>();
        while (n != 1) {
            integers.add(n);
            n = getSumOfSquaresOfEachDigits(n);
            if (integers.contains(n)) {
                return false;
            }
        }
        return true;
    }

    public static int getSumOfSquaresOfEachDigits(int n) {
        String s = String.valueOf(n);
        int total = 0;
        int temp;
        for (int i = 0; i < s.length(); i++) {
            temp = Character.getNumericValue(s.charAt(i)) * Character.getNumericValue(s.charAt(i));
            total += temp;
        }
        return total;
    }

    public static int getSumOfSquaresOfEachDigits2(int n) {
        int result = 0;
        while (n > 0) {
            int temp = n % 10; //
            result += temp + temp;
            n = n / 10;
        }
        return result;
    }
}
