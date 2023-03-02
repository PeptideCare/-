package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가르침_1062 {
    static int max = Integer.MIN_VALUE;
    static int N, K;
    static boolean[] visited;
    static String[] word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        word = new String[N];

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            s = s.substring(4, s.length()-4);
            word[i] = s;
        }

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        visited = new boolean[26];
        visited[0] = true; // a
        visited[13] = true; // n
        visited[19] = true; // t
        visited[8] = true; // i
        visited[2] = true; // c

        backtracking(0, 0);
        System.out.println(max);

    }

    public static void backtracking(int alpha, int len) {
        if(len == K - 5) {
            int count = 0;
            for(int i = 0; i < N; i++) {
                boolean read = true;
                for(int j = 0; j < word[i].length(); j++) {
                    if(!visited[word[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if(read) count++;
            }
            max = Math.max(max, count);
            return;
        }

        for(int i = alpha; i < 26; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                backtracking(i, len + 1);
                visited[i] = false;
            }
        }
    }
}
