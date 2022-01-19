package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_1697 {

    static int N;
    static int K;
    static boolean visited[];
    static int arr[];
    static int[] dx = {-1, 1, 2};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        visited = new boolean[100001];

        if (N == K) {
            System.out.println(0);
        } else {
            bfs();

            System.out.println(arr[K]);
        }
    }

    static void bfs() {

        Queue<Integer> q = new LinkedList<>();
        visited[N] = true;
        q.offer(N);


        while (!q.isEmpty()) {

            int poll = q.poll();

            for (int i=0; i<3; i++) {
                int num;
                if (i==2) {
                    num = poll*dx[i];
                } else {
                    num = poll+dx[i];
                }

                if (num < 0 || num >= visited.length || visited[num]) continue;

                q.offer(num);
                arr[num] = arr[poll] + 1 ;

                if (num == K) return;

                visited[num] = true;
            }
        }
    }
}
