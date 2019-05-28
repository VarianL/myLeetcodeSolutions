package problems;

/**
 * Implement int sqrt(int x). Compute and return the square root of x, where x
 * is guaranteed to be a non-negative integer. Since the return type is an
 * integer, the decimal digits are truncated and only the integer part of the
 * result is returned.
 * 
 */
public class Problem69 {
  /**
   * Salutation.
   */
  public int mySqrt(int x) {
    if (x <= 1) {
      return x;
    }
    double x0 = 0.0;
    double x1 = x;
    while (x1 - x0 >= 0.001 || x1 - x0 <= -0.001) {
      x0 = x1;
      x1 = x0 / 2 + x / (2 * x0);
    }
    return (int) x1;
  }


}