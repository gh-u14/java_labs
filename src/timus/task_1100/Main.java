package timus.task_1100;

import java.io.*;
import java.util.*;

public class Main {

    static class Team {
        int id;
        int m;

        Team(int id, int m) {
            this.id = id;
            this.m = m;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Team[] teams = new Team[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            teams[i] = new Team(id, m);
        }

        Arrays.sort(teams, (a, b) -> b.m - a.m);

        StringBuilder out = new StringBuilder();
        for (Team t : teams) {
            out.append(t.id).append(" ").append(t.m).append("\n");
        }

        System.out.print(out);
    }
}