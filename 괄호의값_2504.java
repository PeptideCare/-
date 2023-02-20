package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호의값_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();;

        Stack<Character> stack = new Stack<>();
        int result = 0;
        int value = 1;

        Loop:
        for (int i=0; i<s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push(s.charAt(i));
                    value *= 2;
                    break;
                case '[':
                    stack.push(s.charAt(i));
                    value *= 3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        result = 0;
                        break Loop;
                    } else if (s.charAt(i-1) == '(') {
                        result += value;
                    }
                    stack.pop();
                    value /= 2;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        result = 0;
                        break Loop;
                    } else if (s.charAt(i-1) == '[') {
                        result += value;
                    }
                    stack.pop();
                    value /= 3;
                    break;
            }
        }
        System.out.println(!stack.isEmpty() ? 0 : result);
    }
}
