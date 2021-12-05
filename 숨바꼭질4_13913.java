package com.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 숨바꼭질4_13913 {

    static int N;
    static int K;
    static int num;
    static int arr[];
    static int ans[];
    static int dx[] = {-1, 1, 2};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        ans = new int[100001];

        bfs();

        num = arr[K]-1;

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(ans[index]);
            index = ans[index];
        }

        System.out.println(num);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }

    static void bfs() {

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        arr[N] = 1;

        while (!q.isEmpty()) {

            int poll = q.poll();

            for (int i=0; i<3; i++) {
                int a;
                if (i==2) {
                    a = poll*dx[i];
                } else {
                    a = poll+dx[i];
                }

                if (a < 0|| a >= arr.length || arr[a] != 0) continue;

                q.offer(a);
                arr[a] = arr[poll] + 1;
                ans[a] = poll;

                if (a == K) return;
            }

        }


    }

}
