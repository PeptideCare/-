package com.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549 {

    static int N;
    static int K;
    static int[] arr;
    static int[] dx = {-1, 1, 2};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[100001];

        if (N == K) {
            System.out.println(0);
        } else {
            bfs();
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        arr[N] = 1;

        while (!q.isEmpty()) {

            int poll = q.poll();

            for (int i=0; i<3; i++) {
                int next;
                if (i == 2) {
                    next = poll*dx[i];
                    if (next < 0 || next >= arr.length) continue;
                    arr[next] = Math.min(arr[poll], arr[next]);
                    q.offer(next);
                } else {
                    next = poll+dx[i];
                    if (next < 0 || next >= arr.length) continue;
                    arr[next] = Math.min(arr[poll]+1, arr[next]);
                    q.offer(next);
                }

                if (next == K) {
                    System.out.println(arr[next]-1);
                    return;
                }

            }

        }

    }

}
