package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추_1012 {

    static int M;
    static int N;
    static int K;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int j=0; j<K; j++) {
                st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                map[n][m] = 1;
            }

            int count = 0;
            for (int j=0; j<N; j++) {
                for (int k=0; k<M; k++) {
                    if (visited[j][k] || map[j][k] == 0) continue;
                    dfs(j,k);
                    count++;
                 }
            }
            System.out.println(count);
        }
    }

    static void dfs(int n, int m) {

        if (n < 0 || n > N-1 || m < 0 || m > M-1 || visited[n][m] || map[n][m] == 0) return;

        visited[n][m] = true;

        dfs(n+1, m);
        dfs(n, m+1);
        dfs(n-1, m);
        dfs(n, m-1);

    }
}
