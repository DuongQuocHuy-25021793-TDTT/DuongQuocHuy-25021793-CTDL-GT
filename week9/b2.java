package week9;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution {

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }


    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        if (!scan.hasNextInt()) return;
        int t = scan.nextInt();
        Node root = null;

        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }

        if (scan.hasNextInt()) {
            int valToInsert = scan.nextInt();
            root = insert(root, valToInsert);
        }

        scan.close();


        preOrder(root);
    }
}