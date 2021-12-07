package com.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 알고스팟_1261 {

    static int N, M;
    static int [][] map;
    static boolean [][] visited;
    static int min = Integer.MAX_VALUE;
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i=0; i<M; i++) {
            String s = br.readLine();
            for (int j=0; j<N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(min);

    }

    static void bfs() {

        PriorityQueue<Location> q = new PriorityQueue<>();
        q.offer(new Location(0,0,0));
        visited[0][0] = true;

        while (!q.isEmpty()) {

            Location poll = q.poll();

            if (poll.x == M-1 && poll.y == N-1) {
                min = Math.min(min, poll.time);
            }

            for (int i=0; i<4; i++) {

                Location next = new Location(poll.x+dx[i], poll.y+dy[i], poll.time);

                if (next.x < 0 || next.x > M-1 || next.y < 0 || next.y > N-1 || visited[next.x][next.y]) continue;

                if (map[next.x][next.y] == 1) {
                    next.addTime();
                }

                visited[next.x][next.y] = true;
                q.offer(next);

            }

        }

    }

    static class Location implements Comparable<Location>{
        int x;
        int y;
        int time;

        public Location(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public void addTime() {
            this.time += 1;
        }

        @Override
        public int compareTo(Location o) {
            return time - o.time;
        }
    }

}

