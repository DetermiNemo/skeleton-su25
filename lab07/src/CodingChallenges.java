import java.util.*;

public class CodingChallenges {

    /**
     * Return the missing number from an array of length N containing all the
     * values from 0 to N except for one missing number.
     */
    public static int missingNumber(int[] values) {
        Set<Integer> set = new HashSet<>();
        for (int num : values) {
            set.add(num);
        }
        for (int i = 0; i < values.length; i++) {
            if (!(set.contains(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns true if and only if s1 is a permutation of s2. s1 is a
     * permutation of s2 if it has the same number of each character as s2.
     */
    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            s2Map.put(c, s2Map.getOrDefault(c, 0) + 1);
        }
        return s1Map.equals(s2Map);
    }
}
