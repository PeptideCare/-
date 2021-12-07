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
    static boolean[] visited;
    static int max = 100000;
    static int min = Integer.MAX_VALUE;
    static int [] dx = {-1, 1, 2};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        if (N == K) {
            System.out.println(0);
        } else {
            bfs();
            System.out.println(min);
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 0));

        while (!q.isEmpty()) {

            Node poll = q.poll();
            visited[poll.x] = true;
            if (poll.x == K) {
                min = Math.min(min, poll.time);
            }

            for (int i=0; i<3; i++) {

                Node next;
                if (i==2) next = new Node(poll.x*dx[i], poll.time);
                else if (i==1) next = new Node(poll.x+dx[i], poll.time+1);
                else next = new Node(poll.x+dx[i], poll.time+1);

                if (next.x < 0 || next.x > max || visited[next.x]) continue;
                q.offer(next);
            }

        }

    }

    static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

}


