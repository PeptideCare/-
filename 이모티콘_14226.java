package com.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 이모티콘_14226 {

    static int S;
    static boolean visited[][];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        visited = new boolean[1001][1001];

        bfs();
    }

    static void bfs() {

        Queue<emoticon> q = new LinkedList<>();

        q.offer(new emoticon(0, 1, 0));
        visited[0][1] = true;

        while (!q.isEmpty()) {
            emoticon cur = q.poll();

            if (cur.screen == S) {
                System.out.println(cur.time);
                return;
            }

            q.offer(new emoticon(cur.screen, cur.screen, cur.time + 1));

            if (cur.clipboard != 0 && cur.screen + cur.clipboard <= S && !visited[cur.clipboard][cur.screen + cur.clipboard]){
                q.offer(new emoticon(cur.clipboard, cur.screen + cur.clipboard, cur.time + 1));
                visited[cur.clipboard][cur.screen + cur.clipboard] = true;
            }

            if (cur.screen >= 1 && !visited[cur.clipboard][cur.screen - 1]) {
                q.offer(new emoticon(cur.clipboard, cur.screen - 1, cur.time + 1));
                visited[cur.clipboard][cur.screen - 1] = true;
            }
        }
    }
}

class emoticon {
    int clipboard = 0;
    int screen = 0;
    int time = 0;

    emoticon(int clipboard, int screen, int time) {
        this.clipboard = clipboard;
        this.screen = screen;
        this.time = time;
    }
}
