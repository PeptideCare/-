package com.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회_1991 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tree.add(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);

    }

}

class Node {
    char data;
    Node left, right;

    public Node(char data) {
        this.data = data;
    }
}

class Tree {
    Node root;

    public void add(char data, char left, char right) {
        if (root == null) {
            if (data!='.') root = new Node(data);
            if (left!='.') root.left = new Node(left);
            if (right!='.') root.right = new Node(right);
        }
        else {
            search(root, data, left, right);
        }
    }

    public void search(Node root, char data, char left, char right) {
        if (root == null) return;
        else if (root.data == data) {
            if (left!='.') root.left = new Node(left);
            if (right!='.') root.right = new Node(right);
        }
        else {
            search(root.left, data, left, right);
            search(root.right, data, left, right);
        }
    }

    public void preOrder(Node root) {
        System.out.print(root.data);
        if (root.left!=null) preOrder(root.left);
        if (root.right!=null) preOrder(root.right);
    }

    public void inOrder(Node root) {
        if (root.left!=null) inOrder(root.left);
        System.out.print(root.data);
        if (root.right!=null) inOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root.left!=null) postOrder(root.left);
        if (root.right!=null) postOrder(root.right);
        System.out.print(root.data);
    }

}
