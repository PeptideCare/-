package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈_5585 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int changes[] = {500,100,50,10,5,1};

        int n = Integer.parseInt(br.readLine());

        int change = 1000-n;
        int count = 0;

        while (change!=0) {
            for (int i=0; i<changes.length; i++) {
                if (change >= changes[i]) {
                    change-=changes[i];
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
