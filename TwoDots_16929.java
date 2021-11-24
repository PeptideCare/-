package com.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoDots_16929 {

    static int N;
    static int M;
    static int startX;
    static int startY;
    static char startC;
    static char [][] map;
    static boolean [][] visited;
    static int dx [] = {0, 1, 0, -1};
    static int dy [] = {1, 0, -1, 0};
    static String ans = "No";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                visited = new boolean[N][M];
                startC = map[i][j];
                startX = i;
                startY = j;
                dfs(i,j, 0);
            }

            int count = 0;
            for (int j=0; j<4; j++) {
                int a = startX + dx[i];
                int b = startY + dy[i];

                if (visited[a][b])
            }
        }

        System.out.println(ans);
    }

    static void dfs(int x, int y, int depth) {

        if (x<0 || y<0 || x>N-1 || y>M-1) {
            return;
        }

        if (map[x][y] == startC && visited[x][y] == false) {

            visited[x][y] = true;
            dfs(x+1, y, depth+1);
            dfs(x, y+1, depth+1);
            dfs(x-1, y, depth+1);
            dfs(x, y-1, depth+1);
        } else {
            return;
        }
    }
}
