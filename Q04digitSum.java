// (24/03/2024, 9:26 AM)
// You are given two non-negative integers A and B. Let the function Sum(A) be the sum of digits of the number A. You can perform any number of moves (possibly zeros).
// In one move you can increase the value of A by 1.
// Find the minimum number of moves you have to perform to make Sum(A) <= B.
// Constraints:
// 1 <= A <= 10^12
// 1 <= B <= 108
// Sample Test Cases:

// 1. A = 1, B = 1       Output = 0
// 2. A = 9, B = 2       Output = 1
// 3. A = 555, B = 10    Output = 45
// Inputs are given in string.
package infosys;

public class Q04digitSum {

    // Logic: Using function Long.valueOf().
    // T = O(nlogn)

    // minMoves
    static int minMoves(String s, String target) {

        long first = Long.valueOf(s);
        long second = Long.valueOf(target);
        if (sumOf(first) <= second) {
            return 0;
        }
        int count = 0;

        while (sumOf(first) > second) {
            first++;
            count++;
        }
        return count;
    }

    // sumOf
    static long sumOf(long num) {

        long sum = 0;

        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        String s1 = "555";
        String s2 = "10"; // 45

        // String s1 = "9";
        // String s2 = "1"; // 1

        // String s1 = "1";
        // String s2 = "1"; // 0

        int ans = minMoves(s1, s2);
        System.out.println(ans);
    }
}