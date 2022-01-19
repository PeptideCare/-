package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 서울지하철2호선_16947 {

    static int N;
    static int map[][];
    static boolean visited[];
    static ArrayList<Integer>[] list;
    static ArrayList<Integer> sun = new ArrayList<>();
    static int start;
    static int[] ans;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        ans = new int[N+1];

        for (int i=1; i<=N; i++) {
            ans[i] = 10000;
        }

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

        for (int i=0; i<sun.size(); i++) {
            visited = new boolean[N+1];
            bfs(sun.get(i));
        }

        for (int i=1; i<=N; i++) {
            System.out.print(ans[i] + " ");
        }
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

    static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);
        ans[start] = 0;

        while (!q.isEmpty()) {

            int poll = q.poll();

            for (int i=0; i<list[poll].size(); i++) {
                int num = list[poll].get(i);

                if (visited[num] == true) continue;

                q.offer(num);
                ans[num] = Math.min(ans[poll]+1, ans[num]);
                visited[num] = true;

            }
        }
    }
}
