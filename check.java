package infosys;

import java.util.*;
import java.lang.*;

public class check {

    static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> hm = new HashMap<>();

        for (String s : strs) {

            int[] frq = new int[26];
            for (char c : s.toCharArray()) {
                frq[c - 'a']++;
            }
            for (int i : frq)
                System.out.print(i + " ");
            String st = String.valueOf(frq);
            System.out.println(st);
            if (!hm.containsKey(st)) {
                hm.put(st, new ArrayList<String>());
                hm.get(st).add(s);
            } else {
                hm.get(st).add(s);
            }
        }

        System.out.println(hm);
        return new ArrayList<>(hm.values());
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 0, };
        System.out.println(String.valueOf(arr));
        System.out.println(String.valueOf(100));
        // String s [] = {"eat","tea"};
        // List <List<String>> ans = groupAnagrams(s);
        // System.out.println(ans);
    }
}
