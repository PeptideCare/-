package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178 {

    static int N;
    static int M;
    static int [][] map;
    static boolean [][] visited;
    static int min = Integer.MAX_VALUE;
    static Queue<Integer> countQ = new LinkedList<>();
    static int[] xlist = {1, 0, -1, 0};
    static int[] ylist = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<s.length(); j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        bfs(0,0);
        System.out.println(min);
    }

    static void bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        countQ.offer(1);
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int count = countQ.poll();
            if (poll[0] == N-1 && poll[1] == M-1) {
                min = Math.min(count, min);
                return;
            }
            for (int i=0; i<4; i++) {
                int a = poll[0] + xlist[i];
                int b = poll[1] + ylist[i];

                if (a<0 || b<0 || a>N-1 || b>M-1 || visited[a][b] == true || map[a][b] == 0) {
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
