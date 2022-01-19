package com.boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE_13023 {

    static int N;
    static int M;
    static ArrayList<Integer>[] list;
    static boolean [] visited;
    static int ans = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        list = new ArrayList[N];

        for (int i=0; i<N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            list[n].add(m);
            list[m].add(n);
        }

        for (int i=0; i<N; i++) {
            if (ans==0) dfs(i, 1);
        }
        System.out.println(ans);
    }

    static void dfs (int at, int depth) {

        if (depth == 5) {
            ans = 1;
            return;
        }

        visited[at] = true;
        for (int i : list[at]) {
            if (!visited[i]) {
                dfs(i, depth+1);
            }
        }
        visited[at] = false;
    }
}
