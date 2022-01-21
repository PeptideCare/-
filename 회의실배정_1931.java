package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정_1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] time = new int[n+1][2];

        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[1] > o2[1]) return 1;
                else if (o1[1] == o2[1]) {
                    return o1[0]-o2[0];
                }
                return -1;
            }
        });

        int count = 0;
        int prevEnd = 0;

        for (int i=0; i<=n; i++) {
            if (prevEnd <= time[i][0]) {
                count++;
                prevEnd = time[i][1];
            }
        }
        System.out.println(count);
    }
}
