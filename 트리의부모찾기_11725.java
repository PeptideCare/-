package com.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725 {

    static int N;
    static ArrayList<Integer>[] list;
    static int [] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        parents = new int[N+1];

        for (int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        dfs(1, 0);

        for (int i=2; i<=N; i++) {
            System.out.println(parents[i]);
        }
    }

    static void dfs(int at, int parent) {

        parents[at] = parent;

        for (Integer val : list[at]) {
            if (val != parent) {
                dfs(val, at);
            }
        }

    }

}