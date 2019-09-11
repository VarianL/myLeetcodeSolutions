package problems;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class Problem204 {

    public int countPrimes(int n) {

        if (n <= 2) {
            return 0;
        } else if (n <= 3) {
            return 1;
        } else if (n <= 5) {
            return 2;
        }
        int result = 2;
        for (int i = 5; i < n; i += 2) {
            if (isPrimeNumber(i)) {
                ++result;
            }
        }
        return result;
    }

    private boolean isPrimeNumber(int n) {
        boolean result = true;

        if (n % 6 != 1 && n % 6 != 5) {
            return false;
        }
        int temp = (int) Math.sqrt(n) + 1;
        for (int i = 5; i < temp; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem204 p = new Problem204();
        System.out.println(p.isPrimeNumber(3));
        // System.out.println(p.countPrimes(1500000));
    }
}