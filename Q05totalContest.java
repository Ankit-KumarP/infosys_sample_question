// (25/03/2024, 11:48 AM)
// Bob has some problems with n topics, he will give you all the problems as an array A with length N. It is given that A[i] denotes the number of problems on ith topic tht he wrote.
// Bob asks you to organise the maximum possible number of contests using these two problems such that
// i) Each contest has distinct problems(no two or more problems with the same topic).
// ii)Each contest(except the first one) has more problems than the previous contest.
// Find the maximum number of contests you can organise using problems given by bob.
// Input Format:
// The first line contains integer N,denoting number of elements in A.
// Each line i of the N subsequent lines(0<=i<N) contains an integer describing A[i].
// Constraints:
// 1<=N<=10^5
// 1<=A[i]<=10^5
// Sample Input 1:
// 3
// 1
// 1
// 4
// Sample output 1:
// 2
// Explanation:
// N=3, A={1,1,4}. In the first contest you can make a question on topic 0.In the second contest make 2 problems, 1 on topic 1 and 1 on topic 2.Now Bob cant make third contest because he needs to make 3 questions in 3rd contest and he does not have problems remaining on topic 0 and 1. so the answer is 2.

// Sample Input 2:
// 4
// 7
// 8
// 10
// 13
// Sample output 2:
// 4
// Explanation:
// The first contest has topic 3 the second contest has topics 2 and 1 the third contest has topic 1,2 and 3 the fourth contest has topics 0,1,2 and 3.
package infosys;

import java.util.*;
import java.lang.*;

public class Q05totalContest {

    // number
    // static int number(int[] arr) {

    // int high = arr.length, low = 1;
    // int rtn = 0;

    // while (low <= high) {
    // int mid = (low + high) / 2;
    // if (isPossible(arr, mid)) {
    // rtn = mid;
    // low = mid + 1;
    // } else {
    // high = mid - 1;
    // }

    // }
    // return rtn;
    // }

    // static boolean isPossible(int[] nums, int k) {

    // int arr[] = new int[nums.length];
    // for (int i = 0; i < arr.length; i++) {
    // arr[i] = nums[i];
    // }

    // for (int i = 1; i <= k; i++) {
    // int count = 0, ptr = 0;
    // while ((count != i) && (ptr < arr.length)) {
    // if (arr[ptr] > 0) {
    // arr[ptr]--;
    // count++;
    // }
    // ptr++;
    // }
    // if (count != i)
    // return false;
    // }

    // return true;

    // }

    static boolean t(int[] nums, int tot, int left, int n) {
        int i = n;
        while (tot > 0 && i > 0) {
            i--;
            if (nums[i] < left) {
                left -= nums[i];
            } else {
                tot--;
                left = Math.max(Math.min(left, tot), tot + left - nums[i]);
            }
        }
        return tot == 0;
    }

    static int findMinimumGroups(int[] nums) {
        int l = 1;
        int h = nums.length;

        Arrays.sort(nums);

        while (l < h) {
            int mid = (l + h + 1) / 2;
            if (t(nums, mid, mid, nums.length)) {
                l = mid;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {

        // int[] arr = { 1, 1, 4 }; // 2
        int[] arr = { 7, 8, 10, 13 }; // 4

        // int ans = number(arr);
        // System.out.println(ans);

        int result = findMinimumGroups(arr);
        System.out.println(result);

    }
}