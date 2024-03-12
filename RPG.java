// (13/03/2024, 09:30AM, barbigha)
package infosys;

import java.util.*;
import java.lang.*;

// Monstor
class Monstor {
    int power;
    int bonus;

    Monstor(int power, int bonus) {
        this.power = power;
        this.bonus = bonus;
    }
}

public class RPG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int initial = sc.nextInt();
        int[] power = new int[n];
        for (int i = 0; i < n; i++) {
            power[i] = sc.nextInt();
        }

        int[] bonus = new int[n];
        for (int i = 0; i < n; i++) {
            bonus[i] = sc.nextInt();
        }

        Monstor arr[] = new Monstor[n];
        for (int i = 0; i < n; i++) {
            Monstor m = new Monstor(power[i], bonus[i]);
            arr[i] = m;
        }

        // Arrays.sort(arr, new Comparator<Monstor>() {
        //     public int compare(Monstor m1, Monstor m2) {
        //         int power = m1.power - m2.power;
        //         if (power == 0)
        //             return m1.bonus - m2.bonus;
        //         else
        //             return power;
        //     }
        // });

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (initial >= arr[i].power) {
                count++;
                initial += arr[i].bonus;
            }
        }

        System.out.println(count);

// input 1
// 2
// 123
// 78
// 130
// 10
// 0
// ANS: 2

// input 2
// 3
// 100
// 101
// 100
// 304
// 100
// 1
// 524
// ANS: 2
    }
}