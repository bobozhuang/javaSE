package main.java.com.bobozhuang.exam;

import java.util.HashMap;
import java.util.Map;

/**
 * description：
 * author Hubery
 * date 2020-11-30
 * version v0.0.1
 * since v0.0.1
 **/
public class TwoSum {

    public static void main(String[] args) {
        int[] i = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum(i, target);


    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
