package com.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 이분그래프_1707 {

    static List<Integer> graph[];
    static int visited[];
    static String result = "";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int i = 0;
        while (i++ < k) {
            result = "";
            int v = sc.nextInt();
            int e = sc.nextInt();
            visited = new int[v + 1];
            graph = new ArrayList[v + 1];

            for (int j = 1; j <= v; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 1; j <= e; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a].add(b);
                graph[b].add(a);
            }

            for (int j = 1; j <= v; j++) {
                if (visited[j] == 0) {
                    visited[j] = 1;
                    boolean re = dfs(j);
                    if (re == false) {
                        break;
                    }
                }
            }
            System.out.println(result);

        }
    }
    static boolean dfs(int x) {
        for(int a : graph[x]) {
            if(visited[a]==0) {
                visited[a] = visited[x]*-1;
                dfs(a);
            }
            else if(visited[a]==visited[x]) {
                result="NO";
                return false;
            }
        }
        if(result.equals("NO")) {
            return false;
        }
        result="YES";
        return true;
    }
}
