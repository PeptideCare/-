package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 지능형기차2_2460 {
    public static void main(String[] args) throws IOException {
        int[] people = new int[10];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            if (i != 0) people[i] = people[i-1];
            people[i] = people[i] - Integer.parseInt(st.nextToken());
            people[i] = people[i] + Integer.parseInt(st.nextToken());
        }

        Arrays.sort(people);

        System.out.println(people[people.length-1]);
    }
}
