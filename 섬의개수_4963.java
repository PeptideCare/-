package com.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬의개수_4963 {

    static int [][] map;
    static boolean [][] visited;
    static int w;
    static int h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h+1][w+1];
            visited = new boolean[h+1][w+1];

            if (w==0 && h==0) break;

            for (int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int count = 0;
            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (map[i][j] == 1 && visited[i][j] == false) {
                        dfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int x, int y) {

        if (x>h-1 || x<0 || y<0 || y>w-1 || map[x][y] == 0 || visited[x][y] == true){
            return;
        }

        visited[x][y] = true;

        dfs(x+1, y);
        dfs(x, y+1);
        dfs(x-1, y);
        dfs(x, y-1);

        dfs(x+1, y+1);
        dfs(x+1, y-1);
        dfs(x-1, y+1);
        dfs(x-1, y-1);

    }
}
