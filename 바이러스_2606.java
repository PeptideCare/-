package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 바이러스_2606 {

    static List<Integer> graph[];
    static int count = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        graph = new List[n+1];

        for (int i=1; i<n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        bfs();

        System.out.println(count-1);

    }

    static public void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {

            List<Integer> list = graph[q.poll()];
            count++;
            for (int i=0; i<list.size(); i++) {

                int num = list.get(i);

                if (visited[num]) continue;
                q.offer(num);
                visited[num] = true;
            }

        }
    }

}
