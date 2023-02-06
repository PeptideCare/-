package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 쉽게푸는문제_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i=1; i<=b; i++) {
            int count = 1;
            while (count <= i) {
                list.add(i);
                count++;
            }
            if (b <= list.size()) break;
        }

        int sum = 0;
        for (int i=a; i<=b; i++) {
            sum += list.get(i-1);
        }
        System.out.println(sum);
    }
}
