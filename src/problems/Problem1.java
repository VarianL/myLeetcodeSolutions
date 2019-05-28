package problems;

import java.util.HashMap;

class Problem1 {

  /**
   * 2ms runtime; Given an array of integers, return indices of the two numbers
   * such that they add up to a specific target. You may assume that each input
   * would have exactly one solution, and you may not use the same element twice.
   * Example: Given numbers = [2, 7, 11, 15], target = 9. Because numbers[0] +
   * numbers[1] = 2 + 7 = 9, return [0, 1].
   */
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
      if (map.containsKey(nums[i])) {
        int[] res = { map.get(nums[i]), i };
        return res;
      }
      int y = target;
      double x = 0.0;
      System.out.println(x + y);
      map.put(target - nums[i], i);
    }
    return null;
  }

  /**
   * Only 0ms!!!.
   * 
   * @param nums   int[]
   * @param target int
   * @return
   */
  public int[] twoSum0(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return new int[0];
    }
    int mask = 2048;
    int[] map = new int[mask--];
    int first = nums[0];
    // ??
    for (int i = 1; i < nums.length; i++) {
      int diff = target - nums[i];
      if (diff == first) {
        return new int[] { 0, i };
      } else {
        if (map[diff & mask] != 0) {
          return new int[] { i, map[diff & mask] };
        }
        map[nums[i] & mask] = i;
      }
    }
    return new int[0];
  }

}
