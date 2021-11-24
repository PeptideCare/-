package com.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동_7562 {

    static int I;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {

            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            visited = new boolean[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int ans = bfs(x,y,x2,y2);
            sb.append(ans).append(System.getProperty("line.separator"));
        }
        System.out.println(sb);
    }

    static int bfs(int x, int y, int x2, int y2) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        while (!q.isEmpty()) {

            int[] poll = q.poll();

            if (poll[0] == x2 && poll[1] == y2) {
                return map[poll[0]][poll[1]];
            }

            for (int i=0; i<8; i++) {
                int a = poll[0] + dx[i];
                int b = poll[1] + dy[i];

                if (a>=0 && b>=0 && a<=I-1 && b<=I-1 && visited[a][b] == false) {
                    q.offer(new int[]{a,b});
                    visited[a][b] = true;
                    map[a][b] = map[poll[0]][poll[1]] + 1;
                }
            }
        }
        return 0;
    }

}
