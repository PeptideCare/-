package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 열개씩끊어출력하기_11721 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb = new StringBuilder();
        String s = br.readLine();

        for (int i=0; i<s.length(); i+=10) {

            if (i+10 > s.length()) {
                sb.append(s.substring(i));
                break;
            } else {
                sb.append(s.substring(i, i+10));
                sb.append(System.getProperty("line.separator"));
            }
        }
        System.out.println(sb.toString());
    }
}
