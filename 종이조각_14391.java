package com.boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이조각_14391 {

    static int N;
    static int M;
    static int [][] map;
    static boolean [][] visited;
    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        // 값 입력
        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        dfs(0, 0);
        System.out.println(max);

    }

    static void dfs(int row, int col) {

        // 가로
        if (row >= N) {
            sum();
            return;
        }

        // 세로
        if (col >= M) {
            dfs(row+1, 0);
            return;
        }

        // 가로
        visited[row][col] = true;
        dfs(row, col+1);

        // 세로
        visited[row][col] = false;
        dfs(row, col+1);

    }

    static void sum() {
        int temp = 0;
        int ret = 0;

        for (int i=0; i<N; i++) {
            temp = 0;
            for (int j=0; j<M; j++) {
                if (visited[i][j]) {
                    temp *= 10;
                    temp += map[i][j];
                } else {
                    ret += temp;
                    temp = 0;
                }
            }
            ret += temp;
        }
        for (int i=0; i<M; i++) {
            temp = 0;
            for (int j=0; j<N; j++) {
                if (!visited[j][i]) {
                    temp *= 10;
                    temp += map[j][i];
                } else {
                    ret += temp;
                    temp = 0;
                }
            }
            ret += temp;
        }
        max = Math.max(max, ret);
    }

}
