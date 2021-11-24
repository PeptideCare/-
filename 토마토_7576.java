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
    static int min = Integer.MIN_VALUE;
    static Queue<int[]> q = new LinkedList<>();
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
                    q.offer(new int[]{i,j});
                }
            }
        }

        bfs();

        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                min = Math.max(min, map[i][j]-1);
            }
        }

        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == 0) {
                    min = -1;
                }
            }
        }

        System.out.println(min);
    }

    static void bfs() {

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i=0; i<4; i++) {
                int a = poll[0] + dx[i];
                int b = poll[1] + dy[i];

                if (a>=0 && b>=0 && a<=M-1 && b<=N-1) {
                    if (map[a][b] == 0) {
                        q.offer(new int[]{a,b});
                        map[a][b] = map[poll[0]][poll[1]] + 1;
                    }
                }
            }
        }
    }
}
