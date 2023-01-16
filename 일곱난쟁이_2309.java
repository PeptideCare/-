package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 일곱난쟁이_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] people = new int[9];
        for (int i=0; i<9; i++) {
            people[i] = Integer.parseInt(br.readLine());
        }

        ArrayList<Integer> list = new ArrayList<>();

        Loop :
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (i==j) continue;
                for (int h=0; h<9; h++) {
                    if (h==i || h==j) continue;
                    list.add(people[h]);
                }
                int sum = 0;
                for (Integer integer : list) {
                    sum += integer;
                }
                if (sum == 100) break Loop;
                else list.clear();
            }
        }

        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
