// (13/03/2024, 09:30AM, barbigha)
// While playing an RPG game, you were assigned to complete one of the hardest quests in this game. There are n monsters you’ll need to defeat in this quest. Each monster i is described with two integer numbers – poweri and bonusi. To defeat this monster, you’ll need at least poweri experience points. If you try fighting this monster without having enough experience points, you lose immediately. You will also gain bonusi experience points if you defeat this monster. You can defeat monsters in any order.

// The quest turned out to be very hard – you try to defeat the monsters but keep losing repeatedly. Your friend told you that this quest is impossible to complete. Knowing that, you’re interested, what is the maximum possible number of monsters you can defeat?

// Input:

// The first line contains an integer, n, denoting the number of monsters. The next line contains an integer, e, denoting your initial experience.
// Each line i of the n subsequent lines (where 0 ≤ i < n) contains an integer, poweri, which represents power of the corresponding monster.
// Each line i of the n subsequent lines (where 0 ≤ i < n) contains an integer, bonusi, which represents bonus for defeating the corresponding monster.
// Input
// 3
// 100
// 101
// 100
// 304
// 100
// 1
// 524  // output: 2 Initial experience level is 100 points.
// Explanation
// Defeat the second monster having power of 100 and bonus of 1. Experience level is now 100+1=101.
// Defeat the first monster having power of 101 and bonus of 100. Experience level is now 101+100=201.
// The third monster can’t be defeated.
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

public class Q02RPG {

    // Logic:
    // (I) Sort the monster based on power in increasing order. If power is same
    // then sort on based of bonus point in increasing order.
    // T = O(n)
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

        Arrays.sort(arr, new Comparator<Monstor>() {
            public int compare(Monstor m1, Monstor m2) {
                int power = m1.power - m2.power;
                if (power == 0)
                    return m1.bonus - m2.bonus;
                else
                    return power;
            }
        });

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