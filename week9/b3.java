package week9;
import java.util.*;
import java.io.*;

class Node1 {
    int data;
    Node left;
    Node right;

    Node1(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution1 {

    public static Node lca(Node root, int v1, int v2) {
        Node curr = root;

        while (curr != null) {

            if (v1 < curr.data && v2 < curr.data) {
                curr = curr.left;
            }

            else if (v1 > curr.data && v2 > curr.data) {
                curr = curr.right;
            }

            else {
                return curr;
            }
        }

        return null;
    }


    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            if (data <= root.data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        if (!scan.hasNextInt()) {
            scan.close();
            return;
        }

        int n = scan.nextInt();
        Node root = null;

        for (int i = 0; i < n; i++) {
            int data = scan.nextInt();
            root = insert(root, data);
        }

        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();

        Node ans = lca(root, v1, v2);
        if (ans != null) {
            System.out.println(ans.data);
        }
    }
}
