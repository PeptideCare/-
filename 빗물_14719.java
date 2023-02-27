package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물_14719 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = 0;
        int w = 0;

        while (st.hasMoreTokens()) {
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int[] height = new int[w];

        for (int i=0; i<w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i=1; i<w-1; i++) {
            int left = 0;
            int right = 0;

            for (int j=0; j<i; j++) {
                left = Math.max(height[j], left);
            }

            for (int j=i+1; j<w; j++) {
                right = Math.max(height[j], right);
            }

            if (height[i] < left && height[i] < right) {
                result += Math.min(left, right) - height[i];
            }
        }

        System.out.println(result);
    }
}
