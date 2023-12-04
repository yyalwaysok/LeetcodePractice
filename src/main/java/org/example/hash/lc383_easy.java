package org.example.hash;

public class lc383_easy {
    // Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
    // Each letter in magazine can only be used once in ransomNote.
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        boolean flag = true;
        int[] chars = new int[26];

        for (char c : magazine.toCharArray()) {
            chars[c - 'a']++;
        }
        for (char r : ransomNote.toCharArray()) {
            if (chars[r - 'a'] > 0) {
                chars[r - 'a']--;
            } else {
                return false;
            }
        }
        return flag;
    }

    public static boolean canConstruct1(String ransomNote, String magazine) {
        boolean flag = true;
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            String currentChar = String.valueOf(ransomNote.charAt(i));
            if (magazine.contains(currentChar)) {
                ransomNote = ransomNote.replaceFirst(currentChar, "");
                magazine = magazine.replaceFirst(currentChar, "");
                i--;
            } else {
                return false;
            }
        }
        return flag;
    }
}
