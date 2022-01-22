package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기_1010 {

    static int dp[][];
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            dp = new int[M+1][N+1];

            sb.append(combi(M,N)).append(System.getProperty("line.separator"));
        }
        System.out.println(sb);
    }

    static int combi(int m, int n) {

        if (n == m || n == 0) dp[m][n] = 1;

        if (dp[m][n] > 0) return dp[m][n];

        return dp[m][n] = combi(m-1, n-1) + combi(m-1, n);
    }
}
