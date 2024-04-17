// // (23/03/2024, 11:34 AM)
// In a large factory, there are N walls that the owner painted with different types of paints. Due to the humidity and the difference in the type of paints each wall i will take Xi minutes to dry.
// However, there is a magic machine that we can set to work for a certain integer number of minutes and put it in front of a certain wall to speed up the drying process.
// It is given the machine cannot be moved during its work or it will break. Also, for every minutes of work of this machine, it decreases the time remaining to dry the wall in front of it by K minutes. It is also given that if the remaining drying time for a wall is less than K, it will become 0 and dry up without any problems.
// Your task is to find the minimum number of minutes in which all the walls of the factory can be dried.
// Note:
// We have one machine, but after finishing a wall we can move this machine to another wall.
// Input format:
// The first line contains an integer N, denoting the number of elements in X.
// The next line contains an integer K, denoting the magic machine's acceleration number.
// Each line i of the N subsequent lines (where 0 <= i < N) contains an integer describing Xi.

// Constraints:
// 1 <= N <= 10^5
// 1 <= K <= 10^9
// 1 <= X[i] <= 10^9

// Test cases:

// Input:
// 1
// 1
// 1
// Output:
// 1
// Explanation:
// We will let it dry without using the magic machine

// Input:
// 1
// 2
// 1
// Output:
// 1
// Explanation:
// We will let it dry without using the magic machine

// Input:
// 1
// 17
// 35
// Output:
// 3
// Explantion:
// We will use the magic machine three times in a row on the first element.
package infosys;

import java.util.*;

public class Q03Painter {

    // Logic:
    // (I) Minimum time to dry the wall is '1'. Maximum time to dry the wall is max
    // value in array arr.
    // (II) Apply binary search to find the minimum minitue
    // T = O(nlogn)
    
    // totalTime
    static void solve(int arr[], int k, int n) {

        int answer = 1;
        int low = 1, high = 1;
        for (int i = 0; i < n; i++) {
            high = Math.max(high, arr[i]);
        }
        if (k == 1) {
            System.out.println(high);
            return;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isOk(arr, k, mid)) {
                answer = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        System.out.println(answer);
    }

    // isOk
    static boolean isOk(int[] arr, int k, int time) {

        int requiredTime = 0;
        for (int i : arr) {
            if (i - time > 0) {
                double value = (double) (i - time) / (k - 1);
                requiredTime = requiredTime + (int) Math.ceil(value);
            }
        }
        return requiredTime <= time;

    }

    public static void main(String[] args) {

        // int[] arr = { 35 };
        // int k = 17;
        // solve(arr, k,arr.length); // ANSWER ->3

        // int[] arr={6,5,4};
        // int k = 2;
        // solve(arr, k,arr.length); // ANSWER ->4

        // int[] arr = { 1, 8, 10 };
        // int k = 1;
        // solve(arr, k, arr.length); // ANSWER ->10

        // int [] arr={5,2,10,7};
        // int k = 3;
        // solve(arr, k,arr.length); // ANSWER ->5

        // int[] arr={12,11,4,2};
        // int k = 3;
        // solve(arr, k,arr.length); // ANSWER ->6

        // int [] arr={10,10,10};
        // int k = 3;
        // solve(arr, k,arr.length); // ANSWER ->6

        // int[] arr = { 7, 9, 10, 3, 15 };
        // int k = 5;
        // solve(arr, k, arr.length); // ANSWER ->6

        // int[] arr={17};
        // int k = 16;
        // solve(arr, k,arr.length); // ANSWER ->2

        // int[] arr = { 5, 2, 10, 7, 35 };
        // int k = 3;
        // solve(arr, k, arr.length); // ANSWER ->12

        int[] arr = { 1000, 500, 100, 10 };
        int k = 100;
        solve(arr, k, arr.length); // ANSWER ->16
    }
}