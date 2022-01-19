package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 그룹단어체커_1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Character> list = new ArrayList<>();

        int count = 0;
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            if (s.length() == 1) {
                count++;
                continue;
            }
            boolean check = true;
            list = new ArrayList<>();
            for (int j=1; j<s.length(); j++) {
                char c = s.charAt(j);
                if (c != s.charAt(j-1)) {
                    list.add(s.charAt(j-1));
                }
                if (list.contains(c)) {
                    check = false;
                    break;
                }
            }
            if (check) count++;
        }
        System.out.println(count);
    }
}
