// (12/03/2024, 10:04am)
// Your birthday is coming soon and one of your friends, Alex, is thinking about a gift for you. He knows that you really like integer arrays with interesting properties.
// He selected two numbers, N and K, and decided to write down on paper all integer arrays of length K (in form a[1], a[2], …, a[K]), where every number a[i] is in range from 1 to N, and, moreover, a[i+1] is divisible by a[i] (where 1 < i <= K), and give you this paper as a birthday present.
// Alex is very patient, so he managed to do this. Now you’re wondering, how many different arrays are written down on this paper? Since the answer can be really large, print it modulo 10000.
// Example:
// Input: N = 3, K = 2
// Output: 5
// Explanation: All possible arrays are: [1, 1], [1, 2], [1, 3], [2, 2], [3, 3]
package infosys;

import java.util.*;
import java.lang.*;

public class Q01Birthdaygift {

    // Logic:
    // (I) totalArrays(n,k) = totalArrays(n, k - mid) + count(n,mid);
    // (II) count is a methode that give out put when 'k' is <=2;
    // T = O(n^2logk)

    // totalArrays
    static int totalArrays(int n, int k) {

        if (k == 1)
            return n;
        else if (k == 2)
            return count(n, k);

        int mid = k / 2;
        int first = (totalArrays(n, k - mid)) % 10000;
        int second = (count(n, mid)) % 10000;

        return (first + second - 1) % 10000;

    }

    // count
    static int count(int n, int k) {

        if (k == 1)
            return n;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i % j == 0)
                    count++;
            }
        }

        return count % 10000;
    }

    public static void main(String[] args) {

        // int n = 3;
        // int k = 2; // 5;

        // int n = 2;
        // int k = 1; // 2

        // int n = 2;
        // int k = 2;// 3

        int n = 46;
        int k = 19; // 786

        int dp[] = new int[k + 1];
        Arrays.fill(dp, -1);
        int ans = totalArrays(n, k);
        System.out.println();
        System.out.println(ans);

    }
}
