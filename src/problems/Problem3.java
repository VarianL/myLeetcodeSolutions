package problems;

import java.util.Arrays;

class Problem3 {
  public int lengthOfLongestSubstring(String s) {
    if (s == null) {
      return 0;
    } else if (s.length() <= 1) {
      return s.length();
    }
    // 记录字符与index的关系
    int[] indexMap = new int[256];
    Arrays.fill(indexMap, -1);
    int start = 0, res = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      // 如果出现重复的字符，将起始位置 +1
      if (indexMap[c] != -1 && indexMap[c] >= start) {
        res = Math.max(res, i - start);
        start = indexMap[c] + 1;
      }
      // 记录字符最后一次出现在字符串中的位置
      indexMap[c] = i;
    }
    res = Math.max(res, s.length()  - start);
    return res;
  }

  public static void main(String[] args) {
    String str = "anviaj";
    Problem3 p = new Problem3();
    System.out.println(p.lengthOfLongestSubstring(str));
  }
}
