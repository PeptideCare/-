package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최소_최대_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String nums = br.readLine();
        String[] num = nums.split(" ");
        int max = -1000000;
        int min = 1000000;

        for (int i=0; i<N;i ++) {
            if (max < Integer.parseInt(num[i])) max = Integer.parseInt(num[i]);
            if (min > Integer.parseInt(num[i])) min = Integer.parseInt(num[i]);
        }

        System.out.println(min + " " + max);
    }
}
