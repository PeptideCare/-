package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 소수_2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i=M; i<=N; i++) {
            if (checkDecimal(i)) list.add(i);
        }

        if (list.size() == 0) {
            System.out.println(-1);
        } else {
            Collections.sort(list);

            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            System.out.println(sum);
            System.out.println(list.get(0));
        }
    }

    public static boolean checkDecimal(int num) {
        if (num == 1) return false;

        for (int i=2; i<num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
