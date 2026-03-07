package timus.task_1196;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        int m = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < m; i++) {
            int year = Integer.parseInt(br.readLine());
            if (set.contains(year)) {
                count++;
            }
        }

        System.out.println(count);
    }
}