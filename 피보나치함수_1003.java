package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수_1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {

            int n = Integer.parseInt(br.readLine());

            int zeroCount[] = new int[n+1];
            int oneCount[] = new int[n+1];

            zeroCount[0] = 1;
            oneCount[0] = 0;
            if (n >= 1){
                zeroCount[1] = 0;
                oneCount[1] = 1;
            }

            for (int j=2; j<=n; j++) {
                zeroCount[j] = zeroCount[j-2] + zeroCount[j-1];
                oneCount[j] = oneCount[j-2] + oneCount[j-1];
            }

            sb.append(zeroCount[n]).append(" ").append(oneCount[n]).append(System.getProperty("line.separator"));
        }

        System.out.println(sb.toString());

    }

}
