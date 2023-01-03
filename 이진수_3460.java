package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 이진수_3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            String binary = Integer.toBinaryString(n);

            ArrayList<Character> list = new ArrayList<>();
            for (int j=0; j<binary.length(); j++) {
                list.add(binary.charAt(j));
            }

            Collections.reverse(list);

            for (int j=0; j<list.size(); j++) {
                if (list.get(j) == '1') {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}
