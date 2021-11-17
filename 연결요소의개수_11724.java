package com.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연결요소의개수_11724 {

    static int N;
    static int M;
    static boolean[] visited;
    static int[][] check;
    static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[1001];
        check = new int[1001][1001];
        count = 0;

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            check[x][y] = 1;
            check[y][x] = 1;
        }

        for (int i=1; i<=N; i++) {
            if (visited[i] == true) continue;
            bfs(i);
        }
        System.out.println(count);
    }

    static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {

            int temp = q.poll();
            for (int i=1; i<=N; i++) {
                if (check[temp][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    q.offer(i);
                }
            }

        }
        count++;
    }

}
