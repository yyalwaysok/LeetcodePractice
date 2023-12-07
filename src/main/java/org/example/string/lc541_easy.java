package org.example.string;

public class lc541_easy {
    public static void main(String[] args) {
        String s = reverseStr("abcdefg", 2);
        System.out.println(s);
    }

    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int start = 0;
        while (start <= s.length()) {
            int left = start;

            int right;
            if (s.length() - 1 - start < k) {
                right = s.length() - 1;
            } else {
                right = start + k - 1;
            }

            while (left <= right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                right--;
                left++;
            }
            start += 2*k;
        }
        return String.valueOf(chars);
    }
}
