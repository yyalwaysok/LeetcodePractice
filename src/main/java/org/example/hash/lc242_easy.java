package org.example.hash;

public class lc242_easy {
    // Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    // An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    // typically using all the original letters exactly once.
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        boolean result = isAnagram(s, t);
        System.out.println(result);
    }

    private static boolean isAnagram(String s, String t) {
        int[] record = new int[26]; // record the count of 26 alphabet
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++; // s.charAt(i_-'a') won't be larger than 26 because we assume all are lowercase letters
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int count :
                record) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        for (int i = 0; i < charS.length; i++) {
            boolean flag = false;
            for (int j = 0; j < charT.length; j++) {
                if (charS[i] == charT[j]) {
                    charS[i] = '\0';
                    charT[j] = '\0';
                    flag = true;
                }
            }
            if (flag == false) {
                return flag;
            }
        }
        return true;
    }
}
