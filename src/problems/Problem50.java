package problems;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 */
public class Problem50 {
  /**
   * solution.
   */
  public double myPow(double x, int n) {
    if (x == 0) {
      return 0.0;
    }
    if (x == 1) {
      return x;
    }
    if (n == 0) {
      return 1.0;
    }
    if (n == 1) {
      return x;
    }
    if (x == -1) {
      if ((n & 1) == 0) {
        return 1;
      } else {
        return -1;
      }
    }
    if (n == -1) {
      return 1 / x;
    }
    double ans = 1.0;
    double base = x;
    boolean flag = n < 0;
    int t;
    if (n == Integer.MIN_VALUE) {
      return 0.0;
    } else {
      t = flag ? (-n) : n;
    }
    while (t != 0) {
      if ((t & 1) == 1) {
        ans *= base;
      }
      base *= base;
      t = t >> 1;
      if (ans == Double.POSITIVE_INFINITY) {
        break;
      }
    }

    return flag ? 1 / ans : ans;
  }

  /* 
  public static void main(String[] args) {
    int n = 20;
    double ans = 1.0;
    double base = 2.0;
    while (n != 0) {
      if ((n & 1) == 1) {
        ans *= base;
      }
      base *= base;
      n = n >> 1;
    }
  } 
  */
}