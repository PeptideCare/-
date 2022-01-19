package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 단지번호붙이기_2667 {

    static int [][] map;
    static boolean [][] visited;
    static int N;
    static int count;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<s.length(); j++) {
                map[i][j] = s.charAt(j) -'0';
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    if (count != 0) {
                        list.add(count);
                    }
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    static void dfs(int x, int y) {

        if (x>N-1 || x<0 || y<0 || y>N-1 || map[x][y] == 0 || visited[x][y] == true){
            return;
        } else {
            count++;
        }

        visited[x][y] = true;

        dfs(x+1, y);
        dfs(x, y+1);
        dfs(x-1, y);
        dfs(x, y-1);

    }

}
