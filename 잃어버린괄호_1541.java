package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잃어버린괄호_1541 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        boolean check = true;
        StringTokenizer minus = new StringTokenizer(br.readLine(), "-");

        while (minus.hasMoreTokens()) {
            int temp = 0;

            StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");

            while (plus.hasMoreTokens()) {
                temp+=Integer.parseInt(plus.nextToken());
            }

            if (check) {
                sum = temp;
                check = false;
            } else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}
