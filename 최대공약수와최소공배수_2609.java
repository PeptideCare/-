package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수와최소공배수_2609 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        // 최대 공약수
        for (int i=a; i>0; i--) {
            if (a % i == 0 && b % i == 0) {
                System.out.println(i);
                break;
            }
        }

        // 최소 공배수
        int answer = 0;
        int i=1, j=1;
        while (true) {
            j = i;
            while (a*i >= b*j) {
                if (a*i == b*j) {
                    answer = a*i;
                    break;
                }
                j++;
            }
            if (answer!=0) break;
            i++;
        }
        System.out.println(answer);
    }
}
