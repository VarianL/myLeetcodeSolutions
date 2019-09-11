package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to
 * n. But for multiples of three it should output “Fizz” instead of the number
 * and for the multiples of five output “Buzz”. For numbers which are multiples
 * of both three and five output “FizzBuzz”.
 */
public class Problem412 {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        for (int i = 1; i <= n; ++i) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0) {
                result.add("Fizz");
                continue;
            }
            if (i % 5 == 0) {
                result.add("Buzz");
                continue;
            }
            
            result.add(String.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Problem412 p = new Problem412();
        p.fizzBuzz(15).forEach(str -> System.out.println(str));
    }
}