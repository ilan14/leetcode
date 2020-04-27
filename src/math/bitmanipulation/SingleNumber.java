package math.bitmanipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * 136. Single Number
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        int result = 0;
        for (int num : set) {
            result = num;
        }
        return result;
    }

    public int singleNumber1(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;
    }
}
