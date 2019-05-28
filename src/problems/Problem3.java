package problems;

import java.util.HashSet;

class Problem3 {
  public int lengthOfLongestSubstring(String s) {
    if (s == null) {
      return 0;
    } else if (s.length() <= 1) {
      return s.length();
    }
    char lastChar = 0;
    int len = 0;
    int res = 1;
    HashSet<Character> set = new HashSet<>();
    for (char ch : s.toCharArray()) {
      if (ch == lastChar && set.contains(ch)) {
        if (res < len) {
          res = len;
        }
        len = 1;
      } else if (ch != lastChar && set.contains(ch)) {
        if (res < len) {
          res = len;
        }
        len = 1;
      } else {
        ++len;
      }
      lastChar = ch;
      set.add(ch);
    }
    if (res < len) {
      res = len;
    }
    return res;
  }

  public static void main(String[] args) {
    String str = "dvd";
    Problem3 p = new Problem3();
    System.out.println(p.lengthOfLongestSubstring(str));
  }
}
