package com.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {

    static int N;
    static int M;
    static int [][] map;
    static boolean [][] visited;
    static int min = Integer.MAX_VALUE;
    static int count;
    static Queue<Integer> countQ = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M+1][N+1];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == 1) {
                    visited = new boolean[M][N];
                    bfs(i, j);
                    min = Math.min(min, count);
                }
            }
        }
        System.out.println(min);
    }

    static void bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        countQ.offer(0);
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            count = countQ.poll();

            for (int i=0; i<4; i++) {
                int a = poll[0] + dx[i];
                int b = poll[1] + dy[i];

                if (a<0 || b<0 || a>M-1 || b>N-1 || visited[a][b] == true || map[a][b] == -1 || map[a][b] == 1) {
                    continue;
                } else {
                    q.offer(new int[]{a,b});
                    countQ.offer(count+1);
                    visited[a][b] = true;
                }
            }
        }
    }
}
