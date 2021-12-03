package com.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 서울지하철2호선_16947 {

    static int N;
    static int map[][];
    static boolean visited[];
    static ArrayList<Integer>[] list;
    static ArrayList<Integer> sun = new ArrayList<>();
    static int start;
    static int min;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];

        for (int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            start = i;
            sun_dfs(i, 0);
        }

        for (int i=1; i<=N; i++) {
            min = Integer.MAX_VALUE;
            for (int j=0; j<sun.size(); j++) {
                visited = new boolean[N+1];
                distance_dfs(i, sun.get(j), 0);
            }
            sb.append(min).append(" ");
        }
        System.out.println(sb);
    }

    static void sun_dfs(int at, int depth) {

        if (depth>=3 && start == at) {
            sun.add(start);
            return;
        }

        if (visited[at] == true) return;

        visited[at] = true;

        for (int i=0; i<list[at].size(); i++) {
            sun_dfs(list[at].get(i), depth+1);
        }

    }

    static void distance_dfs(int start, int des, int depth) {

        if (visited[start] == true) return;

        if (start == des) {
            min = Math.min(min, depth);
            return;
        }

        visited[start] = true;

        for (int i=0; i<list[start].size(); i++) {
            distance_dfs(list[start].get(i), des,depth+1);
        }
    }

}
